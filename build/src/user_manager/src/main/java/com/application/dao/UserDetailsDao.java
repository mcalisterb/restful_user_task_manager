package com.application.dao;

import com.application.model.UserDetails;
import java.util.List;

public interface UserDetailsDao {
    void create(UserDetails userDetails);

    void update(UserDetails userDetails);

    UserDetails getUserDetailsById(int id);

    List<UserDetails> getAllUserDetails();

    void delete(int id);
}
