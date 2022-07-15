package com.tundeadetunji.blogsapi.business.services;

import com.tundeadetunji.blogsapi.business.models.Blog;
import com.tundeadetunji.blogsapi.business.repositories.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImplementation implements BlogService{

    private final BlogRepository blogRepository;

    public BlogServiceImplementation(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }


}
