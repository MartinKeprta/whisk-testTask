package com.whisk.qa.web.utility;

public enum ErrorMsg {

    NO_ERROR(""),
    FIELD_REQUIRED ("This field is required"),
    EMAIL_PHONE_INVALID("Make sure your email or phone number is right"),
    EMAIL_STRING_INVALID("This doesn't look like an name"),
    EMAIL_INVALID("This doesn't look like an email address");
    public final String text;
    ErrorMsg(String text) {
        this.text = text;
    }
}
