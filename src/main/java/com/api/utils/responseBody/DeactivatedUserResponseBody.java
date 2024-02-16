package com.api.utils.responseBody;

public record DeactivatedUserResponseBody(
        String message,
        boolean active
) {
}
