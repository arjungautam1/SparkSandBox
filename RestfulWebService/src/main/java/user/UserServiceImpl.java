package user;

import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;
import java.util.HashMap;

public class UserServiceImpl implements UserService {
    private HashMap<String ,User> userHashMap;


    public UserServiceImpl() {
        userHashMap=new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userHashMap.put(user.getId(),user);
    }

    @Override
    public Collection<User> getUsers() {
        return userHashMap.values();
    }

    @Override
    public User getUser(String id) {
        return userHashMap.get(id);
    }

    @Override
    public User editUser(User user) throws ExecutionControl.UserException {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public boolean userExist(String id) {
        return false;
    }


}
