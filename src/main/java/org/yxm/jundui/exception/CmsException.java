package org.yxm.jundui.exception;

/**
 * Created by yxm on 2016.11.20.
 */
public class CmsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CmsException() {
        super();
    }

    public CmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CmsException(String message) {
        super(message);
    }

    public CmsException(Throwable cause) {
        super(cause);
    }
}
