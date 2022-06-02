package com.samsung.server.dao;

import com.samsung.server.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    Comment findById(int id);

    List<Comment> findByEventId(int id);

}

