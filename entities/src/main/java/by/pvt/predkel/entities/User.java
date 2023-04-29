package by.pvt.predkel.entities;

import by.pvt.predkel.entities.access.AccessLevelType;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 */


public class User extends Entity {
    private static final long serialVersionUID = 1L;

    private AccessLevelType accessLevelType;
    private String login;
    private String password;
    private List<Building> building;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (getAccessLevelType() != user.getAccessLevelType()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getAccessLevelType().hashCode();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }

    public User() {
    }

    public AccessLevelType getAccessLevelType() {
        return accessLevelType;
    }

    public void setAccessLevelType(AccessLevelType accessLevelType) {
        this.accessLevelType = accessLevelType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String value) {
        this.login = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public List<Building> getBuilding() {
        if (building == null) {
            building = new ArrayList<Building>();
        }
        return this.building;
    }

    public void setBuilding(List<Building> building) {
        this.building = building;
    }
}
