package spring.java.webapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import spring.java.webapp.service.posts.PostsService;
import spring.java.webapp.web.dto.PostsResponseDto;
import spring.java.webapp.web.dto.PostsUpdateRequestDto;

import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class IndexController {
    
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate (@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        
        return "posts-update";
    }
    
}
