package com.tundeadetunji.blogsapi;

import com.tundeadetunji.blogsapi.business.policies.General;
import com.tundeadetunji.blogsapi.business.models.Blog;
import com.tundeadetunji.blogsapi.business.models.Role;
import com.tundeadetunji.blogsapi.business.models.User;
import com.tundeadetunji.blogsapi.business.services.BlogService;
import com.tundeadetunji.blogsapi.business.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BlogsapiApplication extends General {

    public static void main(String[] args) {
        SpringApplication.run(BlogsapiApplication.class, args);
		System.out.println("app started.....");
    }

    private InitialDBData data = new InitialDBData();
    @Bean
    CommandLineRunner commandLineRunner(UserService userService, BlogService blogService){
        return args -> {
            //roles
            userService.saveRole(new Role(null, General.userRoles.ROLE_ADMIN.toString()));
            userService.saveRole(new Role(null, General.userRoles.ROLE_USER.toString()));
            //users
            userService.saveUser(new User(null, "jane@blogs.com", "jane@blogs.com", "password", "Jane", "Doe", new ArrayList<>()));
            //users' roles
            userService.addRoleToUser("jane@blogs.com", userRoles.ROLE_ADMIN.toString());
            userService.addRoleToUser("jane@blogs.com", userRoles.ROLE_USER.toString());
            //blogs
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_1_category, data.blog_1_title, data.blog_1_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_1_content, data.blog_1_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_2_category, data.blog_2_title, data.blog_2_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_2_content, data.blog_2_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_3_category, data.blog_3_title, data.blog_3_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_3_content, data.blog_3_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_4_category, data.blog_4_title, data.blog_4_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_4_content, data.blog_4_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_5_category, data.blog_5_title, data.blog_5_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_5_content, data.blog_5_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_6_category, data.blog_6_title, data.blog_6_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_6_content, data.blog_6_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_7_category, data.blog_7_title, data.blog_7_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_7_content, data.blog_7_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_8_category, data.blog_8_title, data.blog_8_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_8_content, data.blog_8_content_lead));
            blogService.saveBlog(new Blog(null, UUID.randomUUID().toString(), data.blog_9_category, data.blog_9_title, data.blog_9_author, new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), new SimpleDateFormat("yyyy/MM/dd").format(new Date(System.currentTimeMillis())), data.blog_9_content, data.blog_9_content_lead));
        };
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

class InitialDBData{

    public String blog_1_author = "James Business";
    public String blog_1_category = "Business";
    public String blog_1_title = "The First Business";
    public String blog_1_content = "The First Business\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_1_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_2_author = "John Business";
    public String blog_2_category = "Business";
    public String blog_2_title = "The Second Business";
    public String blog_2_content = "The Second Business\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_2_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_3_author = "Janet Business";
    public String blog_3_category = "Business";
    public String blog_3_title = "The Third Business";
    public String blog_3_content = "The Third Business\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_3_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_4_author = "Jane Culture";
    public String blog_4_category = "Culture";
    public String blog_4_title = "The 1st Culture";
    public String blog_4_content = "The 1st Culture\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_4_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_5_author = "Amy Culture";
    public String blog_5_category = "Culture";
    public String blog_5_title = "The 2nd Culture";
    public String blog_5_content = "The 2nd Culture\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_5_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_6_author = "Janice Culture";
    public String blog_6_category = "Culture";
    public String blog_6_title = "The 3rd Culture";
    public String blog_6_content = "The 3rd Culture\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_6_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_7_author = "Sandra Lifestyle";
    public String blog_7_category = "Lifestyle";
    public String blog_7_title = "Lifestyle 1";
    public String blog_7_content = "Lifestyle 1\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_7_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_8_author = "Tanya Lifestyle";
    public String blog_8_category = "Lifestyle";
    public String blog_8_title = "Lifestyle 2";
    public String blog_8_content = "Lifestyle 2\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_8_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";

    public String blog_9_author = "Charlotte Lifestyle";
    public String blog_9_category = "Lifestyle";
    public String blog_9_title = "Lifestyle 3";
    public String blog_9_content = "Lifestyle 3\n" +
            " \n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?\n" +
            " Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
    public String blog_9_content_lead = "Lorem ipsum dolor sit amet, consectetur adipisicing elit. A adipisci assumenda aut consectetur, enim ex expedita, illum natus officiis pariatur porro possimus quisquam reiciendis repellendus rerum suscipit temporibus totam, voluptas?";
}