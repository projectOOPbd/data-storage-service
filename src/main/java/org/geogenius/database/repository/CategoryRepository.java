package org.geogenius.database.repository;

import org.geogenius.database.entities.Category;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public class CategoryRepository extends CrudRepository<Category> {


    @Override
    public Object create(Category category) {
        return executeInTransaction(session -> session.save(category) );
    }

    @Override
    public Category findById(Long id) {
        return executeInTransaction(session -> session.get(Category.class, id));
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Category update(Long id, Category entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

}
