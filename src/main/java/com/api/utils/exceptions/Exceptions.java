package com.api.utils.exceptions;

import com.api.utils.responseBody.DeactivatedUserResponseBody;
import com.api.utils.responseBody.ResponseBody;
import org.springframework.http.ResponseEntity;

public class Exceptions {

    public ResponseEntity<?> sendResponse(String message) {
        return ResponseEntity.status(200).body(new ResponseBody(message));
    }

    public ResponseEntity<?> sendResponse(String message, int status) {
        return ResponseEntity.status(status).body(new ResponseBody(message));
    }

    public ResponseEntity<?> sendForbidden () {
        return ResponseEntity.status(403).build();
    }

    public ResponseEntity<?> sendForbidden (String message) {
        return ResponseEntity.status(403).body(new ResponseBody(message));
    }

    public ResponseEntity<?> sendDeactivatedUser() {
        return ResponseEntity.status(500).body(new DeactivatedUserResponseBody("Deactivated user!", false));
    }

    public ResponseEntity<?> sendDeactivatedUser(String message) {
        return ResponseEntity.status(500).body(new DeactivatedUserResponseBody(message, false));
    }

}
