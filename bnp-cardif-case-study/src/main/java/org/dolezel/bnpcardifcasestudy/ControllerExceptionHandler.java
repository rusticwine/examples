package org.dolezel.bnpcardifcasestudy;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler
    public ProblemDetail handleConstraintViolationException(ConstraintViolationException ex) {
        return handleFailedValidation(ex);
    }


    @ExceptionHandler
    public ProblemDetail handleConstraintViolationException(MethodArgumentNotValidException ex) {
        return handleFailedValidation(ex);
    }


    @ExceptionHandler
    public ProblemDetail handleConstraintViolationException(PersistentResourceNotFoundException ex) {
        var pd = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
        pd.setDetail(ex.getMessage());
        pd.setTitle("Resource does not exist");
        return pd;
    }


    //Common code for more exceptions being thrown by constraint validation
    private ProblemDetail handleFailedValidation(Exception ex) {
        var pd = ProblemDetail.forStatus(HttpStatusCode.valueOf(406));
        pd.setDetail(ex.getMessage());
        pd.setTitle("Constraint validation");
        return pd;
    }
}
