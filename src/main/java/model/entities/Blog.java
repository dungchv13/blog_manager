package model.entities;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String name;

    private String content;

    @Column(nullable = false)
    private String category;

    private String date;

    public Blog() {
        date = LocalDate.now().toString();
    }

    public Blog(String author, String name, String content, String category) {
        this.author = author;
        this.name = name;
        this.content = content;
        this.category = category;
        date = LocalDate.now().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
