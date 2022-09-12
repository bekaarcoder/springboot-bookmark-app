package com.blitzstriker.bookmarkapi.repositories;

import com.blitzstriker.bookmarkapi.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRespository extends JpaRepository<Bookmark, Long> {
}
