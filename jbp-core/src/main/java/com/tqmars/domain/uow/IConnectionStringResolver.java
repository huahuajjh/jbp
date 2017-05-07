package com.tqmars.domain.uow;

/**
 * Created by jjh on 17-5-4.
 * Used to get connection string name when a database connection is needed.
 */
public interface IConnectionStringResolver {
    /**
     * Gets a connection string name from in config file or a valid connection string.
     * @param args Arguments that can be used while resolving connection string.
     * @return
     */
    public String getNameOrConnectionString(ConnectionStringResolveArgs args);
}
