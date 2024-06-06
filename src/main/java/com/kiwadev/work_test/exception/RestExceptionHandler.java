package com.kiwadev.work_test.exception;

import com.kiwadev.work_test.utils.ResponseHandler;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String ERROR = "error: ";
    public static final String REQUEST = "request: ";

    @ExceptionHandler({ GeneralException.class })
    public ResponseEntity<Object> handleGeneral(final RuntimeException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + extractUrlFromRequest(request));

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, extractUrlFromRequest(request));
    }

    @ExceptionHandler({ AuthException.class })
    public ResponseEntity<Object> handleAuth(final RuntimeException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + request.getContextPath());

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.FORBIDDEN, extractUrlFromRequest(request));
    }
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + request.getContextPath());

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, extractUrlFromRequest(request));
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + request.getContextPath());

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.NOT_FOUND, extractUrlFromRequest(request));
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<Object> handleSqlException(final SQLException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + request.getContextPath());

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST,extractUrlFromRequest(request) );
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(final ConstraintViolationException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + request.getContextPath());

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, extractUrlFromRequest(request));
    }
    @ExceptionHandler({ DataAccessException.class })
    public ResponseEntity<Object> handleDataAccessException(final DataAccessException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + request.getContextPath());

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, extractUrlFromRequest(request));
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Object> handleAll(final RuntimeException ex, final WebRequest request) {
        logger.info(ex.getClass().getName());
        logger.error(ERROR, ex);
        logger.info(REQUEST + request.getContextPath());

        return ResponseHandler.generateExceptionResponse(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR, extractUrlFromRequest(request));
    }

    private String extractUrlFromRequest(WebRequest request) {
        if (request instanceof ServletWebRequest servletWebRequest) {
            HttpServletRequest servletRequest = servletWebRequest.getRequest();
            return servletRequest.getRequestURI();
        }
        return "";
    }
}

