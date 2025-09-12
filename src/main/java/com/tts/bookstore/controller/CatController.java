package com.tts.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.bookstore.models.Category;
import com.tts.bookstore.services.CategoryService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/cats")
public class CatController {
    @Autowired
    private final CategoryService catService;

    @GetMapping("")
    public String all(Model model) {
        List<Category> cats = catService.getAll();
        model.addAttribute("cats", cats);
        return "category/all";
    }

}
