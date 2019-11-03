package com.ts.user.service.impl.v1;

import com.ts.user.entity.User;
import com.ts.user.service.v1.UserService;
import com.ts.user.repository.v1.UserRepository;
import com.ts.user.shared.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        Iterable<User> it = userRepository.findAll();
        List<User> users = new ArrayList<>();
        it.forEach(e -> users.add(e));
        return users;
    }

    @Override
    public Optional<User> getById() {
      return  userRepository.findById(1L);
    }

    @Override
    public Optional<User> getByLoginId(String loginId) {
        User user = userRepository.getByLoginId(loginId);
        return Optional.ofNullable(user);
    }

    @Override
    public User create(User user){
        String passwordSalt = PasswordUtil.getRandomSalt(16);
        user.setPasswordSalt(passwordSalt);
        String password = PasswordUtil.computeHash(user.getPassword(),passwordSalt);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
