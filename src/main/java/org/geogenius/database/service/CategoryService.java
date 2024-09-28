package org.geogenius.database.service;

import org.geogenius.database.entities.Category;
import org.geogenius.database.repository.CategoryRepository;

public class CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepository();

    public void create(Category category) {
        categoryRepository.create(category);
    }
}
