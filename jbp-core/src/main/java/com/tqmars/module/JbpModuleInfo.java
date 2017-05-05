package com.tqmars.module;

import java.util.List;
import java.util.Objects;

/**
 * Created by jjh on 17-3-24.
 * Used to store all needed information for a module
 */
public class JbpModuleInfo {
    private Class type;

    private JbpModule instance;

    private boolean isLoadedAsPlugin;

    private List<JbpModuleInfo> dependencies;

    public JbpModuleInfo(Class type, JbpModule instance, boolean isLoadedAsPlugin) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(instance);

        this.type = type;
        this.instance = instance;
        this.isLoadedAsPlugin = isLoadedAsPlugin;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public JbpModule getInstance() {
        return instance;
    }

    public void setInstance(JbpModule instance) {
        this.instance = instance;
    }

    public boolean isLoadedAsPlugin() {
        return isLoadedAsPlugin;
    }

    public void setLoadedAsPlugin(boolean loadedAsPlugin) {
        isLoadedAsPlugin = loadedAsPlugin;
    }

    public List<JbpModuleInfo> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<JbpModuleInfo> dependencies) {
        this.dependencies = dependencies;
    }
}
