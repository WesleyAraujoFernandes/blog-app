package com.example.BlogApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApp.Model.AuthorModel;
import com.example.BlogApp.Model.CommentModel;
import com.example.BlogApp.Repository.AuthorRepository;
import com.example.BlogApp.Repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    AuthorRepository authorRepository;

    public CommentModel addComment(Long authorId, String content) {
        Optional<AuthorModel> optionalAuthor = authorRepository.findById(authorId);
        if (optionalAuthor.isPresent()) {
            CommentModel comment = new CommentModel(content, optionalAuthor.get());
            return commentRepository.save(comment);
        }
        throw new RuntimeException("Author not found with ID:" + authorId);
    }

}
