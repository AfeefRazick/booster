package org.rooster.server.exception;

import lombok.Data;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;

@Data
public class ErrorResponseBody {
    private String message;

    public ErrorResponseBody(String message) {
        this.message = message;
    }
}
