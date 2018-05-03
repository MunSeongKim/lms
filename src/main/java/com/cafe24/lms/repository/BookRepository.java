package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
