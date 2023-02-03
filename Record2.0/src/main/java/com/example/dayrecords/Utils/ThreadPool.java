package com.example.dayrecords.Utils;

import java.util.concurrent.*;

/**
 * 创建线程池
 */
public class ThreadPool extends Thread{

    /**
     * FixedThreadPool ：
     *
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     */
    private static ExecutorService executor = new ThreadPoolExecutor(10, 20,
            60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue(10));
    /**
     * newCachedThreadPool
     * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     */
    public static ExecutorService newExecutorService = Executors.newCachedThreadPool();
    /**
     * 缓存线程池
     */
    public static ExecutorService cacheExecutorService = Executors.newCachedThreadPool();
}
