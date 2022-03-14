package com.hashtag.system.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author sinclairjaza
 * @Date 3/14/22 - 10:05 AM
 * @Project hashtag_system
 */
public class ApiResponse {

    private Boolean success;
    private Date timestamp;
    private String message;
    private String details;
    private Integer length;
    private Object data;
    private HttpStatus httpStatus;

    public ApiResponse(Boolean success, Date timestamp, String message, String details, Integer length, Object data, HttpStatus httpStatus) {
        this.success = success;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.length = length;
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public ApiResponse(Boolean success, Date timestamp, Object data, String message, Integer length, HttpStatus httpStatus) {
        this.success = success;
        this.timestamp = timestamp;
        this.message = message;
        this.length = length;
        this.data = data;
        this.httpStatus = httpStatus;
    }

    public ApiResponse(Boolean success, Date timestamp, String message, HttpStatus httpStatus) {
        this.success = success;
        this.timestamp = timestamp;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ApiResponse(Boolean success , Date timestamp, String message, String details, HttpStatus httpStatus) {
        super();
        this.success = success;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.httpStatus = httpStatus;
    }

    public ApiResponse(Boolean success , Date timestamp, String message, String details) {
        super();
        this.success = success;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ApiResponse(Boolean success, Date timestamp, Object data, String message) {
        super();
        this.success = success;
        this.timestamp = timestamp;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(Boolean success, Date timestamp, Object data, String message, HttpStatus httpStatus) {
        super();
        this.success = success;
        this.timestamp = timestamp;
        this.data = data;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ApiResponse(Boolean success, Date timestamp, Object data, String message, Integer length) {
        super();
        this.success = success;
        this.timestamp = timestamp;
        this.message = message;
        this.length = length;
        this.data = data;
    }

    public ApiResponse(Boolean success, Date timestamp, String message) {
        super();
        this.success = success;
        this.timestamp = timestamp;
        this.message = message;
    }

    public ApiResponse(String message) {
        this.success =  true;
        this.message = message;
        this.timestamp = new Date();
        this.httpStatus = HttpStatus.OK;
    }

    public ApiResponse(String message , HttpStatus status) {
        this.success =  status == HttpStatus.OK;
        this.message = message;
        this.timestamp = new Date();
        this.httpStatus = status;
    }

    public ApiResponse(Object data) {
        this.data = data;
    }

    public ApiResponse(Object data, Boolean success) {
        this.success = success;
        this.data = data;
    }

    public ApiResponse(boolean success, String message) {
        super();
        this.success = success;
        this.timestamp = new Date();
        this.message = message;
    }
}
