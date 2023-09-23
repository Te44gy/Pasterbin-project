package com.martin.pasterbin.controllers;

import com.martin.pasterbin.models.User;
import com.martin.pasterbin.repostitories.UserRepository;
import com.martin.pasterbin.service.PostService;
import com.martin.pasterbin.service.ActiveUserService;
import com.martin.pasterbin.models.Post;
import com.martin.pasterbin.repostitories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.stereotype.Controller
@RequestMapping("/pasterbin")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ActiveUserService activeUserService;
    @Autowired
    PostService postService;


    @GetMapping("/home")
    public String homePage(Model model){
        List<Post> posts2 = postService.postsRating();
        model.addAttribute("posts", posts2);
        model.addAttribute("attributeUserName", activeUserService.getActiveUserName()); //передает имя текущ рользывателя
        System.out.println("Загрузка главной страницы");
        return "home-page";
    }

    @GetMapping("/addPost")
    public String addPost(@ModelAttribute("attributePost") Post post){
        if(activeUserService.getActiveUser()==null){
            return "redirect:/pasterbin/home";
        }
        return "add-post";
    }

    @PostMapping("/addPost")
    public String addingPost(@ModelAttribute("attributePost") Post post){
        postService.addPost(post);
        return "redirect:/pasterbin/home";
    }

    @GetMapping("/post/{id}")
    public String postInfo(@PathVariable(value = "id") int id, Model model){
        Post post = postService.showUserPost(id);
        if (post!=null){
            model.addAttribute("post", post);
            return "post-info";
        }
        return "redirect:/pasterbin/home";

    }

    @GetMapping("/personalPosts")
    public String personalPostsList(Model model){
        Iterable<Post> posts = postService.activeUserPosts();
        if(posts!=null){
            model.addAttribute("posts", posts);
            return "personal-posts";
        }
        return  "redirect:/pasterbin/home";
    }

    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable(value="id") int id){
        postRepository.deleteById(id);
        return "redirect:/pasterbin/personalPosts";
    }

    @GetMapping("/like/{id}")
    public String likePost(@PathVariable(value="id") int id){
        if(activeUserService.getActiveUser()!=null){
        postService.increasePostPopularity(id);
        }
        return "redirect:/pasterbin/post/{id}";
    }
    @GetMapping("/dislike/{id}")
    public String dislikePost(@PathVariable(value="id") int id){
        if(activeUserService.getActiveUser()!=null){
        postService.decreasePostPopularity(id);
        }
        return "redirect:/pasterbin/post/{id}";
    }

    @GetMapping("/editPost/{id}")
    public String editPost(@PathVariable(value = "id") int id, Model model, @ModelAttribute("attributePost") Post post){
        model.addAttribute("post", postRepository.findPostById(id));
        return "post-edit";
    }

    @PostMapping("/editPost/{id}")
    public String editedPost(@PathVariable(value = "id") int postId,
                             @ModelAttribute("attributePost") Post post){
        postService.editPost(postId, post.getPost());
        return "redirect:/pasterbin/personalPosts";
    }


    @GetMapping("/admin")
    public String admin(){
//        Post post = postRepository.findPostById(2);
//        User user = userRepository.findUserById(3);
//        System.out.println("Всё найдено");
//        user.addPostToUser(post);
//        userRepository.save(user);

//        User userWithNewPost = userRepository.findUserById(4);
//        userWithNewPost.addPostToUser(postRepository.findPostById(4));
//        userRepository.save(userWithNewPost);

//        postRepository.delete(postRepository.findPostById(14));

//        User user = userRepository.findUserById(3);
//        user.setPassword("123");
//        userRepository.save(user);
//        userRepository.save(user);
//        User user2 = userRepository.findUserById(2);
//        user.setPassword("123");
//        userRepository.save(user);
//        User user3 = userRepository.findUserById(1);
//        userRepository.deleteById(1);

//        List<Post> posts = postService.postsRating();
        return "redirect:/pasterbin/home";
    }
}
