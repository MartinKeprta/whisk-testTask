package com.whisk.qa.rest.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorMessage {
    @JsonProperty("code")
    private String code;
    @JsonProperty("error_code")
    private String error_code;
    @JsonProperty("message")
    private String message;
}