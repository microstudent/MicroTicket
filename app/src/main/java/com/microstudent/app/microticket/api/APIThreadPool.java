package com.microstudent.app.microticket.api;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池
 * Created by MicroStudent on 2016/4/7.
 */
public class APIThreadPool {
    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "APIRequest#" + mCount.getAndIncrement());
        }
    };

    public static final ExecutorService THREAD_POOL_EXECUTOR = Executors.newCachedThreadPool(sThreadFactory);
}
