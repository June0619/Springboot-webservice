package com.buildsomething.zs.springboot.web;

import com.buildsomething.zs.springboot.config.auth.LoginUser;
import com.buildsomething.zs.springboot.config.auth.dto.SessionUser;
import com.buildsomething.zs.springboot.service.posts.PostsService;
import com.buildsomething.zs.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;


@RequiredArgsConstructor
@Controller
public class IndexController
{
    private final PostsService postsService;

    @GetMapping("/")
    public String index(HttpSession session, @LoginUser SessionUser user)
    {
        if (user != null)
            session.setAttribute("userName", user.getName());
        return "index";
    }
    @GetMapping("/posts-list")
    public String postsList(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts-list";
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
