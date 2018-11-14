package com.example.tacir.mail.model;

public class Mail {
    private String name;
    private String subject;
    private String message;
    private boolean fromMe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Mail(String name, String subject, String message, boolean fromMe) {
        this.name = name;
        this.subject = subject;
        this.message = message;
        this.fromMe = fromMe;
    }

    public boolean fromMe() {
        return fromMe;
    }

    public void setFromMe(boolean fromMe) {
        this.fromMe = fromMe;
    }
}
