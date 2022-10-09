package com.backapiboats.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")

public class MessageModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messagetext;

    public MessageModel() {
    }

    public MessageModel(String messagetext) {
        this.messagetext = messagetext;
    }

    public MessageModel(Integer id, String messagetext) {
        this.id = id;
        this.messagetext = messagetext;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "id=" + id +
                ", messagetext='" + messagetext + '\'' +
                '}';
    }
}
