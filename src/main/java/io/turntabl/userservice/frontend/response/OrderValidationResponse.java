package io.turntabl.userservice.frontend.response;

import io.turntabl.userservice.dto.OrderValidationDto;

public class OrderValidationResponse {
    public static OrderValidationResponse fromDTO(OrderValidationDto orderValidationDto) {
            return new OrderValidationResponse();
    }
}
