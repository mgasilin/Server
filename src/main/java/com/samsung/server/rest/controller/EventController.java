package com.samsung.server.rest.controller;

import com.samsung.server.dao.CommentDao;
import com.samsung.server.dao.EventDao;
import com.samsung.server.domain.Comment;
import com.samsung.server.domain.Event;
import com.samsung.server.rest.dto.EventDto;
import com.samsung.server.service.CommentService;
import com.samsung.server.service.EventService;
import com.samsung.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class EventController {
    private final UserService userService;
    private final CommentService commentService;
    private final EventService eventService;
    /*
    add
    remove
    */
    @GetMapping("/events")
    public List<EventDto> getAll(){
        return eventService.getAll().stream().map(EventDto::toDto).collect(Collectors.toList());
    }

    @GetMapping("/events/{id}")
    public EventDto getById(@PathVariable int id){
        try{
        return EventDto.toDto(eventService.getById(id));
        }catch (Exception e){
            return null;
        }
    }
    @GetMapping("/events/categories")
    public List<EventDto> events(@RequestParam boolean street, @RequestParam boolean group, @RequestParam boolean sport,
                              @RequestParam boolean fam, @RequestParam boolean free, @RequestParam boolean covid,
                              @RequestParam boolean reg, @RequestParam boolean age){
        List<Event> events = eventService.getByCategories(street,group,fam,free,covid,reg,age,sport);
        return events.stream().map(EventDto::toDto).collect(Collectors.toList());
    }


    @GetMapping("/events/name")
    public List<EventDto> getByName(@RequestParam String name){
        return eventService.searchByName(name).stream().map(EventDto::toDto).collect(Collectors.toList());
    }

    @GetMapping("/events/user")
    public List<EventDto> getByUserId(@RequestParam int id){
        System.out.println(id);
        return eventService.getByUserId(id).stream().map(EventDto::toDto).collect(Collectors.toList());
    }
    @GetMapping("/events/length")
    public List<EventDto> getByLength(){
       return eventService.getAll().stream().map(EventDto::toDto).collect(Collectors.toList());
    }

    @DeleteMapping("/events/delete")
    public void deleteById(@RequestParam int id){
        eventService.removeEvent(eventService.getById(id));
    }

    @PostMapping ("/events/add")
    public EventDto add (@RequestParam String name , @RequestParam String description, @RequestParam String date, @RequestParam int owner ,@RequestParam String place, @RequestParam double x , @RequestParam double y, @RequestParam int street, @RequestParam int group, @RequestParam int fam, @RequestParam int free, @RequestParam int covid, @RequestParam int register, @RequestParam int ageRes, @RequestParam int sport){
        return EventDto.toDto(eventService.insert(Event.builder()
                        .date(date).coordX(x).coordY(y).description(description).hasAgeRestrictions(ageRes)
                        .hasCovid(covid).isFamily(fam).isFree(free).isGroup(group).isSport(sport).users(userService.getById(owner))
                        .isStreet(street).name(name).place(place).hasRegister(register).build()));
    }
}
