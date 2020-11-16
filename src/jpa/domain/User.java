package jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    protected Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Item> loanedItems = new HashSet<>();
}
