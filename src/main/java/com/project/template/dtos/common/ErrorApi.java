package com.project.template.dtos.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorApi {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
}
