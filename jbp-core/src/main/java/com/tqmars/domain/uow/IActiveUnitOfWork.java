package com.tqmars.domain.uow;

import com.tqmars.events.EventArgs;
import com.tqmars.events.EventHandler;

import java.util.List;

/**
 * Created by jjh on 17-3-21.
 * This interface is used to work with active unit of work.
 */
public interface IActiveUnitOfWork {
    /**
     * Save all changes in this unit of work.
     * This method may be called to apply changes whenever nedded.
     * Note that if this unit of work is transactional, save changes are also rolled back if transaction is rolled back.
     * No need to explicitly call to saveChanges generally.
     * Since all changes saved at end of a unit of work automatically
     */
    void saveChanges();

    /**
     * Get if this unit of work is transactional.
     * @return
     */
    UnitOfWorkOptions getOptions();

    /**
     * Gets data filter configurations for unit of work.
     * @return List<DataFilterConfiguration>    List of data filters
     */
    List<DataFilterConfiguration> getFilters();

    /**
     * Get a event handler when this UOW is successfully completed.
     * @return
     */
    EventHandler<EventArgs> getCompleted();

    /**
     * Set a event handler for this UOW.
     * @param handler
     */
    void setCompleted(EventHandler<EventArgs> handler);

    EventHandler<UnitOfWorkFailedEventArgs> getFailed();
    void getFailed(EventHandler<UnitOfWorkFailedEventArgs> handler);

    /**
     * Disable one or more data filters.
     * Do nothing for a filter if it's already disabled.
     * @param filterNames
     */
    void disableFilter(String[] filterNames);

    /**
     * Enable one or more data filters.
     * Do thing for a filter if it's already enabled.
     * @param filterNames
     */
    void enableFilter(String[] filterNames);

    /**
     * Check if a filter is enabled or not.
     * @param filterName    Filter name
     * @return
     */
    boolean isFilterEnabled(String filterName);

    /**
     * Set (override) value of a filter parameter.
     * @param filterName    Name of the filter.
     * @param paratemerName    Parameter's name.
     * @param value    Value of the parameter to be set
     */
    void setFilterParameter(String filterName,String paratemerName,Object value);


    /**
     * Set/Change Tenant's Id for this UOW.
     * @param tenantId    The tenant is.
     */
    void setTenantId(int tenantId);

    /**
     * Get Tenant Id for this UOW.
     * @return
     */
    int getTenantId();

}
