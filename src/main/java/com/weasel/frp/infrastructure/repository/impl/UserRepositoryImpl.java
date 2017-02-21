package com.weasel.frp.infrastructure.repository.impl;

import com.weasel.frp.domain.Page;
import com.weasel.frp.domain.User;
import com.weasel.frp.infrastructure.repository.MybatisDaoSupport;
import com.weasel.frp.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dylan
 * @date 2017/2/6.
 */
@Repository
public class UserRepositoryImpl extends MybatisDaoSupport implements UserRepository {


    @Override
    public User getUserByName(String name) {
        return getSqlSession().selectOne(namespace().concat(".getUserByName"),name);
    }

    @Override
    public User getUserByEmail(String email) {
        return getSqlSession().selectOne(namespace().concat(".getUserByEmail"),email);
    }

    @Override
    public Page<User> queryPage(Page page) {

        List<User> users = getSqlSession().selectList(namespace().concat(".queryPage"),page);

        page.setResult(users);
        return page;
    }

    @Override
    protected String namespace() {
        return User.class.getName();
    }
}
