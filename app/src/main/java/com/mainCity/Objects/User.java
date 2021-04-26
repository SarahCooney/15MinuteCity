package com.mainCity.Objects;

import java.util.ArrayList;

/**
 *  This is the User Object that stores many information about this user such as username, password, etc.
 *  It needs to keep update when new features are added.
 *
 *
 */
public class User
{
    public String userName;

    public String passWord;

    public String email;

    public int Id;

    public String gender;

    public String address;

    public ArrayList<Integer> friends = new ArrayList<Integer>();

    /**
     * Constructor of User
     * @param id
     * @param un
     * @param pw
     * @param em
     * @param gd
     * @param add
     */
    public User(int id, String un,String pw, String em, String gd,String add)
    {
        Id = id;
        userName = un;
        passWord = pw;
        email = em;
        gender = gd;
        address = add;
    }
    public int getUerID()
    {
        return Id;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        this.address = address;
        return true;
    }

    public String getUsername()
    {
        return userName;
    }

    public String getPassword()
    {
        return passWord;
    }

    public String getEmail()
    {
        return email;
    }

    public String gender()
    {
        return gender;
    }

    public boolean setUsername(String un)
    {
        userName = un;
        return true;
    }

    public boolean setPassword(String pw)
    {
        passWord = pw;
        return true;
    }

    public boolean setEmail(String em)
    {
        email = em;
        return true;
    }

    public boolean setUerID(int id)
    {
        Id = id;
        return true;
    }

    public void setGender(String gd)
    {
        gender = gd;
    }
}
