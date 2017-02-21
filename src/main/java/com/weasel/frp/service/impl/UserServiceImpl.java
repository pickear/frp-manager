package com.weasel.frp.service.impl;

import com.weasel.frp.domain.Page;
import com.weasel.frp.domain.User;
import com.weasel.frp.infrastructure.exception.UserExistException;
import com.weasel.frp.infrastructure.repository.UserRepository;
import com.weasel.frp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Dylan
 * @date 2017/2/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public boolean notExist(User user) throws UserExistException {

        User u = repository.getUserByName(user.getName());
        if(null != u){
            throw new UserExistException("用户["+user.getName()+"]已存在");
        }

        u = repository.getUserByEmail(user.getEmail());

        if(null != u){
            throw new UserExistException("邮箱["+user.getEmail()+"]已存在");
        }

        return true;
    }

    @Override
    public Page<User> queryPage(Page<User> page) {
        return repository.queryPage(page);
    }
}
