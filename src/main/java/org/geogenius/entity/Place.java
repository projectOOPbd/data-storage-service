package org.geogenius.entity;

import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Place")
public class Place {
    @Id
    @Column(name = "place_id")
    @Unsigned
    private int placeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Unsigned
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longtude")
    private String longitude;
}
