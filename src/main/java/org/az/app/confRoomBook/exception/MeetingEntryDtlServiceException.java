package org.az.app.confRoomBook.exception;

public class MeetingEntryDtlServiceException extends RuntimeException {
	  private static final long serialVersionUID = 1L;

	  /**
	   * Exception
	   */
	  public MeetingEntryDtlServiceException() {

	  }

	  /**
	   * @param message
	   * @param cause
	   * @param enableSuppression
	   * @param writableStackTrace
	   */
	  public MeetingEntryDtlServiceException(String message, Throwable cause, boolean enableSuppression,
	      boolean writableStackTrace) {
	    super(message, cause, enableSuppression, writableStackTrace);
	  }

	  /**
	   * @param message
	   * @param cause
	   */
	  public MeetingEntryDtlServiceException(String message, Throwable cause) {
	    super(message, cause);
	  }

	  /**
	   * @param message
	   */
	  public MeetingEntryDtlServiceException(String message) {
	    super(message);
	  }

	  /**
	   * @param cause
	   */
	  public MeetingEntryDtlServiceException(Throwable cause) {
	    super(cause);
	  }
}
