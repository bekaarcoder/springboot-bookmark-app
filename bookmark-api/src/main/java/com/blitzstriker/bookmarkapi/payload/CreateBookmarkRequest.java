package com.blitzstriker.bookmarkapi.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CreateBookmarkRequest {
    @NotEmpty(message = "Title should not be empty")
    private String title;

    @NotEmpty(message = "URL should not be empty")
    private String url;
}
