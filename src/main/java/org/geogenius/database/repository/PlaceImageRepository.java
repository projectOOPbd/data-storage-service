package org.geogenius.database.repository;

import org.geogenius.database.entities.PlaceImage;

import java.util.List;

public class PlaceImageRepository extends CrudRepository<PlaceImage> {
    @Override
    public Object create(PlaceImage placeImage) {
        return executeInTransaction(session -> session.save(placeImage));
    }

    @Override
    public PlaceImage findById(Long id) {
        return executeInTransaction(session -> session.get(PlaceImage.class, id));
    }

    @Override
    public List<PlaceImage> findAll() {
        return executeInTransaction(session -> session.createQuery("from PlaceImage").list());
    }

    @Override
    public PlaceImage update(PlaceImage entity) {

        return executeInTransaction(session -> session.merge(entity));
    }

    @Override
    public void delete(Long id) {
        executeInTransaction(session -> session.createQuery("delete from PlaceImage where placeImageId = :id")
                .setParameter("id", id)
                .executeUpdate());
    }

    public void deleteAllPlaceImages(Long placeId){
        executeInTransaction(session -> session.createQuery("delete from PlaceImage where place.placeId = :placeId")
                        .setParameter("placeId", placeId)
                        .executeUpdate());
    }

    public List<String> findPlaceImageIds(Long placeId) {
        return executeInTransaction(session -> session.createQuery("Select imageId from PlaceImage where place.placeId = :id")
                .setParameter("id",placeId)
                .getResultList());
    }

}
