package com.tqmars.mybatis.uow;

import com.tqmars.mybatis.ISessionProvider;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by jjh on 17-5-4.
 */
public class UnitOfWorkSessionProvider implements ISessionProvider
{

    @Override
    public SqlSession getSession() {
        return null;
    }
}
