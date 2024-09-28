package org.geogenius.database.service;

import org.geogenius.database.entities.Category;
import org.geogenius.database.repository.CategoryRepository;

public class CategoryService {
    private static final CategoryRepository categoryRepository = new CategoryRepository();

    public static void create(Category category) {
        categoryRepository.create(category);
    }

    public static Category getCategoryByID(Long id) {
        return categoryRepository.findById(id);
    }
}
