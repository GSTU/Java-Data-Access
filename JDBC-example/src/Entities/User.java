package Entities;

/**
 * Created by igor on 12.10.2014.
 */
public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private int id;
    private String userName;
    private String userLogin;
    private String userPassword;

    public User(int id, String userName, String userLogin, String userPassword) {
        this.id = id;
        this.userName = userName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }
}


/*
DROP TABLE users;
CREATE TABLE users (
  id serial NOT NULL,
  userName character varying(100),
  userLogin character varying(255),
  userPassword character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (id)
)

WITH (
  OIDS=FALSE
);

ALTER TABLE users
  OWNER TO postgres;
 */