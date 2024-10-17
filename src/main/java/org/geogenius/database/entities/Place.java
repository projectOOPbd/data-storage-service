package org.geogenius.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long placeId;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @JsonProperty("categoryId")
    @Transient
    private Long categoryId;

    @Unsigned
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @Column(name = "latitude")
    @JsonProperty("latitude")
    private String latitude;

    @Column(name = "longitude")
    @JsonProperty("longitude")
    private String longitude;

}
