package org.adaschool.api.service.user;

import org.adaschool.api.repository.user.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceMap implements UsersService {
    Map<String,User> userMap = new HashMap<>();


    @Override
    public User save(User user) {
        userMap.put(user.getId(),user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> all() {
        return (List<User>) userMap.values();
    }

    @Override
    public void deleteById(String id) {
        userMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        save(user);
        return user;
    }
}
