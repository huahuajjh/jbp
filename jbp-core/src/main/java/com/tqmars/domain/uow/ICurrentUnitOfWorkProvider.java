package com.tqmars.domain.uow;

/**
 * Created by jjh on 17-3-22.
 * Used to get/set current IUnitOfWork
 */
public interface ICurrentUnitOfWorkProvider {
    /**
     * @return
     */
    IUnitOfWork getCurrent();

    void setCurrent(IUnitOfWork uow);
}
