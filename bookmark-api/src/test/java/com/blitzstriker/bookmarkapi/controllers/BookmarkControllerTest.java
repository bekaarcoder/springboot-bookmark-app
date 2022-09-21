package com.blitzstriker.bookmarkapi.controllers;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import com.blitzstriker.bookmarkapi.repositories.BookmarkRespository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
class BookmarkControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookmarkRespository bookmarkRespository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp() {
        bookmarkRespository.deleteAllInBatch();
        bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "Google", "https://www.google.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Youtube", "https://www.youtube.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Netflix", "https://www.netflix.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Amazon", "https://www.amazon.com", Instant.now()));
        bookmarks.add(new Bookmark(null, "Goodreads", "https://www.goodreads.com", Instant.now()));

        bookmarkRespository.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,5,3",
            "2,5,3"
    })
    void shouldGetBookmarks(int pageNo, int totalElements, int totalPages) throws Exception {
        mvc.perform(get("/api/bookmarks?page="+pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(pageNo)));
    }

    @Test
    void shouldCreateBookmarkSuccessfully() throws Exception {
        this.mvc.perform(
                post("/api/bookmarks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "title": "Amazon",
                                    "url": "https://www.amazon.in"
                                }
                                """)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.title", is("Amazon")))
                .andExpect(jsonPath("$.url", is("https://www.amazon.in")));
    }
}