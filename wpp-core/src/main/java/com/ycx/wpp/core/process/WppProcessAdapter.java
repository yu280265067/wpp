package com.ycx.wpp.core.process;

/**
 * Created by apple on 2018/5/9.
 */
public abstract class WppProcessAdapter implements WppProcess{
    /**
     * 处理函数，抽象出接收到消息后的处理逻辑
     * @param
     */
    public void process(Integer num){
        System.out.println("WppProcessAdapter run");
        productPriceEdit(1);
        productStockEdit(2);
    };

    /**
     * 商品价格变更
     */
    @Override
    public void productPriceEdit(Integer num){};

    /**
     * 商品库存变更
     */
    @Override
    public void productStockEdit(Integer num){};

}
