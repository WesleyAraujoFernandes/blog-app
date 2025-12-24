package com.example.BlogApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogApp.Model.AuthorModel;
import com.example.BlogApp.Repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<AuthorModel> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public AuthorModel addAuthor(AuthorModel author) {
        return authorRepository.save(author);
    }

    public AuthorModel likeAuthor(Long authorId) {
        AuthorModel author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with ID:" + authorId));
        author.setLikes(author.getLikes() + 1);
        return authorRepository.save(author);
    }
}
