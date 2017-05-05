package com.tqmars.domain.entities;

/**
 * @author jjh
 * Created by jjh on 17-3-19.
 */
public interface ISoftDelete {
    /**
     * mark an Entity as 'Deleted'
     * @param del
     */
    void isDeleted(boolean del);
}
