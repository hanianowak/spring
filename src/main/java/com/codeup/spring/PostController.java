package com.codeup.spring;

import com.codeup.spring.models.Post;
import com.codeup.spring.models.User;
import com.codeup.spring.repositories.PostsRepo;
import com.codeup.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    PostsRepo postsRepo;

    @Autowired
    UserRepository userRepository;
    

    private final PostService postService;
    // Dependency injection is happening
    public PostController(PostService postService, UserRepository userRepository){
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String postsIndex(Model vModel) {
        vModel.addAttribute("posts", postService.findAll());

        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String postsId(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
//    @ResponseBody
    public String sendPostForm(Model vModel) {
            vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(Post post) {
//        post.setUser(userRepository.findOne(1L));
        User logUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(userRepository.findOne(logUser.getId()));
        Post savedPost = postService.save(post);
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showPostUpdateForm(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updateForm(@ModelAttribute Post post) {
//        post.setUser(userRepository.findOne(1L));
        Post updatedPost = postService.edit(post);
        return "redirect:/posts/" + updatedPost.getId();
    }

    @GetMapping("/posts/search/{term}")
    public String showResults(@PathVariable String term, Model vModel){
        vModel.addAttribute("posts", postService.search(term));
        return "posts/index";
    }
    
    @GetMapping("/posts/{id}/delete")
    public String delete(@ModelAttribute Post post){
        postService.delete(post);
        return "redirect:/posts";
    }
}
