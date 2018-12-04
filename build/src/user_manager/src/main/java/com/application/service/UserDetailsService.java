package com.application.service;

import com.application.model.UserDetails;
import java.util.List;

public interface UserDetailsService {
    void create(UserDetails userDetails);

    List<UserDetails> getAllUserDetails();

    UserDetails getUserDetailsById(int id);

    void update(UserDetails userDetails);
}
