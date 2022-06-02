package com.samsung.server.rest.dto;

import com.samsung.server.domain.Comment;
import com.samsung.server.domain.Event;
import com.samsung.server.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EventDto {
    private String date;
    private long id;
    private UserDto author;
    private String name;
    private String description;
    private String place;
    private double coordX;
    private double coordY;
    private int isStreet;
    private int isGroup;
    private int isFamily;
    private int isFree;
    private int hasCovid;
    private int hasRegister;
    private int isSport;
    private int hasAgeRestrictions;
    private List<CommentDto> comments;

    public static EventDto toDto(Event event) {
        return new EventDtoBuilder()
                .coordX(event.getCoordX())
                .coordY(event.getCoordY())
                .date(event.getDate())
                .description(event.getDescription())
                .name(event.getName())
                .isFamily(event.getIsFamily())
                .hasCovid(event.getHasCovid())
                .id(event.getId())
                .author(UserDto.toDto(User.builder().id(event.getUsers().getId()).name(event.getUsers().getName()).build()))
                .place(event.getPlace())
                .isStreet(event.getIsStreet())
                .isGroup(event.getIsGroup())
                .isFree(event.getIsFree())
                .hasRegister(event.getHasRegister())
                .isSport(event.getIsSport())
                .hasAgeRestrictions(event.getHasAgeRestrictions())
                .build();
    }
}
