package org.owasp.webgoat.webwolf.mailbox;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
    private String recipient;
    private String subject;
    private String message;
}