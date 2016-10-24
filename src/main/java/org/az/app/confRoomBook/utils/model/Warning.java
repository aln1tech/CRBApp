package org.az.app.confRoomBook.utils.model;

import org.az.app.confRoomBook.utils.enums.ApplicationStatusCode;

/**
 * @author Logeswaran Murugesan
 *
 */
public class Warning {
    
    private ApplicationStatusCode code;
    private String message;
    
    public Warning() {
        
    }
    
    /**
     * @param code
     * @param message
     */
    public Warning(ApplicationStatusCode code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    
    public void setCode(ApplicationStatusCode code) {
        this.code = code;
    }
    
    /**
     * 
     * @return
     */
    public ApplicationStatusCode getCode() {
        return code;
    }
    
    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * 
     * @param code
     * @param msg
     * @return Warning
     */
    public static Warning getWarningMessage(ApplicationStatusCode code, String msg) {
        return new Warning(code, msg);
    }
    
}
