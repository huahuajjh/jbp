package com.tqmars.domain.uow;

/**
 * Created by jjh on 17-5-4.
 */
public interface IUnitOfWorkFilterHandler {
    public void applyDisableFilter(IUnitOfWork uow,String filterName);
    public void applyEnableFilter(IUnitOfWork uow,String filterName);
    public void applyFilterParameterValue(IUnitOfWork uow,String filterName,String parameterName,Object value);
}
