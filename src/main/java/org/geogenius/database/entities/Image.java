package org.geogenius.database.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

    @JsonProperty("image_name")
    private String imageName;


    @JsonProperty("image")
    public String image;
}
