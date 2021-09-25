package com.javacto.servlet.UserDao;

import com.javacto.servlet.LoginServlet;

import java.util.List;

public interface UserDao {
    public int addPhoneUser(LoginServlet tian)throws Exception; //添加
    public List<LoginServlet> queryPhoneUser(LoginServlet chaxun)throws Exception; //查询
    public LoginServlet checkPhoneUserById(int id)throws Exception; //根据id查询
    public int updatePhoneUser(LoginServlet xiugai)throws Exception; //修改
    public int deletePhoneUser(int id)throws Exception; //删除
}
