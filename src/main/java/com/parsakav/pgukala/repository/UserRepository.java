package com.parsakav.pgukala.repository;

import com.parsakav.pgukala.entity.User;

public interface UserRepository {
    int save(User user);
    boolean exist(String username);
    User find(String username);
    void remove(String username);
}
