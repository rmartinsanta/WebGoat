package org.owasp.webgoat.webwolf.mailbox;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record EmailDTO(
    @NotBlank @Size(max = 1024) String contents,
    @NotBlank String title,
    @NotBlank String recipient
) {}
