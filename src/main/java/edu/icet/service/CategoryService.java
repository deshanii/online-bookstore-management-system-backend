package edu.icet.service;

import edu.icet.dto.Category;


import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    void addCategory(Category category);
    void deleteCategoryById(Integer id);
    Category searchCategoryById(Integer id);
    void updateCategoryById(Category category);

}
