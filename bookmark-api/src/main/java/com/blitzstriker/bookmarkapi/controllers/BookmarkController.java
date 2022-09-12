package com.blitzstriker.bookmarkapi.controllers;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import com.blitzstriker.bookmarkapi.payload.BookmarkDTO;
import com.blitzstriker.bookmarkapi.payload.BookmarksDTO;
import com.blitzstriker.bookmarkapi.services.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
    private final BookmarkService bookmarkService;

    @GetMapping
    public ResponseEntity<BookmarksDTO> getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return new ResponseEntity<>(bookmarkService.getBookmarks(page), HttpStatus.OK) ;
    }
}
