package com.example.book_nest.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ResponseStatus {
	@JsonProperty("success")
	SUCCESS, @JsonProperty("error")
	ERROR,
}
