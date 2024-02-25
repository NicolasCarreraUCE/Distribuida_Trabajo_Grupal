package com.distribuida.dto;

import com.distribuida.model.Books;

import java.math.BigDecimal;

public class BooksDto {
    private Integer id;
    private String isbn;
    private String title;
    private BigDecimal price;
    private String authorName;
    public static BooksDto from (Books obj) {
        BooksDto ret = new BooksDto();

        ret.setId(obj.getId());
        ret.setIsbn(obj.getIsbn());
        ret.setPrice(obj.getPrice());
        ret.setTitle(obj.getTitle());

        return ret;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
