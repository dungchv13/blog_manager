package model.service;

import model.entities.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    Blog save(Blog blog);

    boolean delete(Long id);
}
