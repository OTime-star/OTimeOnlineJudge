package com.otime.excepiton;

public class DaoException extends RuntimeException{
	private static final long serialVersionUID = -5726488636236115222L;

	public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DaoException(Throwable cause) {
        super(cause);
    }
}
