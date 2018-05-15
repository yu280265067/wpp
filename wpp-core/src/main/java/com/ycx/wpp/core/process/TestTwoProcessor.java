package com.ycx.wpp.core.process;

import org.springframework.stereotype.Service;

/**
 * Created by apple on 2018/5/9.
 */
@Service
public class TestTwoProcessor extends WppProcessAdapter {

    @Override
    public void productPriceEdit(Integer num) {
        System.out.println("productPriceEdit TestTwoProcessor");
    }

    @Override
    public void productStockEdit(Integer num) {
        System.out.println("productStockEdit TestTwoProcessor");
    }
}
