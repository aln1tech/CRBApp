package org.az.app.confRoomBook.utils.enums;

/**
 * @author Logeswaran Murugesan
 *
 */
public enum ResponseStatus {
    
    SUCCESS(1, "SUCCESS"), FAILURE(0, "FAILURE"), WARNING(2, "WARNING");
    
    private int id;
    private String name;
    
    private ResponseStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}