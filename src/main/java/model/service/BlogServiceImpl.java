package model.service;

import model.entities.Blog;
import model.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Blog save(Blog blog) {
        Blog b = null;
        try {
            b = blogRepository.save(blog);
        }catch (Exception e){
            b = null;
        }
        return b;
    }

    @Override
    public boolean delete(Long id) {
        try {
            blogRepository.delete(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
