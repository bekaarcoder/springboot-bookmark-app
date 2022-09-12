/*
package com.blitzstriker.bookmarkapi.utils;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import com.blitzstriker.bookmarkapi.repositories.BookmarkRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRespository bookmarkRespository;

    @Override
    public void run(String... args) throws Exception {
        bookmarkRespository.save(new Bookmark(null, "Google", "https://www.google.com", Instant.now()));
        bookmarkRespository.save(new Bookmark(null, "Youtube", "https://www.youtube.com", Instant.now()));
        bookmarkRespository.save(new Bookmark(null, "Netflix", "https://www.netflix.com", Instant.now()));
        bookmarkRespository.save(new Bookmark(null, "Amazon", "https://www.amazon.com", Instant.now()));
        bookmarkRespository.save(new Bookmark(null, "Goodreads", "https://www.goodreads.com", Instant.now()));
    }
}
*/
