package com.tqmars.runtime.session;

/**
 * Created by jjh on 17-5-4.
 * Defines some session information that can be useful for applications.
 */
public interface IJbpSession {
    long getUserId();
    void setUserId(long _id);

    int getTenantId();
    void setTenantId(int _id);
}
