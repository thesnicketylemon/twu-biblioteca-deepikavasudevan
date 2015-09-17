/*A User has a library number, role and password with which it authenticates itself*/
package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    private ROLE role;

    public User(String libraryNumber, String password, ROLE role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object that) {
        if (that != null && that.getClass() == this.getClass()) {
            User thatUser = (User) that;
            if (this == thatUser || (this.libraryNumber.equals(thatUser.libraryNumber) && this.password.equals(thatUser.password)))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (this != null) {
            for (int i = 0; i < libraryNumber.length(); i++) {
                hash = Character.getNumericValue(libraryNumber.charAt(i)) + (hash << 6) + (hash << 16) - hash;
            }
        }
        return hash;
    }

    public ROLE getUserRole() {
        return role;
    }
}