package com.tqmars.domain.uow;

import com.tqmars.domain.uow.consts.IsolationLevel;
import com.tqmars.domain.uow.consts.TransactionScopeOption;
import com.tqmars.exception.JbpException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjh on 17-3-22.
 */
public class UnitOfWorkDefaultOptions implements IUnitOfWorkDefaultOptions{
    private TransactionScopeOption _scopeOption;
    private IsolationLevel _isolationLevel;
    private boolean _isTransactional;
    private List<DataFilterConfiguration> _filters;

    public UnitOfWorkDefaultOptions(){
        /* set default values */
        _scopeOption = TransactionScopeOption.Required;
        _isTransactional = true;
        _filters = new ArrayList<>();
    }

    @Override
    public void setScope(TransactionScopeOption scopeOption) {
        this._scopeOption = scopeOption;
    }

    @Override
    public TransactionScopeOption getScope() {
        return _scopeOption;
    }

    @Override
    public boolean getIsTransactional() {
        return _isTransactional;
    }

    @Override
    public boolean setIsTransactional(boolean transactional) {
        return _isTransactional;
    }

    @Override
    public IsolationLevel getIsolationLevel() {
        return _isolationLevel;
    }

    @Override
    public void setIsolationLevel(IsolationLevel isolationLevel) {
        this._isolationLevel = isolationLevel;
    }

    @Override
    public List<DataFilterConfiguration> getFilters() {
        return _filters;
    }

    @Override
    public void registerFilter(String filterName, boolean isEnabledByDefault) {
        if(_filters.stream().anyMatch(d -> d.getFilterName().equals(filterName))){
            throw new JbpException("There is already a filter with name: "+filterName);
        }

        _filters.add(new DataFilterConfiguration(filterName,isEnabledByDefault));
    }

    @Override
    public void overrideFilter(String filterName, boolean isEnabledByDefault) {
        _filters.removeIf(d -> d.getFilterName().equals(filterName));
        _filters.add(new DataFilterConfiguration(filterName,isEnabledByDefault));
    }
}
