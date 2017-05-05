package com.tqmars.domain.uow;

/**
 * Created by jjh on 17-3-21.
 * This handler is used for inner unit of work scopes.
 * A inner unit of work scope actually uses outer unit of work and has no effect on IUnitOfWorkCompleteHandler.complete call.
 * But if it is not called, an exception is thrown at end of the UOW to rollback the UOW.
 */
public class InnerUnitOfWorkCompleteHandler implements IUnitOfWorkCompleteHandler {
    private volatile boolean _isCompleteCalled;

    @Override
    public void complete() {
        _isCompleteCalled = true;
    }
}
