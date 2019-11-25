package com.bookmanagement.bookmanagement.repository;

import com.bookmanagement.bookmanagement.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findDistinctByTextIgnoreCaseContaining(String text);

    @Query("SELECT id FROM BookEntity")
    List<Long> getAllIds();

    @Query("SELECT b FROM BookEntity b where b.author = :author")
    List<BookEntity> findAuthor(@Param("author") String author);

    @Query("SELECT COALESCE(SUM(copies),0) FROM BookEntity b where b.text = :text")
    int allCopiesByBookName(@Param("text") String text);

    @Query("SELECT COALESCE(SUM(copies),0) FROM BookEntity b where b.author = :author")
    int allCopiesOfAuthor(@Param("author") String author);
}
