package DBL;

import Entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 12.10.2014.
 */
public class MMContext implements Context<User>{
    public List<User> users = new ArrayList<User>();

    public MMContext() {
        users.add(new User(1,"igor","is","34234"));
        users.add(new User(2,"sdf","isFd","111"));
        users.add(new User(3,"isdfr","isFDs","6545"));
        users.add(new User(4,"iert","isE","3423"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public void create(User entity) {
        users.add(entity);
    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public void update(User entity) {

    }
}
