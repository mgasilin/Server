package com.samsung.server.service;

import com.samsung.server.domain.Event;

import java.util.List;

public interface EventService {
    Event insert(Event e);

    Event getById(int id);

    List<Event> searchByName(String name);

    List<Event> getAll();

    List<Event> getByUserId(int id);

    List<Event> getByCategories(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f, boolean g, boolean h);

    void removeEvent(Event event);

}
