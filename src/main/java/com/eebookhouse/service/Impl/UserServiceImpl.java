package com.eebookhouse.service.Impl;

import com.eebookhouse.dao.BookMapper;
import com.eebookhouse.dao.UserMapper;
import com.eebookhouse.entity.Book;
import com.eebookhouse.entity.User;
import com.eebookhouse.service.UserService;
import com.eebookhouse.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import jakarta.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username, password);
            if (user == null) return false;
            session.setAttribute("user", user);
            return true;
        }
    }

    @Override
    public boolean register(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            if (mapper.isExistUser(username) < 1) {
                if (mapper.registerUser(username, password) > 0)
                    return this.auth(username, password, session);
                return false;
            }
            return false;
        }
    }

    @Override
    public User getUserById(Integer id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.getUserById(id);
        }
    }

    @Override
    public boolean updateUser(User user) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int row = mapper.updateUser(user.getId(),
                    user.getUsername(),
                    user.getUserpass(),
                    user.getEmail(),
                    user.getAddress(),
                    user.getPostcode(),
                    user.getLevel(),
                    user.getPower()
            );
            return row > 0;
        }
    }

}
