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
        return List.of();
    }

    @Override
    public Place update(Long id, Place entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
