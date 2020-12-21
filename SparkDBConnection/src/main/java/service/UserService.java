/**
 * @author :arjun
 * Project :SparkDBConnection
 * Date : 2020-12-21
 * Time : 12:16
 */
package service;

import database.UserDatabase;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserDatabase userDatabase = new UserDatabase();

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        String query = "select * from users";
        ResultSet resultSet = userDatabase.executeQuery(query);

        /*Get all users */
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setLastName(resultSet.getString("lastname"));
                    user.setAge(resultSet.getInt("age"));
                    userList.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    /*Get user By ID*/
    public User getUserByID(int id) {
        User user = new User();
        String query = "SELECT * from users where id=" + id;
        ResultSet resultSet = userDatabase.executeQuery(query);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setLastName(resultSet.getString("lastname"));
                    user.setAge(resultSet.getInt("age"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    /*Add User*/
    public boolean addUser(User user) {
        boolean result = false;
        String query = "insert into users(id,firstname,lastname,age)values(" + user.getId() + ",'" + user.getFirstName() + "','" + user.getLastName() + "'," + user.getAge() + ")";
        result = userDatabase.executeUpdate(query);
        return result;
    }


}
