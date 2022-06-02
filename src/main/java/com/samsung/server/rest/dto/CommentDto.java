package com.samsung.server.rest.dto;

import com.samsung.server.domain.Comment;
import com.samsung.server.domain.Event;
import com.samsung.server.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private int id;

    private String content;

    private UserDto user;

    private int sequence_number;

    private int event_id;

    public static CommentDto toDto(Comment comment) {

        return new CommentDto(comment.getId(), comment.getContent(), UserDto.toDto(comment.getAuthor()),comment.getSequence_number(), comment.getEvent().getId());
    }

}

