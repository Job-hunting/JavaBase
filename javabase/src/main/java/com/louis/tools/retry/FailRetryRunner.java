package com.louis.tools.retry;/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 *//*

package com.louis.tools.retry;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailRetryRunner {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private int retryNumber = 3;
    private int waitTimeMills = 100;


    public FailRetryRunner(int retryNumber, int waitTimeMills) {
        this.retryNumber = retryNumber;
        this.waitTimeMills = waitTimeMills;
    }

    public FailRetryRunner() {
    }

    public <V> V execute(Callable<V> callable) {
        for (int i = 0; i < retryNumber; i++) {
            try {
                return callable.call();
            } catch (Exception e) {
                logger.warn("FailRetryRunner execute with exception: "
                        + e.getClass().getCanonicalName() + ", retry...", e);
                try {
                    Thread.sleep(waitTimeMills);
                } catch (InterruptedException e1) {
                    logger.error("interrupt", e1);
                }
            }
        }
        throw new RuntimeException("FailRetryRunner execute callble failed with " + retryNumber + " times.");
    }
}
*/
