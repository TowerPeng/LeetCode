Transcational事务实现原理：
@Transcational是Spring框架管理声明式事务的核心注解，其底层实现基于AOP和动态代理机制。简单来说，Spring在运行时标记了@Transcational的Bean创建了一个代理对象，由代理对象来管理事务的开启、提交和回滚，而原有的业务代码则被无感包裹在这个事务流程中。
1、Spring通过@EnableTransactionManagement 注解，在容器中注册一个关键的后置处理器。
初始化创建Bean的时候，InfrastructureAdvisorAutoProxyCreator（一个BeanPostProcessor） 会介入检查，判断类上是否有@Transcational注解，
如果匹配成功，则会生成Bean的代理对象，（JDK动态代理或者CGLIB动态代理），
这个对象持有TranscationInterceptor事务拦截器，用户后续方法调用。
解析注解：AnnotationTransactionAttributeSource 负责解析@Transcational注解的属性，如 propagation, isolation, rollbackFor 等，
将其封装为TranscationAttribute对象，存储在缓存中供后续使用。
2、核心入口：
TransactionInterceptor 实现了 MethodInterceptor 接口，其核心方法 invoke() 最终调用父类 TransactionAspectSupport 的 invokeWithinTransaction 方法。

// TransactionAspectSupport.invokeWithinTransaction 逻辑解析
protected Object invokeWithinTransaction(Method method, @Nullable Class<?> targetClass,
final InvocationCallback invocation) throws Throwable {
    // 1. 获取事务属性 (从@Transactional注解解析)
    TransactionAttributeSource tas = getTransactionAttributeSource();
    TransactionAttribute txAttr = (tas != null ? tas.getTransactionAttribute(method, targetClass) : null);
    // 2. 确定事务管理器 (PlatformTransactionManager)
    PlatformTransactionManager tm = determineTransactionManager(txAttr);
    // 3. 关键点：根据传播行为获取事务状态
    TransactionInfo txInfo = createTransactionIfNecessary(tm, txAttr, joinpointIdentification);
    Object retVal = null;
    try {
        // 4. 执行目标业务方法
        retVal = invocation.proceedWithInvocation();
    } catch (Throwable ex) {
        // 5. 异常处理：根据规则决定回滚
        completeTransactionAfterThrowing(txInfo, ex);
        throw ex;
    } finally {
        // 清理事务信息
        cleanupTransactionInfo(txInfo);
    }
    // 6. 正常返回：提交事务
    commitTransactionAfterReturning(txInfo);
    return retVal;
}
事务的获取与绑定createTransactionIfNecessary
此阶段是事务管理的核心，涉及 PlatformTransactionManager 的具体实现（如 DataSourceTransactionManager）：
获取连接：通过 DataSourceUtils.getConnection() 获取数据库连接，并设置为手动提交（setAutoCommit(false)）。
传播行为处理：根据 TransactionAttribute 的传播行为决定是挂起当前事务、新建事务还是加入现有事务。例如 REQUIRES_NEW 总是会挂起当前存在的事务并创建一个新连接 。
绑定线程：将连接和事务状态绑定到 TransactionSynchronizationManager 的 ThreadLocal 中，确保在同一线程的后续 DAO 操作能获取到同一个连接 。

回滚判断：在 completeTransactionAfterThrowing 中，会根据 rollbackFor / noRollbackFor 规则判断异常是否触发回滚。默认情况下，只有 RuntimeException 和 Error 才会回滚 。
提交：如果方法正常执行，commitTransactionAfterReturning 会调用事务管理器的 commit 方法，最终执行数据库 commit 操作


事务失效的场景：
1、只认RuntimeException和Error，
2、try catch处理了异常，不执行事务，
3、类里this调用事务方法不触发动态代理，
4、private 方法加@Transcational注解，public才生效
5、final 方法，static方法加@Transcational注解，CGLIB无法代理，
6、配置了requires_new 传播属性，新开启事务，
7、新开线程执行事务，ThreadLocal无法共享
8、数据库用ISAM引擎，不支持事务