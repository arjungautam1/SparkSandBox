/**
 * @author :arjun
 * Project :SparkCRUD
 * Date : 2020-12-18
 * Time : 12:05
 */
package user.service;

import user.exception.UserException;
import user.model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserServiceMapImpl implements UserService {
    private HashMap<String, User> userHashMap;

    public UserServiceMapImpl() {
        userHashMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userHashMap.put(user.getId(), user);
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
    public User editUser(User forEdit) throws UserException {
        try {
            if (forEdit.getId() == null)
                throw new UserException("ID cannot be blank ");
            User toEdit = userHashMap.get(forEdit.getId());

            if (toEdit == null)
                throw new UserException("User not Found");

            if (forEdit.getEmail() != null) {
                toEdit.setEmail(forEdit.getEmail());
            }
            if (forEdit.getFirstName() != null) {
                toEdit.setFirstName(forEdit.getFirstName());
            }
            if (forEdit.getLastName() != null) {
                toEdit.setLastName(forEdit.getLastName());
            }
            if (forEdit.getId() != null) {
                toEdit.setId(forEdit.getId());
            }
            return toEdit;

        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {
        userHashMap.remove(id);
    }

    @Override
    public boolean userExist(String id) {
        return userHashMap.containsKey(id);
    }
}
