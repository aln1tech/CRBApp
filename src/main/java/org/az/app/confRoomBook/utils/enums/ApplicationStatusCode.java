package org.az.app.confRoomBook.utils.enums;

/**
 * @author Logeswaran Murugesan
 *
 */
public enum ApplicationStatusCode {
    
    NOT_ACCEPTABLE(5010, "Not Acceptable"),

    NO_RECORDS(5020, "No Records Found"),

    INSERT_FAILED(5023, "Creation failed"),
    
    NOTSUPPORTED(5024,"VALUE NOT ELIGBLE"),
   
    NO_JSON_INPUT(5027, "No JSON Input"),
	
    
    
	APPLICATIONERROR(5028,"CONTACT ADMIN TEAM");

    
    private final int value;
    private final String reasonString;
    
    private ApplicationStatusCode(int value, String reasonString) {
        this.value = value;
        this.reasonString = reasonString;
    }
    
    public int value() {
        return this.value;
    }
    
    public String getReasonString() {
        return reasonString;
    }
    
    public static ApplicationStatusCode valueOf(int statusCode) {
        for (ApplicationStatusCode status : values()) {
            if(status.value == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
    }
    
}
