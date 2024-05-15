package com.myblog.myblog.controller;

import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto>  createComment(@RequestBody CommentDto commentDto, @RequestParam long postId){
        CommentDto dto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted sucessfully!!!", HttpStatus.OK);
    }

    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> uppdateComment(@PathVariable long id,@RequestBody CommentDto commentDto,@PathVariable long postId){
        CommentDto dto =commentService.updateComment(id,commentDto,postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }
}
