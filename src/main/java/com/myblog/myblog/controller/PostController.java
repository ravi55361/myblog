package com.myblog.myblog.controller;

import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto postDto = postService.getPostById(id);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    //http://localhost:8080/api/posts?pageNumber=0&pageSize=3&sortBy=title
    @GetMapping
    public List<PostDto> getAllPosts(@RequestParam(name = "pageNumber",required = false, defaultValue = "0") int pageNumber,
                                     @RequestParam(name = "pageSize",required = false, defaultValue ="3") int pageSize,
                                     @RequestParam(name = "sortBy",required = false, defaultValue ="id") String sortBy,
                                     @RequestParam(name = "sortDir",required = false, defaultValue ="id") String sortDir){
        List<PostDto> postDtos = postService.getAllPosts(pageNumber,pageSize,sortBy,sortDir);
        return  postDtos;
    }


}
