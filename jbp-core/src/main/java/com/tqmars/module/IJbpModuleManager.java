package com.tqmars.module;

import java.util.List;

/**
 * Created by jjh on 17-3-24.
 */
public interface IJbpModuleManager {
    JbpModuleInfo getStartupModule();
    List<JbpModuleInfo> getModules();

    void initialize(Class startupModule);
    void startModules();
    void shutdownModules();
}
