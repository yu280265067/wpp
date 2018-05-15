package com.ycx.wpp.core.process;

/**
 * Created by apple on 2018/5/9.
 */
public interface WppProcess {
    /**
     * 处理函数，抽象出接收到消息后的处理逻辑
     * @param
     */
    void process(Integer num);

    /**
     * 商品价格变更
     */
    void productPriceEdit(Integer num);

    /**
     * 商品库存变更
     */
    void productStockEdit(Integer num);

}
