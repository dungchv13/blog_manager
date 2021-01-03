package controllers;

import model.entities.Blog;
import model.entities.Response;
import model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private Response response;

    @GetMapping
    public Response list(){
        List<Blog> blogs = blogService.findAll();

        response.data = blogs;

        if(blogs.isEmpty()){
            response.status = response.ERROR;
            response.message = "ko co blog nao || loi roi ban ehh";
        }else{
            response.status = response.SUCCESS;
            response.message = "Success";
        }

        return response;
    }



    @PostMapping("/create")
    @ResponseBody
    public Response writeBlog(@RequestBody Blog blog){
        try{
            response.data = blogService.save(blog);
        }catch (Exception e){
             response.status = response.ERROR;
             response.message = "cant save the blog";
             return response;
        }
        response.status = response.SUCCESS;
        response.message = "the blog was save";
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteBlog(@PathVariable Long id){

        boolean isDelete = blogService.delete(id);
        response.data = isDelete;
        if(isDelete){
            response.status = response.SUCCESS;
            response.message = "the blog was delete";
        }else{
            response.status = response.ERROR;
            response.message = "cant delete the blog";
        }
        return response;
    }

    @GetMapping("/search")
    public Response searchById(@RequestBody Long id){
        Blog blog = blogService.findById(id);
        response.data = blog;
        if(blog != null){
            response.status = response.SUCCESS;
            response.message = "da tim thay";
        }else{
            response.status = response.ERROR;
            response.message = "cant find the blog";
        }
        return response;

    }
}
