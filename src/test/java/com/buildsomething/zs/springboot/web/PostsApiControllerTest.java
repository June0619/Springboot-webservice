package com.buildsomething.zs.springboot.web;

import com.buildsomething.zs.springboot.domain.posts.Posts;
import com.buildsomething.zs.springboot.domain.posts.PostsRepository;
import com.buildsomething.zs.springboot.web.dto.PostsSaveRequestDTO;
import com.buildsomething.zs.springboot.web.dto.PostsUpdateRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup()
    {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }



    @After
    public void tearDown() throws Exception
    {
        postsRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="GUEST")
    public void Posts_insert() throws Exception
    {
        //given
        String title = "title";
        String content = "content";
        PostsSaveRequestDTO requestDto = PostsSaveRequestDTO.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();
        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        mvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(new ObjectMapper().writeValueAsString(requestDto)))
        .andExpect(status().isOk());

        //then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    @WithMockUser(roles="GUEST")
    public void Posts_Modify() throws Exception
    {
        //given
        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId = savedPosts.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        PostsUpdateRequestDTO requestDto = PostsUpdateRequestDTO.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDTO> requestEntity = new HttpEntity<>(requestDto);

        //when
        mvc.perform(put(url)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).
                isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).
                isEqualTo(expectedContent);
    }

//    @Test
//    @WithMockUser(roles="USER")
//    public void Posts_View() throws  Exception {
//        //given
//        Posts savePosts = postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
//                .author("author")
//                .build());
//
//        String url = "http://localhost:" + port + "/api/v1/posts/" + savePosts.getId();
//
//        HttpEntity<String> requestEntity = new HttpEntity<>("");
//
//        //when
//        mvc.perform(put(url)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(new ObjectMapper().writeValueAsString(savePosts)))
//                .andExpect(status().isOk());
//        //then
//        List<Posts> all = postsRepository.findAll();
//    }
//
//    @Test
//    @WithMockUser(roles="USER")
//    public void Posts_Delete() throws Exception
//    {
//        //given
//        Posts posts = postsRepository.save(Posts.builder()
//                .title("title")
//                .content("content")
//                .author("author")
//                .build());
//
//        String url = "http://localhost:" + port + "/api/v1/posts" + posts.getId();
//
//        HttpEntity<String> deleteEntity = new HttpEntity<>("");
//
//        //when
//        ResponseEntity<PostsResponseDTO> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE,
//                deleteEntity, PostsResponseDTO.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//    }
}
