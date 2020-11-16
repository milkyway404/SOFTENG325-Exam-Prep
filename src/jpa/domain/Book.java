package jpa.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item {

    private String author;
    private String publisher;
    private int numPages;
}