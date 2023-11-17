package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.dataAccess.UserDao;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class UserManager implements UserService {

    @Autowired
    private UserDao _userDao;

    public UserManager(UserDao _userDao) {
        this._userDao = _userDao;
    }

    public void add(User user) {
        _userDao.save(user);
    }

    public void update(User user) {
        _userDao.saveAndFlush(user);
    }

    public void delete(User user) {
            _userDao.delete(user);
    }

    @Override
    public List<User> getAll() {
        return _userDao.findAll();
    }


}
