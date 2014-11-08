package DBL;

import Entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 12.10.2014.
 */
public class DBContext implements Context<User> {

    private final String connectionString;
    private final String userLogin;
    private final String userPass;

    public DBContext(String connectionString, String userLogin, String userPass) {
        this.connectionString = connectionString;
        this.userLogin = userLogin;
        this.userPass = userPass;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver").newInstance();

            try (Connection conn = DriverManager.getConnection(
                    connectionString, userLogin, userPass);

                 Statement st = conn.createStatement()) {
                //st.execute("create table IF NOT EXISTS notes(id int auto_increment, user varchar(100),text varchar(255) )");

                ResultSet res;
                res = st.executeQuery("SELECT * FROM users;");
                while (res.next()) {
                    int id = res.getInt("id");
                    String userName = res.getString("userName");
                    String userLogin = res.getString("userLogin");
                    String userPassword = res.getString("userPassword");
                    users.add(new User(id, userName, userLogin, userPassword));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        return users;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public void create(User entity) {
        try {
            Class.forName("org.postgresql.Driver").newInstance();

            String inQ = String.format("insert into users(userName, userLogin, userPassword) values (?, ?, ?)", entity.getUserName(), entity.getUserLogin(),entity.getUserPassword() );

            try (Connection conn = DriverManager.getConnection(connectionString, userLogin, userPass);
                 PreparedStatement st = conn.prepareStatement(inQ, Statement.RETURN_GENERATED_KEYS)) {

                //TODO предусмотреть ситуацию когда нету таблицы
                //st.execute("create table IF NOT EXISTS notes(id int auto_increment, user varchar(100),note varchar(255) )");

                st.setString(1, entity.getUserName());
                st.setString(2, entity.getUserLogin());
                st.setString(3, entity.getUserPassword());

                //TODO оптимизировать catch
                int affectedRows = st.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }

                // Поскольку id генерируется автоматически
                // этот код козволяет узнать этот id
                // в данном случае это не используется
                // но может потребоваться в реальных задачах
                ResultSet generatedKeys;
                generatedKeys = st.getGeneratedKeys();
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no generated key obtained.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        //return note;
    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public void update(User entity) {

    }
}
