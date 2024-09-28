package org.geogenius.database.repository;

import org.hibernate.Session;

@FunctionalInterface
public interface TransactionFunction<T>{
    T apply(Session session);
}
