package org.geogenius.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "Place_Image")
public class PlaceImage {

    @Id
    @Column(name = "place_image_id")
    @Unsigned
    private int placeImageId;

    @Column(name = "image_id")
    @JsonIgnore
    private String imageId;

    @Column(name = "place_id")
    @Transient
    private int placeId;


    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonIgnore
    private Place place;
}
