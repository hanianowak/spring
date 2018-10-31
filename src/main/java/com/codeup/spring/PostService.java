package com.codeup.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findOne(long id) {
        return posts.get((int) (id));
    }
    
    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post edit(Post post){
        return posts.set((int) post.getId()-1, post);
    }

    private void createPosts() {
        save(new Post(1,"post 1", "Jelly beans jelly-o marzipan jelly biscuit. Gingerbread muffin caramels ice cream danish."));
        save(new Post(2,"post 2", "Toffee cookie candy canes chocolate cake cake danish candy canes powder. Gingerbread muffin caramels ice cream danish."));
        save(new Post(3,"post 3", "Toffee cookie candy canes chocolate cake cake danish candy canes powder. Gingerbread muffin caramels ice cream danish."));

    }
}
