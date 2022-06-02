package com.samsung.server.service;

import com.samsung.server.dao.CommentDao;
import com.samsung.server.domain.Comment;
import com.samsung.server.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @Override
    public List<Comment> findByEvent(Event event) {
        return commentDao.findByEventId(event.getId());
    }

    @Transactional
    @Override
    public Comment insert(Comment comment) {
        return commentDao.save(comment);
    }
}
