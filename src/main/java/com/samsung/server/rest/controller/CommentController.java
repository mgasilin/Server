package com.samsung.server.rest.controller;


import com.samsung.server.domain.Comment;
import com.samsung.server.domain.Event;
import com.samsung.server.domain.User;
import com.samsung.server.rest.dto.CommentDto;
import com.samsung.server.service.CommentService;
import com.samsung.server.service.EventService;
import com.samsung.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final EventService eventService;
    private final CommentService commentService;
    private final UserService userService;

    @PostMapping("/events/comment/new")
    public List<CommentDto> createNewComment(
            @RequestParam String content,
            @RequestParam int event_id,
            @RequestParam int author_id
    ) {
        try {
            List<Comment> comments = commentService.findByEvent(eventService.getById(event_id));
            Comment comment = commentService.insert(Comment.builder().content(content).event(eventService.getById(event_id)).author(userService.getById(author_id)).sequence_number(comments.size()+1).build());
            List<Comment> commentList = commentService.findByEvent(comment.getEvent());
            return commentList.stream().map(CommentDto::toDto).collect(Collectors.toList());
        } catch (Exception e){
            return null;
        }
    }

    @GetMapping("/events/{id}/comments")
    public List<CommentDto> getCommentsByBookId(@PathVariable int id) {

        return commentService
                .findByEvent(eventService.getById(id))
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }
}
