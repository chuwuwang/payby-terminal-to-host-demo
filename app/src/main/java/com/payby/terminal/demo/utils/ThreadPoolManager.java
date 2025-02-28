package com.payby.terminal.demo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolManager {
    private static final ExecutorService cachePoolExecutor = Executors.newCachedThreadPool();

    private ThreadPoolManager(){}

    public static void executeCacheTask(Runnable runnable) {
        cachePoolExecutor.execute(runnable);
    }
}
