package dao;

import Beans.Users;

import java.sql.SQLException;

public interface daoUsersImp {
    public Users getById(int IdUser) throws ClassNotFoundException, SQLException;

    public Users saveUser(Users u) throws ClassNotFoundException, SQLException;


}
