package org.geogenius.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Category")
@Entity
@Data
public class Category {
    @Id
    @Column(name = "category_id")
    @JsonIgnore
    private int categoryId;

    @Column(name = "category_name")
    @JsonProperty("name")
    private String name;

}
