package com.springboot.blog.comment.web;

import com.springboot.blog.comment.dto.request.CommentSaveRequestDto;
import com.springboot.blog.comment.dto.response.CommentPageResponseDto;
import com.springboot.blog.comment.dto.response.CommentResponseDto;
import com.springboot.blog.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/post/{postId}/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long postId,
            @RequestBody CommentSaveRequestDto commentSaveRequestDto
            ) {
        return new ResponseEntity<>(commentService.createComment(postId, commentSaveRequestDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<CommentPageResponseDto> getCommentPages(
            @PathVariable Long postId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(commentService.getCommentPages(postId, pageNo, pageSize));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> getCommentById(
            @PathVariable Long postId,
            @PathVariable Long commentId
    ) {
        return ResponseEntity.ok(commentService.getCommentById(postId, commentId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long postId,
            @PathVariable Long commentId,
            @RequestBody CommentSaveRequestDto commentSaveRequestDto
    ) {
        return ResponseEntity.ok(commentService.updateComment(postId, commentId, commentSaveRequestDto));
    }
}
