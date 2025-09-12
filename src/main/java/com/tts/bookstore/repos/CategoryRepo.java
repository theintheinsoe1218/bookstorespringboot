package com.tts.bookstore.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tts.bookstore.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
