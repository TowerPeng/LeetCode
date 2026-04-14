//package com.towerpeng.concept.ratelimit;
//
//
//import com.sun.source.tree.Tree;
//
//import java.util.*;
//
//public class TokenBucketLimiter {
//    private static final String REDIS_HOST = "localhost";
//    private static final int REDIS_PORT = 6379;
//    private static final Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
//
//    // 令牌桶参数
//    private static final int BUCKET_CAPACITY = 10;  // 最大令牌数
//    private static final int TOKEN_RATE = 1;  // 每秒生成的令牌数
//
//    // Redis 中的 key 名称
//    private static final String TOKEN_BUCKET_KEY = "token_bucket";
//
//    public static boolean acquire() {
//        long currentTime = System.currentTimeMillis() / 1000;
//
//        // 获取当前桶的时间戳和令牌数量
//        String bucketData = jedis.get(TOKEN_BUCKET_KEY);
//
//        // 如果桶还没有初始化，初始化桶
//        if (bucketData == null) {
//            jedis.setex(TOKEN_BUCKET_KEY, BUCKET_CAPACITY, String.valueOf(currentTime));
//        }
//
//        long lastRefillTime = Long.parseLong(jedis.get(TOKEN_BUCKET_KEY));
//        long tokensToAdd = (currentTime - lastRefillTime) * TOKEN_RATE;
//
//        // 计算桶内当前令牌数，最大不超过桶容量
//        int currentTokens = Math.min((int) tokensToAdd, BUCKET_CAPACITY);
//
//        if (currentTokens > 0) {
//            // 执行令牌扣除
//            jedis.setex(TOKEN_BUCKET_KEY, BUCKET_CAPACITY, String.valueOf(currentTime));  // 重设时间戳
//            return true;  // 请求通过
//        }
//        return false;  // 请求被拒绝
//    }
//
//    // 关闭连接
//    public static void close() {
//        jedis.close();
//    }
//
//    public static void main(String[] args) {
//        TokenBucketLimiter limiter = new TokenBucketLimiter();
//
//        // 模拟 15 次请求
//        for (int i = 0; i < 15; i++) {
//            if (limiter.acquire()) {
//                System.out.println("Request " + (i + 1) + " allowed");
//            } else {
//                System.out.println("Request " + (i + 1) + " rejected");
//            }
//        }
//
//        limiter.close();
//    }
//
//
//    public String sortSentence(String s) {
//        String [] split = s.split(" ");
//        TreeMap<Integer,String> map = new TreeMap<>();
//        for(int i = 0;i<split.length;i++){
//            String str = split[i];
//            char[] charArr = str.toCharArray();
//            char[] copy = Arrays.copyOf(charArr,charArr.length-1);
//            map.put(Integer.valueOf(charArr[charArr.length-1]),String.valueOf(copy));
//        }
//        StringBuilder sb = new StringBuilder();
//        for(Map.Entry<Integer,String> entry : map.entrySet()){
//            sb.append(entry.getValue()).append(" ");
//        }
//        return sb.toString();
//    }
//
//
//    public static int findMaxK(int[] nums) {
//        Arrays.sort(nums);
//        if(nums[0]==-nums[nums.length-1]){
//            return nums[nums.length-1];
//        }
//        return -1;
//    }
//}