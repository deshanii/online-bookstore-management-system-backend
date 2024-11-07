package edu.icet.service.Impl;

import edu.icet.dto.Category;
import edu.icet.entity.CategoryEntity;
import edu.icet.repository.CategoryRepository;
import edu.icet.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();

        List<CategoryEntity> categoryEntities = repository.findAll();

        for(CategoryEntity categoryEntity : categoryEntities){
            categoryList.add(mapper.map(categoryEntity, Category.class));
        }
        return categoryList;
    }

    @Override
    public void addCategory(Category category) {
        repository.save(mapper.map(category, CategoryEntity.class));

    }

    @Override
    public void deleteCategoryById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public Category searchCategoryById(Integer id) {
        return mapper.map(repository.findById(id), Category.class);
    }

    @Override
    public void updateCategoryById(Category category) {
        repository.save(mapper.map(category,CategoryEntity.class));

    }
}
