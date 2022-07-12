package com.tundeadetunji.blogsapi.web.controllers;

import com.tundeadetunji.blogsapi.business.models.Blog;
import com.tundeadetunji.blogsapi.business.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    ApplicationContext context;

    private BlogRepository blogRepository;

    @GetMapping("/blog/id")
    public ResponseEntity<Object> getBlogById(@PathParam("value") Long value) {
        String message = "Retrieved blog #" + value.toString();
        HttpStatus status = HttpStatus.OK;
        SingleReturnData data;

        if (value == null) {
            message = "Id wasn't specified!";
            data = new SingleReturnData(message);
            status = HttpStatus.BAD_REQUEST;
        }

        blogRepository = context.getBean(BlogRepository.class);

        if (blogRepository.existsById(value) == false) {
            message = "Given Id didn't match any blog!";
            data = new SingleReturnData(message);
            status = HttpStatus.NOT_FOUND;
        } else {
            Blog blog = blogRepository.findById(Long.valueOf(value)).get();
            data = new SingleReturnData(message, blog);
            status = HttpStatus.FOUND;
        }

        return ResponseEntity.status(status).body(data);
    }

    @GetMapping("/blog/author")
    public ResponseEntity<Object> getBlogByAuthor(@PathParam("value") String value) {
        String message;
        HttpStatus status = HttpStatus.OK;
        MultipleReturnData data;

        if (value == null) {
            message = "Author wasn't specified!";
            data = new MultipleReturnData(message);
            status = HttpStatus.BAD_REQUEST;
        }

        blogRepository = context.getBean(BlogRepository.class);

        Long howManyBlogsByGivenAuthor = blogRepository.HowManyBlogsByAuthor(value);
        if (howManyBlogsByGivenAuthor < 1) {
            message = "Given author didn't match any blog!";
            data = new MultipleReturnData(message);
            status = HttpStatus.NOT_FOUND;
        }

        List<Blog> blogs = blogRepository.findByAuthor(value);
        message = "Retrieved " + toPlural(howManyBlogsByGivenAuthor, "by " + value);
        data = new MultipleReturnData(message, blogs);
        status = HttpStatus.FOUND;

        return ResponseEntity.status(status).body(data);
    }

    @GetMapping("/blog/title")
    public ResponseEntity<Object> getBlogByTitle(@PathParam("value") String value) {
        String message;
        HttpStatus status = HttpStatus.OK;
        MultipleReturnData data;

        if (value == null) {
            message = "Title wasn't specified!";
            data = new MultipleReturnData(message);
            status = HttpStatus.BAD_REQUEST;
        }

        blogRepository = context.getBean(BlogRepository.class);

        Long howManyBlogsWithGivenTitle = blogRepository.HowManyBlogsWithTitle(value);
        if (howManyBlogsWithGivenTitle < 1) {
            message = "Given title didn't match any blog!";
            data = new MultipleReturnData(message);
            status = HttpStatus.NOT_FOUND;
        }

        List<Blog> blogs = blogRepository.findByTitle(value);
        message = "Retrieved " + toPlural(howManyBlogsWithGivenTitle, "titled " + value);
        data = new MultipleReturnData(message, blogs);
        status = HttpStatus.FOUND;

        return ResponseEntity.status(status).body(data);
    }

    @GetMapping("/blog/category")
    public ResponseEntity<Object> getBlogByCategory(@PathParam("value") String value) {
        String message;
        HttpStatus status = HttpStatus.OK;
        MultipleReturnData data;

        if (value == null) {
            message = "Category wasn't specified!";
            data = new MultipleReturnData(message);
            status = HttpStatus.BAD_REQUEST;
        }

        blogRepository = context.getBean(BlogRepository.class);

        Long howManyBlogsInGivenCategory = blogRepository.howManyBlogsInGivenCategory(value);
        if (howManyBlogsInGivenCategory < 1) {
            message = "Given category didn't match any blog!";
            data = new MultipleReturnData(message);
            status = HttpStatus.NOT_FOUND;
        }

        List<Blog> blogs = blogRepository.findByCategory(value);
        message = "Retrieved " + toPlural(howManyBlogsInGivenCategory, "in " + value + " category");
        data = new MultipleReturnData(message, blogs);
        status = HttpStatus.FOUND;

        return ResponseEntity.status(status).body(data);
    }

    @GetMapping("/blog/published")
    public ResponseEntity<Object> getBlogByPublished(@PathParam("value") String value) {
        String message;
        HttpStatus status = HttpStatus.OK;
        MultipleReturnData data;

        if (value == null) {
            message = "Published Date (in the format yyyy/MM/dd) wasn't specified!";
            data = new MultipleReturnData(message);
            status = HttpStatus.BAD_REQUEST;
            return ResponseEntity.status(status).body(data);
        }

        blogRepository = context.getBean(BlogRepository.class);

        Long howManyBlogsPublishedOnGivenDate = blogRepository.howManyBlogsPublishedOnGivenDate(value);
        if (howManyBlogsPublishedOnGivenDate < 1) {
            message = "No blog published on given date!  (Value must be in the format yyyy/MM/dd)";
            data = new MultipleReturnData(message);
            status = HttpStatus.NOT_FOUND;
            return ResponseEntity.status(status).body(data);
        }

        List<Blog> blogs = blogRepository.findByPublished(value);
        message = "Retrieved " + toPlural(howManyBlogsPublishedOnGivenDate, "published on " + value);
        data = new MultipleReturnData(message, blogs);
        status = HttpStatus.FOUND;

        return ResponseEntity.status(status).body(data);
    }

    String toPlural(Long count, String suffix){
        String result = "";
        if(count == 1){
            return "1 blog " + suffix;
        }
        else{
            return count + " blogs " + suffix;
        }
    }
}

class SingleReturnData {
    private String message;
    private Blog blog;

    public SingleReturnData() {
    }

    public SingleReturnData(String message) {
        this.message = message;
    }

    public SingleReturnData(String message, Blog blog) {
        this.message = message;
        this.blog = blog;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
class MultipleReturnData {
    private String message;
    private List<Blog> blogs;

    public MultipleReturnData() {
    }

    public MultipleReturnData(String message) {
        this.message = message;
    }

    public MultipleReturnData(String message, List<Blog> blogs) {
        this.message = message;
        this.blogs = blogs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
