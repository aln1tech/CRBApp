package org.az.app.confRoomBook.utils.model;

import java.io.Serializable;

import org.az.app.confRoomBook.utils.enums.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Logeswaran Murugesan
 *
 */
@JsonInclude(value = Include.NON_EMPTY)
public class Response<T> {
    
    ResponseStatus status;
    T data;
    Pagination pageDetails;
    String message;
    ErrorBean error;
    Warning warning;
    
    
    
    public Response() {
		super();
	}

	/**
     * 
     * @return ResponseStatus
     */
    public ResponseStatus getStatus() {
        return status;
    }
    
    /**
     * 
     * @param status
     *            void
     */
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    
    /**
     * 
     * @return T
     */
    public T getData() {
        return data;
    }
    
    /**
     * 
     * @param data
     *            void
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * 
     * @return Pagination
     */
    public Pagination getPageDetails() {
        return pageDetails;
    }
    
    /**
     * 
     * @param pageDetails
     *            void
     */
    public void setPageDetails(Pagination pageDetails) {
        this.pageDetails = pageDetails;
    }
    
    /**
     * 
     * @return ErrorBean
     */
    public ErrorBean getError() {
        return error;
    }
    
    /**
     * 
     * @param error
     *            void
     */
    public void setError(ErrorBean error) {
        this.error = error;
    }
    
    /**
     * 
     * @return Warning
     */
    public Warning getWarning() {
        return warning;
    }
    
    /**
     * 
     * @param data
     *            void
     */
    public void setSuccess(T data) {
        status = ResponseStatus.SUCCESS;
        this.data = data;
    }
    
    /**
     * 
     * @param error
     *            void
     */
    public void setFailure(ErrorBean error) {
        status = ResponseStatus.FAILURE;
        this.error = error;
    }
    
    /**
     * 
     * @param warning
     *            void
     */
    public void setWarning(Warning warning) {
        status = ResponseStatus.WARNING;
        this.warning = warning;
    }

	@Override
	public String toString() {
		return "Response [status=" + status + ", data=" + data
				+ ", pageDetails=" + pageDetails + ", message=" + message
				+ ", error=" + error + ", warning=" + warning + "]";
	}
    
    
    
    
}
