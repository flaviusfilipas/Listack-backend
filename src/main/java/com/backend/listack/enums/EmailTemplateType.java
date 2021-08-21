package com.backend.listack.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EmailTemplateType {
    CONFIRMATION_EMAIL_WITH_ACCOUNT("contributor-confirmation-email"),
    CONFIRMATION_EMAIL_WITHOUT_ACCOUNT("no-account-contributor-email");

    @Getter
    private String value;


}
