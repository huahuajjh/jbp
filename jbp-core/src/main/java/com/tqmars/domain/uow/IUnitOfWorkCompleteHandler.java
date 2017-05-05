package com.tqmars.domain.uow;

/**
 * Created by jjh on 17-3-21.
 * Used to complete a unit of work.
 * Do not directly use this interface, use IUnitOfWorkManager instead
 */
public interface IUnitOfWorkCompleteHandler {
    /**
     * Completes this unit of work.
     * It save al changes and commit transaction if exists.
     */
    void complete();

}
