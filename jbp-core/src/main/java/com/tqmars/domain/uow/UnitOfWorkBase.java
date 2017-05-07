package com.tqmars.domain.uow;

import java.util.List;

/**
 * Created by jjh on 17-3-22.
 */
public abstract class UnitOfWorkBase implements IUnitOfWork{
    private List<DataFilterConfiguration> _filters;
    private UnitOfWorkOptions _options;
    private IUnitOfWorkDefaultOptions _defaultOptions;
    protected IConnectionStringResolver _connectionStringResolver;
    protected IUnitOfWorkFilterHandler _filterHandler;


    protected UnitOfWorkBase(IConnectionStringResolver connectionStringResolver,
                             IUnitOfWorkDefaultOptions defaultOptions,
                             IUnitOfWorkFilterHandler unitOfWorkFilterHandler)
    {

        _filterHandler = unitOfWorkFilterHandler;
        _defaultOptions = defaultOptions;
        _connectionStringResolver = connectionStringResolver;

        _filters = defaultOptions.getFilters();

    }

    @Override
    public UnitOfWorkOptions getOptions() {
        return _options;
    }

}
