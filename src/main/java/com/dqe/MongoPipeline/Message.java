package com.dqe.MongoPipeline;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private String text;

    public Message() {}

    public Message(String text) {
        this.text = text;
    }

    public String getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public void setId(String id){
        this.id=id;
    }
}
