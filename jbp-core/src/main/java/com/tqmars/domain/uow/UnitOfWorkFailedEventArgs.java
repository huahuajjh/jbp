package com.tqmars.domain.uow;

import com.tqmars.events.EventArgs;

/**
 * Created by jjh on 17-3-23.
 */
public class UnitOfWorkFailedEventArgs extends EventArgs{
    private Exception _exception;

    public Exception getException() {
        return _exception;
    }

    private void setException(Exception _exception) {
        this._exception = _exception;
    }

    public UnitOfWorkFailedEventArgs(Exception _exception) {
        this._exception = _exception;
    }
}
