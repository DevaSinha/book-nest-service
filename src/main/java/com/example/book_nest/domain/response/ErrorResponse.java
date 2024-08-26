package com.example.book_nest.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    @Schema(defaultValue = "error")
    private ResponseStatus status;
    private Error error;
}
