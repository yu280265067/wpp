package com.ycx.wpp.core.hystrix.command;

/**
 * Created by ycx on 2018/4/17.
 */
public enum HystrixCommandGroupKeyEnum {
    SENSITIVE_WORD_VALIDATE_COMMAND("sensitive_word_validate_command", 32, 4000, 4000, true, true, true, 1500);

    String groupKey;
    int coreSize;
    int maxQueueSize;
    int queueSizeRejectionThreshold;
    boolean circuitBreakerEnabled;
    boolean fallbackEnabled;
    boolean executionTimeoutenabled;
    int executionTimeoutInMilliseconds;

    HystrixCommandGroupKeyEnum(String groupKey, int coreSize, int maxQueueSize, int queueSizeRejectionThreshold, boolean circuitBreakerEnabled, boolean fallbackEnabled, boolean executionTimeoutenabled, int executionTimeoutInMilliseconds) {
        this.groupKey = groupKey;
        this.coreSize = coreSize;
        this.maxQueueSize = maxQueueSize;
        this.queueSizeRejectionThreshold = queueSizeRejectionThreshold;
        this.circuitBreakerEnabled = circuitBreakerEnabled;
        this.fallbackEnabled = fallbackEnabled;
        this.executionTimeoutenabled = executionTimeoutenabled;
        this.executionTimeoutInMilliseconds = executionTimeoutInMilliseconds;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public int getCoreSize() {
        return coreSize;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public int getQueueSizeRejectionThreshold() {
        return queueSizeRejectionThreshold;
    }

    public boolean isCircuitBreakerEnabled() {
        return circuitBreakerEnabled;
    }

    public boolean isFallbackEnabled() {
        return fallbackEnabled;
    }

    public boolean isExecutionTimeoutenabled() {
        return executionTimeoutenabled;
    }

    public int getExecutionTimeoutInMilliseconds() {
        return executionTimeoutInMilliseconds;
    }
}
