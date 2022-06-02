package com.samsung.server.service;

import com.samsung.server.dao.EventDao;
import com.samsung.server.domain.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class EventServiceImpl implements EventService{

    private final EventDao eventDao;

    @Transactional
    @Override
    public Event insert(Event e) {
        return eventDao.save(e);
    }

    @Override
    public Event getById(int id) {
        return eventDao.getById(id);
    }

    @Override
    public List<Event> searchByName(String name) {
        List<Event> events = eventDao.findAll();
        List<Event> res = new ArrayList<>();
        for (Event e: events) {
            if (e.getName().contains(name)){
                res.add(e);
            }
        }
        return res;
    }

    @Override
    public List<Event> getAll() {
        return eventDao.findAll();
    }

    @Override
    public List<Event> getByUserId(int id) {
        List<Event> events = eventDao.findAll();
        List<Event> result = new ArrayList<>();
        for (Event e: events){
            if (e.getUsers().getId()==id){
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public List<Event> getByCategories(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f, boolean g, boolean h) {
        List<Event> events = eventDao.findAll();
        List<Boolean> res=new ArrayList<>();
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        res.add(e);
        res.add(f);
        res.add(g);
        res.add(h);
        System.out.println(res.toString());
        boolean cat1, cat2, cat3, cat7, cat4, cat5, cat6, cat8;
        List<Event> result = new ArrayList<>();
        for (Event event: events){
            cat1=event.getIsStreet()==1;
            cat2=event.getIsGroup()==1;
            cat3=event.getIsFamily()==1;
            cat4=event.getIsFree()==1;
            cat5=event.getHasCovid()==1;
            cat6=event.getHasRegister()==1;
            cat7=event.getHasAgeRestrictions()==1;
            cat8=event.getIsSport()==1;
            List<Boolean> cr=new ArrayList<>();
            cr.add(cat1);
            cr.add(cat2);
            cr.add(cat3);
            cr.add(cat4);
            cr.add(cat5);
            cr.add(cat6);
            cr.add(cat7);
            cr.add(cat8);
            boolean r = true;
            for (int i=0; i<8; i++){
                if ((!cr.get(i))&&res.get(i)){
                    r=false;
                    break;
                }
            }
            if (r){
                result.add(event);
            }
        }
        return result;
    }

    @Transactional
    @Override
    public void removeEvent(Event event) {
        eventDao.delete(event);
    }
}
