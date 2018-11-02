package com.codeup.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class PostService {

    private PostsRepo postsRepo;

    public PostService(PostsRepo postsRepo) {
        this.postsRepo = postsRepo;
    }


//    private List<Post> posts;
//
//    public PostService() {
//        posts = new ArrayList<>();
//        createPosts();
//    }

    public Iterable<Post> findAll() {
        return postsRepo.findAll();
    }

    public Post findOne(long id) {
        return postsRepo.findOne(id);
    }

    public Post save(Post post) {
        return postsRepo.save(post);
    }

    public Post edit(Post post) {
        return postsRepo.save(post);
    }

    public List<Post> search(String term){
//        return adsRepo.findAllByTitleContainsOrDescriptionContains(term, term);
        return postsRepo.searchByTitleOrBody(term);
    }

//    public void delete(long id){
//        postsRepo.deleteById(id);
//    }

    public void delete(Post post){
        postsRepo.delete(post);
    }


    private void createPosts() {
        save(new Post(1, "post 1", "Jelly beans jelly-o marzipan jelly biscuit. Gingerbread muffin caramels ice cream danish."));
        save(new Post(2, "post 2", "Toffee cookie candy canes chocolate cake cake danish candy canes powder. Gingerbread muffin caramels ice cream danish."));
        save(new Post(3, "post 3", "Toffee cookie candy canes chocolate cake cake danish candy canes powder. Gingerbread muffin caramels ice cream danish."));

    }
}
