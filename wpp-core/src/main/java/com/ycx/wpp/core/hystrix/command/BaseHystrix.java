package com.ycx.wpp.core.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * Created by ycx on 2018/4/17.
 */
public class BaseHystrix {

    public static abstract class WmHystrixCommand<R> extends HystrixCommand<R>{

        protected R result;

        public WmHystrixCommand(HystrixCommandGroupKeyEnum groupKey) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey.getGroupKey()))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)// 隔离策略
                            .withCircuitBreakerEnabled(groupKey.isCircuitBreakerEnabled())// 熔断器是否起作用
                            .withFallbackEnabled(groupKey.isFallbackEnabled())// 当故障或者拒绝发生时，是否调用fallback
                            .withExecutionTimeoutEnabled(groupKey.isExecutionTimeoutenabled())
                            .withExecutionTimeoutInMilliseconds(groupKey.getExecutionTimeoutInMilliseconds())
                    )
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                            .withCoreSize(groupKey.getCoreSize())// 线程数量
                            .withMaxQueueSize(groupKey.getMaxQueueSize())// 队列长度
                            .withQueueSizeRejectionThreshold(groupKey.getQueueSizeRejectionThreshold())// 队列拒绝写入长度
                    ))
            ;
        }

        @Override
        protected R run() throws Exception {
            this.doBiz();
            return result;
        }

        protected abstract void doBiz() throws Exception;
    }
}
