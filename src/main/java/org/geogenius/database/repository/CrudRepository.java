package org.geogenius.database.repository;

import org.geogenius.utils.hibernate.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public abstract class CrudRepository<T> {
    abstract Object create(T entity);
    abstract T findById(Long id);
    abstract List<T> findAll();
    abstract T update(Long id, T entity);
    abstract void delete(Long id);

    protected <R> R executeInTransaction(TransactionFunction<R> function) {
        Session session = SessionManager.getSession();
        Transaction transaction = session.getTransaction();
        R result = null;
        try {
            transaction.begin();
            result = function.apply(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.getStatus() == TransactionStatus.ACTIVE || transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
}