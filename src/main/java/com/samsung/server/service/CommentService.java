package com.samsung.server.service;

import com.samsung.server.domain.Comment;
import com.samsung.server.domain.Event;

import java.util.List;

public interface CommentService {
    List<Comment> findByEvent(Event event);

    Comment insert(Comment comment);


}
