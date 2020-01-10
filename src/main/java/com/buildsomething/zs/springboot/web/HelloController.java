package com.buildsomething.zs.springboot.web;

import com.buildsomething.zs.springboot.web.dto.HelloResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// JSON을 반환하는 컨트롤러 생성
public class HelloController
{

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDTO hellodto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount)
    {
        return new HelloResponseDTO(name, amount);
    }

}