package com.parsakav.pgukala.repository;

import com.parsakav.pgukala.entity.Stuff;

import java.util.List;

public interface StuffRepository {

List<Stuff> getAllStuff();
    int save(Stuff user);
    void remove(int id);

}
