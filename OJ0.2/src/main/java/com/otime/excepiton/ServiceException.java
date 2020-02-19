package com.otime.excepiton;

public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 9098821545661556683L;

	public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
