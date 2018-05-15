package com.ycx.wpp.core.process;

import org.springframework.stereotype.Service;

/**
 * Created by apple on 2018/5/9.
 */
@Service
public class TestOneProcessor extends WppProcessAdapter {

    @Override
    public void productPriceEdit(Integer num) {
        System.out.println("productPriceEdit TestOneProcessor");
    }

    @Override
    public void productStockEdit(Integer num) {
        System.out.println("productStockEdit TestOneProcessor");
    }
}
