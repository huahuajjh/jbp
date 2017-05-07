package com.tqmars.domain.uow;

import com.tqmars.domain.uow.consts.TransactionScopeOption;

/**
 * Created by jjh on 17-3-23.
 * Unit of work manager.
 * Used to begin and control a unit of work.
 * Facade pattern.
 */
public interface IUnitOfWorkManager {
    /**
     * Get currently active unit of work(or null if not exists).
     * @return IActiveUnitOfWork    A active unit of work.
     */
    IActiveUnitOfWork getCurrent();

    /**
     * Begins a new unit of work.
     * @return IUnitOfWorkCompleteHandler    A handler to be able to complete the unit of work.
     */
    IUnitOfWorkCompleteHandler begin();

    /**
     * Begins a new unit of work.
     * @param scopeOption    A transaction scope.
     * @return IUnitOfWorkCompleteHandler    A handler to be able to complete the unit of work.
     */
    IUnitOfWorkCompleteHandler begin(TransactionScopeOption scopeOption);

    /**
     * Begins a new unit of work.
     * @param options UnitOfWorkOptions    A unit of work options about transaction isolation,transaction scope,disabled transaction option etc.
     * @return IUnitOfWorkCompleteHandler    A handler to be able to complete the unit of work.
     */
    IUnitOfWorkCompleteHandler begin(UnitOfWorkOptions options);

}
