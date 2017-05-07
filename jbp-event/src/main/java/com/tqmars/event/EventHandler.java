package com.tqmars.event;

/**
 * Created by jjh on 5/5/17.
 */

@FunctionalInterface
public interface EventHandler<TEventArgs> {
    public void Func(Object sender,TEventArgs e);
}
