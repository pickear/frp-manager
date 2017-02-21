package com.weasel.frp.service;

import com.weasel.frp.domain.Page;
import com.weasel.frp.domain.User;
import com.weasel.frp.infrastructure.exception.UserExistException;

/**
 * @author Dylan
 * @date 2017/2/6.
 */
public interface UserService {

    /**
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     *
     * @param user
     * @return
     * @throws UserExistException
     */
    boolean notExist(User user)throws UserExistException;

    /**
     *
     * @param page
     * @return
     */
    Page<User> queryPage(Page<User> page);
}
