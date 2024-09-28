package org.geogenius.database.entities;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "place_image")
public class PlaceImage {
    @Id
    @Column(name = "place_image_id")
    @Unsigned
    private int placeImageId;

    @Column(name = "image_name")
    private String imageId;

    @Column(name = "place_id")
    private String placeId;

}
