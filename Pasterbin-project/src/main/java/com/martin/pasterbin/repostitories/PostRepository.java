package com.martin.pasterbin.repostitories;

import com.martin.pasterbin.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
    public Post findPostById(Integer id);
//    public Iterable<Post> findAllBy(Integer id);
}
