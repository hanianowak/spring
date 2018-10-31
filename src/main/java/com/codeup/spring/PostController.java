package com.codeup.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    PostService postService  = new PostService();
    
        @GetMapping("/posts")
    public String postsIndex(Model vModel) {
//        posts.add(new Post(2L,"post 2", "Jelly beans jelly-o marzipan jelly biscuit. Toffee cookie candy canes chocolate cake cake danish candy canes powder. Gingerbread muffin caramels ice cream danish."));
//        posts.add(new Post(3L,"post 3", "Jelly beans jelly-o marzipan jelly biscuit. Toffee cookie candy canes chocolate cake cake danish candy canes powder. Gingerbread muffin caramels ice cream danish."));
        vModel.addAttribute("posts", postService.findAll());

        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String postsId(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postService.findOne((int) (id - 1)));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String sendPostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}
