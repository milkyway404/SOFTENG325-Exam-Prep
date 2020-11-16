package jpa;

import javax.persistence.*;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

public class JPA {

    public static void main (String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exam-prep-database");
    }
}
