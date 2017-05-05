package com.tqmars.domain.uow;

/**
 * Created by jjh on 17-3-21.
 * Defines a unit of work.
 * This interface is internally used by jbp framework.
 * Do not directly use this interface, use IUnitOfWorkManager instead
 */
public interface IUnitOfWork extends IActiveUnitOfWork,IUnitOfWorkCompleteHandler{
    String getId();
    void setId(String id);

    IUnitOfWork getOuter();
    void setOuter(IUnitOfWork uow);

    /**
     * Begins the unit of work with given options.
     * @param options   unit of work options
     */
    void begin(UnitOfWorkOptions options);
}