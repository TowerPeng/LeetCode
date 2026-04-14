//package com.towerpeng.concept.ratelimit;
//
//public class LeakyBucketLimiter {
//    private static final String REDIS_HOST = "localhost";
//    private static final int REDIS_PORT = 6379;
//    private static final Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
//
//    // 漏桶参数
//    private static final int BUCKET_CAPACITY = 10;  // 最大请求数
//    private static final int LEAK_RATE = 1;  // 每秒处理的请求数
//
//    // Redis 中的 key 名称
//    private static final String LEAKY_BUCKET_KEY = "leaky_bucket";
//
//    public static boolean acquire() {
//        long currentTime = System.currentTimeMillis() / 1000;
//
//        // 获取桶的数据
//        String bucketData = jedis.get(LEAKY_BUCKET_KEY);
//
//        // 如果桶数据为空，初始化桶
//        if (bucketData == null) {
//            jedis.setex(LEAKY_BUCKET_KEY, BUCKET_CAPACITY, String.valueOf(currentTime));
//        }
//
//        long lastRefillTime = Long.parseLong(jedis.get(LEAKY_BUCKET_KEY));
//        long requestCount = (currentTime - lastRefillTime) * LEAK_RATE;
//
//        // 当前水量 = 已请求数 + 新的请求数
//        int currentWaterLevel = Math.min((int) requestCount, BUCKET_CAPACITY);
//
//        // 如果水量未满，允许请求
//        if (currentWaterLevel < BUCKET_CAPACITY) {
//            // 设置桶的时间戳
//            jedis.setex(LEAKY_BUCKET_KEY, BUCKET_CAPACITY, String.valueOf(currentTime));
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
//        LeakyBucketLimiter limiter = new LeakyBucketLimiter();
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
//}
