package com.application.service.impl;

import com.application.dao.UserDetailsDao;
import com.application.model.UserDetails;
import com.application.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public void create(UserDetails userDetails) {
        userDetailsDao.create(userDetails);
    }

    @Override
    public List<UserDetails> getAllUserDetails(){
        return userDetailsDao.getAllUserDetails();
    }

    @Override
    public UserDetails getUserDetailsById(int id){
        return userDetailsDao.getUserDetailsById(id);
    }

    @Override
    public void update(UserDetails userDetails) {
        userDetailsDao.update(userDetails);
    }
}
