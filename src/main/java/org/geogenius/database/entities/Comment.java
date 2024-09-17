package org.geogenius.database.entities;


import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String text;

    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Unsigned
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    @Unsigned
    private Place place;
}
