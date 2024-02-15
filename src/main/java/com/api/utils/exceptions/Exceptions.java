package com.api.utils.exceptions;

import com.api.utils.responseBody.ResponseBody;
import org.springframework.http.ResponseEntity;

public class Exceptions {

    public ResponseEntity<?> sendResponse(String message) {
        return ResponseEntity.status(200).body(new ResponseBody(message));
    }

    public ResponseEntity<?> sendResponse(String message, int status) {
        return ResponseEntity.status(status).body(new ResponseBody(message));
    }

}
