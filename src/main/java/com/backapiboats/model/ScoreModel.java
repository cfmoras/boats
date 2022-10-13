package com.backapiboats.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class ScoreModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messageText;
    private Integer starts;

    public ScoreModel() {
    }

    public ScoreModel(String messageText, Integer starts) {
        this.messageText = messageText;
        this.starts = starts;
    }

    public ScoreModel(Integer id, String messageText, Integer starts) {
        this.id = id;
        this.messageText = messageText;
        this.starts = starts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    @Override
    public String toString() {
        return "ScoreModel{" +
                "id=" + id +
                ", messageText='" + messageText + '\'' +
                ", starts=" + starts +
                '}';
    }
}
