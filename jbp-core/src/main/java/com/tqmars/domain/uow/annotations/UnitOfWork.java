package com.tqmars.domain.uow.annotations;

import com.tqmars.domain.uow.consts.IsolationLevel;
import com.tqmars.domain.uow.consts.TransactionScopeOption;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jjh on 17-3-21.
 * This annotation is used to indicate that declaring method is atomic and should be considered as a unit of work.
 * A method that has this annotation is intercepted, a database connection is opened and a transaction is started before call the method.
 * At the end of method call, transaction is committed and all changes applied to the database if there is no exception, otherwise it is rolled back.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitOfWork {
    /**
     * Indicate a method is transactional, generally a UOW is transactional, but if do not need to use transaction,
     * should set this property as false.
     * @return boolean    return true if it is transactional, otherwise false, default is true
     */
    boolean isTransactional() default true;

    /**
     * If uow is transactional, this option indicated the isolation level of the transaction.
     * Uses default value if not supplied
     * @return IsolationLevel    default value is ReadCommitted
     */
    IsolationLevel isolationLevel() default IsolationLevel.ReadCommitted;

    /**
     * Used to prevent starting a unit of work for the method.
     * If there is already a started unit of work, this property is ignored.
     * Default: false
     * @return boolean    return false
     */
    boolean isDisabled() default false;

    /**
     * Scope option
     * @return
     */
    TransactionScopeOption scope();

}
