package hibernate;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 12:59:43 PM
 */
public class User {
    private int userId;
    private String userName;
    private String userPassword;

    /**
     * Gets the password of the user
     * @return the password of the user
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the password of the user
     * @param userPassword the password of the user
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Gets the name of the user
     * @return the name of the user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the name of the user
     * @param userName the name of the user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the id of the user
     * @return the id of the user
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the id of the user
     * @param userId the id of the user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;

        return true;
    }
}
