package org.az.app.confRoomBook.utils.model;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.az.app.confRoomBook.utils.enums.ApplicationStatusCode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Logeswaran Murugesan
 *
 */
@Service("errorBean")
@Scope("prototype")
public class ErrorBean {
    
    private ApplicationStatusCode code;
    private String message;
    
    @JsonIgnore
    private Object[] params;
    
    
    
    public ErrorBean() {
		super();
	}

	public ErrorBean(final ApplicationStatusCode code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    public ErrorBean(final ApplicationStatusCode code) {
        this.code = code;
    }
    
    public ErrorBean(final ApplicationStatusCode code, final Object[] params) {
        this.code = code;
        this.params = params;
    }
    
    public ApplicationStatusCode getCode() {
        return code;
    }
    
    public void setCode(ApplicationStatusCode code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Object[] getParams() {
        return params;
    }
    
    public void setParams(Object[] params) {
        this.params = params;
    }
    
    public static ErrorBean getErrorMessage(ApplicationStatusCode code, String msg) {
        return new ErrorBean(code, msg);
    }
}