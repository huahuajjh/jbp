package com.tqmars.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * Created by jjh on 17-5-4.
 */
public interface ISessionProvider {
    public SqlSession getSession();
}
