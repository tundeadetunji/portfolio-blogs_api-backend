package com.tundeadetunji.blogsapi.business.repositories;

import com.tundeadetunji.blogsapi.business.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("SELECT b FROM Blog b WHERE b.title=?1")
    List<Blog> findByTitle(String title);

    @Query("SELECT count(*) FROM Blog b WHERE b.title=?1")
    Long HowManyBlogsWithTitle(String title);

    @Query("SELECT b FROM Blog b WHERE b.author=?1")
    List<Blog> findByAuthor(String author);

    @Query("SELECT count(*) FROM Blog b WHERE b.author=?1")
    Long HowManyBlogsByAuthor(String author);

    @Query("SELECT b FROM Blog b WHERE b.category=?1")
    List<Blog> findByCategory(String category);

    @Query("SELECT count(*) FROM Blog b WHERE b.category=?1")
    Long howManyBlogsInGivenCategory(String category);

    @Query("SELECT b FROM Blog b WHERE b.published=?1")
    List<Blog> findByPublished(String published);

    @Query("SELECT count(*) FROM Blog b WHERE b.published=?1")
    Long howManyBlogsPublishedOnGivenDate(String published);
}
