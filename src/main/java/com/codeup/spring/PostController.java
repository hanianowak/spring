package com.codeup.spring;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    PostsRepo postsRepo;
    

    private final PostService postService;
    // Dependency injection is happening
    public PostController(PostService postService){
        this.postService = postService;
    }

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
//    @ResponseBody
    public String sendPostForm(Model vModel) {
            vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(Post post) {
        Post savedPost = postService.save(post);
        return "redirect:/posts/" + savedPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showAdUpdateForm(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postService.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String showAdUpdateForm(@ModelAttribute Post post) {
        Post updatedPost = postService.edit(post);
        return "redirect:/posts/" + updatedPost.getId();
    }

    @GetMapping("/posts/search/{term}")
    public String showResults(@PathVariable String term, Model vModel){
        vModel.addAttribute("posts", postService.search(term));
        return "posts/index";
    }


//    @RequestMapping(path = "/posts/{id}/delete", method = RequestMethod.DELETE)
//    public String delete(@PathVariable long id) {
//        postService.delete(id);
//        return "redirect:/posts";
//    }

//    @GetMapping(path = "/posts/{id}/delete")
//    public String delete(@PathVariable long id) {
//        postService.delete(id);
//        return "redirect:/posts";
//    }

//    @RequestMapping(value = "/posts/{id}/delete", method = RequestMethod.DELETE)
//    public @ResponseBody String delete(@PathVariable("id") long id) {
//                postService.delete(id);
//        return "redirect:/posts";
//    }

//    @PostMapping("/posts/{id}/delete")
//    public String delete(@RequestParam("id") long id) {
//        postService.delete(id);
//        return "redirect:/posts";
//    }

    @GetMapping("/posts/{id}/delete")
    public String delete(@ModelAttribute Post post){
        postService.delete(post);
        return "redirect:/posts";
    }
}
