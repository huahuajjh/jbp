package com.tqmars.domain.uow.consts;

/**
 * Created by jjh on 17-3-21.
 */
public enum IsolationLevel {
    Chaos,
    ReadCommitted,
    ReadUncommitted,
    RepeatableRead,
    Serializable,
    Snapshot,
    Unspecified
}