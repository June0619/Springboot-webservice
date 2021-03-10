package com.buildsomething.zs.springboot.web.dto;

import com.buildsomething.zs.springboot.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsResponseDTO {
    private Long   id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDTO(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
