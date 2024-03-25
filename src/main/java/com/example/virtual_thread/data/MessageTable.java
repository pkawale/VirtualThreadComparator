package com.example.virtual_thread.data;

import jakarta.persistence.*;

@Entity
@Table(name="messageTable")
public class MessageTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    public MessageTable() {}

    public MessageTable(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
