package org.rooster.server.exception;

import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
// adds @ResponseBody so returns json instead of html
public class RestExceptionHandler {

    // if declared in a @Controller it is scoped only to the controller
    // as it is declared in @ControllerAdvice it is a global handler for all @Controller 's,
    // however it doesn't work in filters as they are invoked before the servlet
    // a workaround is mentioned here https://stackoverflow.com/questions/34595605/how-to-manage-exceptions-thrown-in-filters-in-spring
    // to have the first filter to be able to catch any exception thrown in subsequent filters

    // its debatable if i should use the above method to catch jwt filter errors like unsignedex and jwtexpiredex
    // as there may be a best practice way im unable to find
    // another option is to send back the response immediately in the filter instead of the whole exception throwing route
    @ExceptionHandler(value = {UnauthenticatedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponseBody handleUnauthorizedUser(Exception ex) {
        log.error(ex.getCause().getMessage());
        log.info("hehe");

        return new ErrorResponseBody(ex.getMessage());
    }

    @ExceptionHandler(value = {UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponseBody handleUnauthenticatedUser(Exception ex) {
        log.error(ex.getCause().getMessage());
        log.info("hehe");
        return new ErrorResponseBody(ex.getMessage());
    }
}
