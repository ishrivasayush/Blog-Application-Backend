package org.narainox.blog.application.backend.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private Boolean success;

}
