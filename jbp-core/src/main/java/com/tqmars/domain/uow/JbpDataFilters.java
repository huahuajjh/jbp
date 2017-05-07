package com.tqmars.domain.uow;

/**
 * Created by jjh on 5/6/17.
 */
public class JbpDataFilters {
    public final String SOFT_DELETE = "softDelete";
    public final String MUST_HAVE_TENANT = "mustHaveTenant";
    public final String MAY_HAVE_TENANT = "mayHaveTenant";

    public static class Parameters{
        public final String tenantId = "tenantId";
    }
}
