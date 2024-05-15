package com.myblog.myblog.service;

import com.myblog.myblog.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    public  PostDto getPostById(long id);
    public List<PostDto> getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir);
}
