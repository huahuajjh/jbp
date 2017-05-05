package com.tqmars.module;

import java.util.List;

/**
 * Created by jjh on 17-3-24.
 */
public class JbpModuleManager implements IJbpModuleManager {
    private JbpModuleInfo startupModule;
    private List<JbpModuleInfo> modules;

    @Override
    public JbpModuleInfo getStartupModule() {
        return startupModule;
    }

    @Override
    public List<JbpModuleInfo> getModules() {
        return modules;
    }

    @Override
    public void initialize(Class startupModule) {

    }

    @Override
    public void startModules() {

    }

    @Override
    public void shutdownModules() {

    }
}
