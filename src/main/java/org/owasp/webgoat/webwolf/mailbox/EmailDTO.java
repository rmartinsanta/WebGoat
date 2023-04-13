package org.owasp.webgoat.webwolf.mailbox;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailDTO {
    private Long id;
    private String contents;
    private String sender;
    private String title;
    private String recipient;
    @JsonIgnore
    private LocalDateTime time = LocalDateTime.now();

    public EmailDTO(Email email){
        this.id = email.getId();
        this.contents = email.getContents();
        this.sender = email.getSender();
        this.title = email.getTitle();
        this.recipient = email.getRecipient();
    }

    public String getSummary() {
        return "-" + this.contents.substring(0, Math.min(50, contents.length()));
    }

    public LocalDateTime getTimestamp() {
        return time;
    }

    public String getTime() {
        return DateTimeFormatter.ofPattern("h:mm a").format(time);
    }

    public String getShortSender() {
        return sender.substring(0, sender.indexOf("@"));
    }
}
