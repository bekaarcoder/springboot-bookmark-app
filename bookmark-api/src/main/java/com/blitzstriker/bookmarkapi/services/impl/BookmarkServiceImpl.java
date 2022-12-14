package com.blitzstriker.bookmarkapi.services.impl;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import com.blitzstriker.bookmarkapi.payload.BookmarkDTO;
import com.blitzstriker.bookmarkapi.payload.BookmarksDTO;
import com.blitzstriker.bookmarkapi.payload.CreateBookmarkRequest;
import com.blitzstriker.bookmarkapi.repositories.BookmarkRespository;
import com.blitzstriker.bookmarkapi.services.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.Instant;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {
    private final BookmarkRespository bookmarkRespository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public BookmarksDTO getBookmarks(Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = bookmarkRespository.findAll(pageable).map(bookmark -> modelMapper.map(bookmark, BookmarkDTO.class));
        return new BookmarksDTO(bookmarkPage);
    }

    @Override
    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmarks(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page - 1;
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = bookmarkRespository.findByTitleContainingIgnoreCase(query, pageable).map(bookmark -> modelMapper.map(bookmark, BookmarkDTO.class));
        return new BookmarksDTO(bookmarkPage);
    }

    @Override
    public BookmarkDTO createBookmark(CreateBookmarkRequest request) {
        Bookmark bookmark = new Bookmark();
        bookmark.setTitle(request.getTitle());
        bookmark.setUrl(request.getUrl());
        bookmark.setCreatedAt(Instant.now());
        Bookmark savedBookmark = bookmarkRespository.save(bookmark);
        return modelMapper.map(savedBookmark, BookmarkDTO.class);
    }

    @Override
    public Bookmark updateBookmark(Bookmark bookmark, Long id) {
        return null;
    }

    @Override
    public void deleteBookmark(Long id) {

    }
}
