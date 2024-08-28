package com.example.book_nest.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse<T> {
	private ResponseStatus status;
	private T data;

	public SuccessResponse(T data) {
		this.status = ResponseStatus.SUCCESS;
		this.data = data;
	}

	public static <T> SuccessResponse<T> of(T response) {
		return new SuccessResponse(response);
	}
}
