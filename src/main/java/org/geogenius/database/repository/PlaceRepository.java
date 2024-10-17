package org.geogenius.database.repository;

import org.geogenius.database.entities.Place;

import java.util.List;

public class PlaceRepository extends CrudRepository<Place> {
    @Override
    public Object create(Place place) {
        return executeInTransaction(session -> session.save(place));
    }

    @Override
    public Place findById(Long id) {
        return executeInTransaction(session -> session.get(Place.class, id));
    }

    @Override
    public List<Place> findAll() {
        return executeInTransaction(session -> session.createQuery("from Place").list());
    }

    @Override
    public Place update(Place entity) {
        return executeInTransaction(session -> session.merge(entity));
    }

    @Override
    public void delete(Long id) {
        executeInTransaction(session -> session.createQuery("delete from Place where id = :id")
                .setParameter("id", id)
                .executeUpdate());
    }

    public long countPlaceWithCategory(Long categoriesID) {
        return executeInTransaction(session -> session.createQuery("select count(*) from Place where category.id = :id",Long.class)
                .setParameter("id",categoriesID)
                .getSingleResult());
    }

}
