package org.geogenius.database.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @JsonProperty("first_name")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @Column(name = "last_name")
    private String lastName;

    @JsonProperty("nickname")
    @Column(name = "nickname")
    private String nickname;

    @JsonProperty("age")
    @Column(name = "age")
    private int age;

    @JsonProperty("email")
    @Column(name = "email")
    private String email;

    @JsonProperty("image_id")
    @Column(name = "image_id")
    private String imageId;
}
