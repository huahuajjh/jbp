package com.tqmars.module;

import com.tqmars.exception.JbpInitializationException;
import com.tqmars.module.annotation.DependsOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jjh on 17-3-24.
 * This class must be implemented by all module definition classed.
 * A module definition class is generally located in it's package
 * and implements some action in module events on application startup and shutdown.
 * It also defines depended modules.
 */
public abstract class JbpModule {
    /**
     * This is the first event called on application startup.
     * Codes can be placed here to run before dependency injection registrations.
     */
    protected void preInitialize(){ }

    /**
     * This method is used to register dependencies for this module.
     */
    protected void Initialize(){}

    /**
     * This method is called lastly on application startup.
     */
    protected void postInitialize(){}

    /**
     * This method is called when the application is being shutdown.
     */
    protected void shutdown(){}

    /**
     * Check if given type is a jbp module class.
     * @param type
     * @return
     */
    public static boolean isJbpModule(Class type){
        return JbpModule.class.isAssignableFrom(type);
    }

    /**
     * Find direct depended modules of a module(excluding given module).
     * @param type    Find dependency type from this given type
     * @return
     */
    public static List<Class> findDependedModuleTypes(Class type){
        if(!isJbpModule(type)){
            throw new JbpInitializationException("This type is not a jbp module: "+type.getName());
        }

        List<Class> clsList = new ArrayList<>();

        if(type.isAnnotationPresent(DependsOn.class)){
            DependsOn dps = (DependsOn) type.getAnnotation(DependsOn.class);
            return Arrays.asList(dps.value());
        }
        return clsList;
    }

    public static List<Class> findDependedModuleTypesRecursively(Class type){
        List<Class> list = new ArrayList<>();
        addModuleAndDependenciesRecursively(list, type);
        return list;
    }

    private static void addModuleAndDependenciesRecursively(List<Class> modules,Class module){
        if(!isJbpModule(module)){
            throw new JbpInitializationException("This type is not a jbp module: "+module.getName());
        }

        if(modules.contains(module)){
            return;
        }

        modules.add(module);

        List<Class> depsModules = findDependedModuleTypes(module);
        depsModules.forEach(m -> {
            addModuleAndDependenciesRecursively(modules,m);
            }
        );
    }

}
