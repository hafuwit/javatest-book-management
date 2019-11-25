package com.bookmanagement.bookmanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = -4399983923304125399L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 1, max = 1000)
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "copies", nullable = false)
    private int copies;

    public BookEntity() {
    }

    public BookEntity(Long id, String text, String author, int copies) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.copies = copies;
    }

    public BookEntity(String text, String author, int copies) {
        this.text = text;
        this.author = author;
        this.copies = copies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BookEntity))
            return false;
        final BookEntity other = (BookEntity) obj;
        return this.id == other.id;
    }
}
