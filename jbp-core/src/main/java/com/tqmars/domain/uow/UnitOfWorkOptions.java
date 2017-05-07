package com.tqmars.domain.uow;

import com.tqmars.domain.uow.consts.IsolationLevel;
import com.tqmars.domain.uow.consts.TransactionScopeOption;

/**
 * Created by jjh on 17-3-21.
 */
public class UnitOfWorkOptions {
    private boolean isTransactional;
    private IsolationLevel isolationLevel;
    private TransactionScopeOption scope;

    public boolean isTransactional() {
        return isTransactional;
    }

    public void setTransactional(boolean transactional) {
        isTransactional = transactional;
    }

    public IsolationLevel getIsolationLevel() {
        return isolationLevel;
    }

    public void setIsolationLevel(IsolationLevel isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

    public TransactionScopeOption getScope() {
        return scope;
    }

    public void setScope(TransactionScopeOption scope) {
        this.scope = scope;
    }
}
