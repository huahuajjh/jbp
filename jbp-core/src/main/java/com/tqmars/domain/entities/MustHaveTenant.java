package com.tqmars.domain.entities;

/**
 * Created by jjh on 17-3-19.
 */
public abstract class MustHaveTenant implements IMustHaveTenant{
    protected int tenantId;

    @Override
    public int getTenantId() {
        return tenantId;
    }
}
