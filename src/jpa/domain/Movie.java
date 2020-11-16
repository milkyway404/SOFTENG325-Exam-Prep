package jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie extends Item {

    private String studioName;
    private String director ;

    @ElementCollection
    @CollectionTable(name = "MovieActors",
            joinColumns = @JoinColumn(name = "movieId"))
    @Column(name = "actorName")
    private Set<String> actors = new HashSet<>();
}
