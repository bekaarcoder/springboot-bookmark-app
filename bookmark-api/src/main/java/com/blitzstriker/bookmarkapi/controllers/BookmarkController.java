package com.blitzstriker.bookmarkapi.controllers;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import com.blitzstriker.bookmarkapi.payload.BookmarkDTO;
import com.blitzstriker.bookmarkapi.payload.BookmarksDTO;
import com.blitzstriker.bookmarkapi.payload.CreateBookmarkRequest;
import com.blitzstriker.bookmarkapi.services.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping
    public ResponseEntity<BookmarksDTO> getBookmarks(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "query", defaultValue = "") String query
    ) {
        if (query == null || query.trim().length() == 0) {
            return new ResponseEntity<>(bookmarkService.getBookmarks(page), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookmarkService.searchBookmarks(query, page), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<BookmarkDTO> createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
        return new ResponseEntity<>(bookmarkService.createBookmark(request), HttpStatus.CREATED);
    }
}
