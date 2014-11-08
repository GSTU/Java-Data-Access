package DBL;

import Entities.User;

import java.util.List;

/**
 * Created by igor on 12.10.2014.
 */
public class UserService implements Service<User>{

    Context context;

    public UserService(Context<User> context) {
        this.context = context;
    }

    @Override
    public List<User> getAll() {
        return  context.getAll();
    }

    @Override
    public User get(int id) {
       return (User) context.get(id);
    }

    @Override
    public void create(User entity) {
        context.create(entity);
    }

    @Override
    public void remove(User entity) {
        context.remove(entity);
    }

    @Override
    public void update(User entity) {
        context.update(entity);
    }
}
