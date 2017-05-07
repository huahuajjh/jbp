package com.tqmars.domain.uow;

import com.tqmars.event.EventArgs;
import com.tqmars.exception.JbpException;

/**
 * Created by jjh on 17-3-23.
 */
public class UnitOfWorkFailedEventArgs extends EventArgs{
    private JbpException _exception;

    public JbpException getException() {
        return _exception;
    }

    private void setException(JbpException _exception) {
        this._exception = _exception;
    }

    public UnitOfWorkFailedEventArgs(JbpException _exception) {
        this._exception = _exception;
    }
}
