package com.rmkj.microcap.common.modules.pay.nineeight.bean;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/1/6.
 */
public class QuickPayRequestParam {
    @NotNull
    private String money;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
