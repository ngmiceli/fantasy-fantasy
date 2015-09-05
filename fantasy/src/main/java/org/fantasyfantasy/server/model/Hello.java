package org.fantasyfantasy.server.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Hello {
    @Id Long id;
    String message;

    public Hello(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    private Hello() {}
}
