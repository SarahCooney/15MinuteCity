package com.mainCity.Objects;

import java.util.ArrayList;

public class User
{
    public String userName;

    public String passWord;

    public String email;

    public int Id;

    public String gender;

    public ArrayList<Integer> friends = new ArrayList<Integer>();

    public User(int id, String un,String pw, String em, String gd,String pu)
    {
        Id = id;
        userName = un;
        passWord = pw;
        email = em;
        gender = gd;
    }
    public int getUerID()
    {
        return Id;
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
