package com.martin.pasterbin.service;

import com.martin.pasterbin.models.Post;
import com.martin.pasterbin.models.User;
import com.martin.pasterbin.repostitories.PostRepository;
import com.martin.pasterbin.repostitories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ActiveUserService activeUserService;
//    final int activeUserId = activeUserService.getActiveUserId();

    public void addPost(Post post){
        User userWithNewPost = userRepository.findUserById(activeUserService.getActiveUserId());
        post.setPopularity(0);      //*не знаю как сделать что бы в базе данных автоматом выставлялся 0 как базове значение
        userWithNewPost.addPostToUser(post);
        userRepository.save(userWithNewPost);
    }
    public void editPost(int postId, String newPost){
        User userWithNewPost = userRepository.findUserById(activeUserService.getActiveUserId());
        userWithNewPost.updatePostUser(postId, newPost);
        userRepository.save(userWithNewPost);
    }


    public Post showUserPost(int id){
        Optional<Post> post = postRepository.findById(id);
//        if (post.isPresent()){return post.get();}
//        return null;
        return post.orElse(null);
    }

    public Iterable<Post> activeUserPosts(){
        if(activeUserService.getActiveUser()!=null){
            return userRepository.findUserById(activeUserService.getActiveUserId()).getPostList();
        }
        return  null;
    }

    public List<Post> postsRating(){
        Iterable<Post> posts = postRepository.findAll();
        List<Post> result = new ArrayList<>();
        for (Post p:posts) {
            result.add(p);
        }
        return result.stream().sorted((x, y) -> y.getPopularity().compareTo(x.getPopularity())).collect(Collectors.toList());
    }

    public void increasePostPopularity(int id){
        Post post = postRepository.findPostById(id);
        post.setPopularity(post.getPopularity()+1);
        postRepository.save(post);
    }

    public void decreasePostPopularity(int id){
        Post post = postRepository.findPostById(id);
        post.setPopularity(post.getPopularity()-1);
        postRepository.save(post);
    }
}
