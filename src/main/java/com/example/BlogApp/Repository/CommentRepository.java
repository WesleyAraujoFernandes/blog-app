package com.example.BlogApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BlogApp.Model.CommentModel;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    List<CommentModel> findByAuthorId(Long authorId);
}
