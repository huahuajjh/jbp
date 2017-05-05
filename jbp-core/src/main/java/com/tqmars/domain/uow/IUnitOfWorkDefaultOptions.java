package com.tqmars.domain.uow;

import com.tqmars.domain.uow.consts.IsolationLevel;
import com.tqmars.domain.uow.consts.TransactionScopeOption;

import java.util.List;

/**
 * Created by jjh on 17-3-22.
 * Used to get/set default options for a unit of work
 */
public interface IUnitOfWorkDefaultOptions {
    void setScope(TransactionScopeOption scopeOption);
    TransactionScopeOption getScope();

    boolean getIsTransactional();
    boolean setIsTransactional(boolean transactional);

    IsolationLevel getIsolationLevel();
    void setIsolationLevel(IsolationLevel isolationLevel);

    List<DataFilterConfiguration> getFilters();

    /**
     * Register a data filter to unit of work system.
     * @param filterName    Name of filter
     * @param isEnabledByDefault    Is filter enabled by default.
     */
    void registerFilter(String filterName,boolean isEnabledByDefault);

    /**
     * Override a data filter definition.
     * @param filterName    Name of the filter.
     * @param isEnabledByDefault    Is filter enabled by default.
     */
    void overrideFilter(String filterName,boolean isEnabledByDefault);
}
