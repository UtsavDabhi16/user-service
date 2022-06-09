package com.user.Service;

import com.user.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
   List<User> list=List.of(new User(1,"utsav","1234567890"),new User(2,"jay","1231231230"),new User(3,"ritish","4564564560"));

    @Override
    public User getUser(Long id)
    {
        return list.stream().filter(user -> user.getUserId()==(id)).findAny().orElse(null);
    }
}
