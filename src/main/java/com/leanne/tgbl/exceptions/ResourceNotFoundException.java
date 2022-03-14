package com.leanne.tgbl.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String name, long id) {
        super(String.format("%s with id '%s' not found", name, id));
    }
}
