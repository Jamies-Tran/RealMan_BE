package com.capstone.realmen.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capstone.realmen.controller.error.exceptions.AccountLoginException;
import com.capstone.realmen.controller.error.exceptions.JwtInvalidException;
import com.capstone.realmen.controller.error.exceptions.ResourceDuplicatedException;
import com.capstone.realmen.controller.error.exceptions.ResourceInvalidException;
import com.capstone.realmen.controller.error.exceptions.ResourceNotFoundException;
import com.capstone.realmen.controller.error.exceptions.WrongOTPException;
import com.capstone.realmen.controller.error.models.ErrorResponse;
import com.capstone.realmen.dto.error.AppError;

import jakarta.validation.ConstraintViolationException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    Map<String, String> validationNotValidException(ConstraintViolationException exc) {
        Map<String, String> errors = new HashMap<>();
        exc.getConstraintViolations().forEach(error -> {
            String fieldError = "Validation fail";
            String errorMsg = error.getMessage();
            errors.put(fieldError, errorMsg);
        });
        return errors;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException exc) {

        return ErrorResponse.builder()
                .errorCode("")
                .errorMsg(exc.getAllErrors().stream()
                        .map(ObjectError::getDefaultMessage).findAny().orElse(
                                ""))
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .issueAt(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(JwtInvalidException.class)
    public ErrorResponse jwtExceptionHandler(JwtInvalidException exc) {
        return ErrorResponse.builder()
                .errorCode(AppError.JWT_INVALID.getCode())
                .errorMsg(AppError.JWT_INVALID.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .issueAt(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse ResourceNotFoundHandler(ResourceNotFoundException exc) {
        return ErrorResponse.builder()
                .errorCode(AppError.NOT_FOUND.getCode())
                .errorMsg(AppError.NOT_FOUND.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .issueAt(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccountLoginException.class)
    public ErrorResponse AccountLoginHandler(AccountLoginException exc) {
        return ErrorResponse.builder()
                .errorCode(AppError.ACCOUNT_INVALID.getCode())
                .errorMsg(AppError.ACCOUNT_INVALID.getMessage())
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .issueAt(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(ResourceDuplicatedException.class)
    public ErrorResponse ResourceDuplicatedHandler(ResourceDuplicatedException exc) {
        return ErrorResponse.builder()
                .errorCode(AppError.ACCOUNT_DUPLICATED.getCode())
                .errorMsg(AppError.ACCOUNT_DUPLICATED.getMessage())
                .statusCode(HttpStatus.CONFLICT.value())
                .issueAt(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(WrongOTPException.class)
    public ErrorResponse WrongPaseHandler(WrongOTPException exc) {
        return ErrorResponse.builder()
                .errorCode(AppError.WRONG_OTP_CHANGE_PASS.getCode())
                .errorMsg(AppError.WRONG_OTP_CHANGE_PASS.getMessage())
                .statusCode(HttpStatus.PRECONDITION_FAILED.value())
                .issueAt(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResourceInvalidException.class)
    public ErrorResponse InvalidSortHandler(ResourceInvalidException exc) {
        return ErrorResponse.builder()
                .errorCode(AppError.INVALID_SORT.getCode())
                .errorMsg(AppError.INVALID_SORT.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .issueAt(LocalDateTime.now())
                .build();
    }
}
