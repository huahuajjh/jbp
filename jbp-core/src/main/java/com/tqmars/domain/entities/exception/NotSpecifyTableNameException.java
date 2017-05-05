package com.tqmars.domain.entities.exception;

import com.tqmars.exception.JbpException;

/**
 * Created by jjh on 17-3-19.
 */
public class NotSpecifyTableNameException extends JbpException {
    public NotSpecifyTableNameException() {
        super();
    }

    public NotSpecifyTableNameException(String message) {
        super(message);
    }
}
