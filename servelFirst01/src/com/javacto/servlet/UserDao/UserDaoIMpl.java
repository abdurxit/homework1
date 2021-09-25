package com.javacto.servlet.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoIMpl {
    /*BaseDao2 baseDao2=new BaseDao2();
    public int addPhoneUser(Phone tian)throws Exception{
        int i=0;
        Connection connection=baseDao2.getConnection();
        PreparedStatement pst=connection.prepareStatement("insert into Phone (tId,tName,tPassword,tAddress) values (?,?,?,?)");
        pst.setObject(1,tian.gettId());
        pst.setObject(2,tian.gettName());
        pst.setObject(3,tian.gettPassword());
        pst.setObject(4,tian.gettAddress());
        i=pst.executeUpdate();
        System.out.println("添加成功");
        baseDao2.closeAll(connection,pst,null);
        return i;
    } //添加
    public List<Phone> queryPhoneUser(Phone chaxun)throws Exception{
        List<Phone> list=new ArrayList<Phone>();
        Connection connection=baseDao2.getConnection();
        PreparedStatement pst=connection.prepareStatement("select * from Phone");
        ResultSet rs=pst.executeQuery();
        while (rs.next()){
            Phone phone=new Phone();
            phone.settId(rs.getInt(1));
            phone.settName(rs.getString(2));
            phone.settPassword(rs.getString(3));
            phone.settAddress(rs.getString(4));
            list.add(phone);
        }
        System.out.println("查询成功");
        baseDao2.closeAll(connection,pst,rs);
        return list;
    } //查询
    public Phone checkPhoneUserById(int id)throws Exception{
        Phone phone=new Phone();
        Connection connection=baseDao2.getConnection();
        PreparedStatement pst=connection.prepareStatement("select * from Phone where tId=?");
        pst.setObject(1,id);
        ResultSet rs=pst.executeQuery();
        while (rs.next()){
            phone=new Phone();
            phone.settId(rs.getInt(1));
            phone.settName(rs.getString(2));
            phone.settPassword(rs.getString(3));
            phone.settAddress(rs.getString(4));

        }
        System.out.println("查询成功");
        baseDao2.closeAll(connection,pst,rs);
        return phone;
    } //根据id查询
    public int updatePhoneUser(Phone xiugai)throws Exception{
        int i=0;
        Connection connection= baseDao2.getConnection();
        PreparedStatement pst=connection.prepareStatement("update Phone set tName=? where tId=?");
        pst.setObject(1,xiugai.gettName());
        pst.setObject(2,xiugai.gettId());
        i=pst.executeUpdate();
        System.out.println("修改成功");
        baseDao2.closeAll(connection,pst,null);
        return i;
    } //修改
    public int deletePhoneUser(int id)throws Exception{
        int i=0;
        Connection connection=baseDao2.getConnection();
        PreparedStatement pst=connection.prepareStatement("delete from Phone where tId=?");
        pst.setObject(1,id);
        i=pst.executeUpdate();
        System.out.println("删除成功");
        baseDao2.closeAll(connection,pst,null);
        return i;
    } //删除*/
}
