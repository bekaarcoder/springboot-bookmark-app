package com.blitzstriker.bookmarkapi.services;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import com.blitzstriker.bookmarkapi.payload.BookmarksDTO;

import java.util.List;

public interface BookmarkService {
    BookmarksDTO getBookmarks(Integer page);
    Bookmark createBookmark(Bookmark bookmark);
    Bookmark updateBookmark(Bookmark bookmark, Long id);
    void deleteBookmark(Long id);
}
