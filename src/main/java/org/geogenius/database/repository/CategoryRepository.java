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
        return executeInTransaction(session -> session.createQuery("from Category").list());
    }
    
    @Override
    public Category update(Category entity) {
        return executeInTransaction(session -> session.merge(entity));
    }

    @Override
    public void delete(Long id) {
        executeInTransaction(session -> session.createQuery("delete from Category where id = :id")
                .setParameter("id", id)
                .executeUpdate());
    }

}
