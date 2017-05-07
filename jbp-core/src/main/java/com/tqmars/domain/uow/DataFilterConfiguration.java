package com.tqmars.domain.uow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jjh on 17-3-22.
 */
public class DataFilterConfiguration {
    private String filterName;
    private boolean isEnabled;
    private Map<String,Object> filterParameters;

    public String getFilterName() {
        return filterName;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public Map<String, Object> getFilterParameters() {
        return filterParameters;
    }

    public DataFilterConfiguration(String filterName, boolean isEnabled) {
        this.filterName = filterName;
        this.isEnabled = isEnabled;
        this.filterParameters = new HashMap<>();
    }

    public DataFilterConfiguration(DataFilterConfiguration filter2Clone,boolean isEnabled){
        this(filter2Clone.filterName,isEnabled);

        filter2Clone.filterParameters.entrySet().forEach(
                entry -> this.filterParameters.put(entry.getKey(),entry.getValue())
            );
    }
}
