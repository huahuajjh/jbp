package com.tqmars.domain.uow;

import com.tqmars.domain.uow.consts.IsolationLevel;
import com.tqmars.domain.uow.consts.TransactionScopeOption;

/**
 * Created by jjh on 17-3-21.
 */
public class UnitOfWorkOptions {
    public boolean isTransactional;
    public IsolationLevel isolationLevel;
    public TransactionScopeOption scope;
}
