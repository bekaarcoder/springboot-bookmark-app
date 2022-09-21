package com.blitzstriker.bookmarkapi.services;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import com.blitzstriker.bookmarkapi.payload.BookmarkDTO;
import com.blitzstriker.bookmarkapi.payload.BookmarksDTO;
import com.blitzstriker.bookmarkapi.payload.CreateBookmarkRequest;

import java.util.List;

public interface BookmarkService {
    BookmarksDTO getBookmarks(Integer page);
    BookmarksDTO searchBookmarks(String query, Integer page);
    BookmarkDTO createBookmark(CreateBookmarkRequest bookmark);
    Bookmark updateBookmark(Bookmark bookmark, Long id);
    void deleteBookmark(Long id);
}
