package user;


import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;

public interface UserService {
    public void addUser(User user);

    public Collection<User> getUsers();

    public User getUser(String id);

    public User editUser(User user)
        throws ExecutionControl.UserException;

    public void deleteUser(String id);

    public boolean userExist(String id);

}
