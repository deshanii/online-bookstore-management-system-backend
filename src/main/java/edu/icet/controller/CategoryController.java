package edu.icet.controller;

import edu.icet.dto.Category;
import edu.icet.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor


public class CategoryController {
    @Autowired
    final CategoryService service;

    @GetMapping("/get-category")
    public List<Category> getcategory(){

        return service.getAll();
    }

    @PostMapping("/add-category")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody Category category){
        System.out.println(category);
        service.addCategory(category);
    }

    @GetMapping("/search-by-id/{Id}")
    public Category getCategoryByid(@PathVariable Integer id){
        return service.searchCategoryById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCategoryById(@PathVariable Integer id){
        service.deleteCategoryById(id);
    }

    @PutMapping("/update-category")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBook(@RequestBody Category category){
        service.updateCategoryById(category);
    }


}
