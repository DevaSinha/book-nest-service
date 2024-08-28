package com.example.book_nest.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
	@Schema(defaultValue = "error")
	private ResponseStatus status;
	private Error error;

	public ErrorResponse(Error error) {
		this.error = error;
		this.status = ResponseStatus.ERROR;
	}

	public static ErrorResponse of(Error error) {
		return new ErrorResponse(error);
	}
}
