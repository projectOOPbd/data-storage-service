package org.geogenius.database.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geogenius.database.controller.PlaceController;
import org.geogenius.database.controller.UserControler;
import org.geogenius.database.service.PlaceService;
import org.geogenius.database.service.UserService;

@Data
@Entity
@Table(name = "Comment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @Column(name = "comment_id")
    @Unsigned
    private int commentId;

    @Column(name = "text")
    @JsonProperty("text")
    private String text;

    @Column(name = "rating")
    @JsonProperty("rating")
    private int rating;

    @Transient
    @JsonProperty("user_id")
    private Long userId;

    @Transient
    @JsonProperty("place_id")
    private Long placeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    @JsonIgnore
    private Place place;


    @PrePersist
    @PreUpdate
    public void onPersist() {
        this.user = UserControler.getUserById(userId);
//        this.place =;
    }
}
