package com.myblog.myblog.service;

import com.myblog.myblog.payload.CommentDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentService {

    CommentDto createComment(@RequestBody CommentDto commentDto, @RequestParam long postId);

    void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);
}
