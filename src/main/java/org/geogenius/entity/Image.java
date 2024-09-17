package org.geogenius.entity;

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
@Table(name = "Image")
public class Image {
    @Id
    @Column(name = "image_id")
    @Unsigned
    private int id;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_link")
    private String imageLink;


    @Unsigned
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
}
