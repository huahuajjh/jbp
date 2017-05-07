package com.tqmars.domain.uow;

import com.tqmars.multiTenancy.MultiTenancySides;

import java.util.HashMap;

/**
 * Created by jjh on 5/5/17.
 */
public class ConnectionStringResolveArgs extends HashMap<String, Object> {
    private MultiTenancySides multiTenancySide;

    public MultiTenancySides getMultiTenancySide() {
        return multiTenancySide;
    }

    public void setMultiTenancySide(MultiTenancySides multiTenancySide) {
        this.multiTenancySide = multiTenancySide;
    }

}
