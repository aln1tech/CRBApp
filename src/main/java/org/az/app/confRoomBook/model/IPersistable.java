package org.az.app.confRoomBook.model;

public interface IPersistable<ID> {
    ID getId();
    void setId(ID id);
}
