package com.application.dao.impl;

import com.application.dao.UserDetailsDao;
import com.application.model.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(UserDetails userDetails) {
        entityManager.persist(userDetails);
    }

    @Override
    public void update(UserDetails userDetails) {
        entityManager.merge(userDetails);
    }

    @Override
    public UserDetails getUserDetailsById(int id) {
        return entityManager.find(UserDetails.class, id);
    }

    @Override
    public List<UserDetails> getAllUserDetails(){
        return entityManager.createQuery("Select user_details from " + UserDetails.class.getSimpleName() + " user_details").getResultList();
    }

    @Override
    public void delete(int id) {
        UserDetails userDetails = getUserDetailsById(id);
        if (userDetails != null) {
            entityManager.remove(userDetails);
        }
    }


}
