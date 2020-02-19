package com.otime.excepiton;

public class JudgeException extends RuntimeException{
	private static final long serialVersionUID = 9098821545661556683L;

	public JudgeException() {
        super();
    }

    public JudgeException(String message) {
        super(message);
    }

    public JudgeException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public JudgeException(Throwable cause) {
        super(cause);
    }
}
