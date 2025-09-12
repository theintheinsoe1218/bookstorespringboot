package com.tts.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.bookstore.models.Category;
import com.tts.bookstore.repos.CategoryRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;

    public List<Category> getAll() {
        List<Category> cats = categoryRepo.findAll();
        return cats;
    }

    public void add(Category category) {

        categoryRepo.save(category);
    }

    public void updateCat(Category category) {
        Category existCat = categoryRepo.findById(category.getId())
                .orElseThrow(() -> new RuntimeException("No role with that id!"));
        if (existCat != null) {

            categoryRepo.save(category);
        }

    }

    public void drop(Integer id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No role with that id!"));
        if (category != null) {
            categoryRepo.delete(category);
        }
    }
}
