package com.example.BlogApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BlogApp.Model.AuthorModel;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {

}
