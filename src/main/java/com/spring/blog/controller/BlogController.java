package com.spring.blog.controller;

import com.spring.blog.model.Commentary;
import com.spring.blog.model.Post;
import com.spring.blog.service.BlogService;
import com.spring.blog.service.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    private CommentaryService commentaryService;
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/posts", method=RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = blogService.findAllPost();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = blogService.findPostById(id);
        mv.addObject("post", post);
        return mv;
    }
    @RequestMapping(value="/posts/{id}", method=RequestMethod.POST)
    public String saveCommentary(@PathVariable("id") long id, @Valid Commentary commentary, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        commentary.setData(LocalDate.now());
       commentaryService.saveCommentary(id,commentary);

      return "redirect:/: {id}";
    }
    @RequestMapping(value="/newpost", method=RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        blogService.savePost(post);
        return "redirect:/posts";
    }
}
