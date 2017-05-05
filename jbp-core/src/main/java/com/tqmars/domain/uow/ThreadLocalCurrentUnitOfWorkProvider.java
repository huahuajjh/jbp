package com.tqmars.domain.uow;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jjh on 17-3-23.
 */
public class ThreadLocalCurrentUnitOfWorkProvider implements ICurrentUnitOfWorkProvider{
    private final String KEY = "Jbp.uow.current";
    private static ConcurrentHashMap<String,IUnitOfWork> uowMap = new ConcurrentHashMap<>();


    @Override
    public IUnitOfWork getCurrent() {
        return null;
    }

    @Override
    public void setCurrent(IUnitOfWork uow) {
    }


}
