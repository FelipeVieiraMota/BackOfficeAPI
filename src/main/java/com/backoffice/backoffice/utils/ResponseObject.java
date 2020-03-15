package com.backoffice.backoffice.utils;

import com.backoffice.backoffice.VO.ResponseStatus;
import org.springframework.http.HttpStatus;

public class ResponseObject {
    public ResponseObject() {
    }

    public static ResponseStatus getResponseObject(Object obj, Boolean success, HttpStatus status){
        ResponseStatus response = new ResponseStatus();
        response.setSuccess(success);
        response.setStatus(status);
        response.setResponse(obj);
        return response;
    }
}
