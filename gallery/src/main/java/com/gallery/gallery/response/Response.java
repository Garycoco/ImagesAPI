package com.gallery.gallery.response;

import org.springframework.context.annotation.Bean;

public class Response {
    public String message;
    public Response(String message) {
        this.message = message;
    }
}
