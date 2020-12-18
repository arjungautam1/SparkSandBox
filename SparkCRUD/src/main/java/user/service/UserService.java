/**
 * @author :arjun
 * Project :SparkCRUD
 * Date : 2020-12-18
 * Time : 11:24
 */
package user.service;


import user.exception.UserException;
import user.model.User;

import java.util.Collection;

public interface UserService {
    public void addUser(User user);

    public Collection<User> getUsers();

    public User getUser(String id);

    public User editUser(User user)
            throws UserException;

    public void deleteUser(String id);

    public boolean userExist(String id);


}
