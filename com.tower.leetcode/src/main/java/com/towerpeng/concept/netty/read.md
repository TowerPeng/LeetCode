Netty 的核心组件
Channel
代表一个网络连接（如 NioSocketChannel、NioServerSocketChannel），负责基本的 I/O 操作（bind、connect、read、write）。
EventLoop
本质上是一个单线程执行器（死循环），负责处理 Channel 上的 I/O 事件（accept、read、write）。一个 EventLoop 可以服务于多个 Channel，但一个 Channel 在其生命周期内只会绑定到一个固定的 EventLoop。
EventLoopGroup
一组 EventLoop 的集合。通常分为 bossGroup（处理 accept 事件）和 workerGroup（处理读写事件）。
ChannelPipeline
一个 Handler 责任链，管理所有 ChannelHandler。当数据流入（读取）或流出（写入）时，会依次经过 pipeline 上的 handler 处理。
ChannelHandler
业务逻辑的载体，如解码器、编码器、业务处理。常见子类：ChannelInboundHandler（处理入站数据）、ChannelOutboundHandler（处理出站数据）。
ByteBuf
字节容器，替代 JDK 的 ByteBuffer，提供更灵活、更高效的缓冲区操作（如池化、引用计数、零拷贝）。
ChannelFuture
异步操作的结果占位符，可通过监听器在操作完成后获得通知，实现非阻塞编程。

Netty 采用多路复用（Selector）和多线程结合的 Reactor 模型，典型配置是主从 Reactor 模型（通常称为 Boss 和 Worker）：
Boss Group
通常包含一个或多个 EventLoop（实际为 NioEventLoop），专门处理 accept 事件（即客户端连接请求）。当有新的连接进来时，boss 线程会创建一个 NioSocketChannel 并将其注册到 worker 线程的 selector 上。
Worker Group
通常包含多个 EventLoop，每个 EventLoop 持有一个 Selector，负责处理已注册 Channel 的 read/write 事件。worker 线程将事件分发给对应的 pipeline 进行处理。
流程示例：
客户端连接到达 → boss 线程轮询到 OP_ACCEPT → 创建 NioSocketChannel → 将 Channel 注册到某个 worker 线程的 selector 上。
worker 线程轮询到 OP_READ → 从 Channel 读取数据 → 触发 pipeline 上的 inbound 处理器（解码、业务逻辑等）→ 输出结果（触发 outbound 处理器）→ 写入 Channel。