package com.bookmanagement.bookmanagement.model;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class BookDTO implements Serializable {

    private static final long serialVersionUID = -6599377999395611975L;

    private Long id;

    @Size(max = 1000)
    private String text;

    @Size(max = 500)
    private String author;

    private int copies;

    public BookDTO() {
    }

    public BookDTO(String text, String author, int copies) {
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
}
