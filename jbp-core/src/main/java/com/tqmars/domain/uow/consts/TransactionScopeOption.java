package com.tqmars.domain.uow.consts;

/**
 * Created by jjh on 17-3-22.
 * Provides additional options for creating a transaction scope.
 */
public enum TransactionScopeOption {
    /**
     * A transaction is required by the scope. It uses an ambient transaction if one already exists.
     * Otherwise, it creates a new transaction before entering the scope.
     * This is the default value.
     */
    Required,

    /**
     * A new transaction is always created for the scope.
     */
    RequiresNew,

    /**
     * The ambient transaction context is suppressd when creating the scope.
     * All operations within the scope are done without an ambient transaction context.
     */
    Suppress
}
