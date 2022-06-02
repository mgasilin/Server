package com.samsung.server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private int id;

    @Column (name = "sequence_number")
    private int sequence_number;

    @ManyToOne (targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "author_id")
    private User author;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Аналогично с полями книги
    @JoinColumn(name = "event_id")
    private Event event;
}