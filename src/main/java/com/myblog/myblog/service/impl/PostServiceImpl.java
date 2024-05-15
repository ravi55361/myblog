package com.myblog.myblog.service.impl;

import com.myblog.myblog.entity.Post;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    PostDto mapToDto(Post post){
        return modelMapper.map(post, PostDto.class);
    }

    Post mapToEntity(PostDto dto){
        return modelMapper.map(dto, Post.class);
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savePost = postRepository.save(post);
        PostDto postDtos = mapToDto(savePost);
        return postDtos;
    }

    @Override
    public PostDto getPostById(long id) {
        Post byId = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post not found with id :"+id));
        PostDto postDto= new PostDto();
        postDto.setId(byId.getId());
        postDto.setTitle(byId.getTitle());
        postDto.setContent(byId.getContent());
        postDto.setDescription(byId.getDescription());
        return postDto;
    }

    @Override
    public List<PostDto> getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Post> pagePost = postRepository.findAll(pageable);
        List<Post> posts = pagePost.getContent();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;
    }


}
