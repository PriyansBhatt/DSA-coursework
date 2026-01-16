/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * 
 */
public class LoginController {
    private final String adminUsername = "admin";
    private final String adminPassword = "admin";

    public boolean loginAsAdmin(String username, String password) {

        if (username == null || password == null) {
            return false;
        }

        return username.equals(adminUsername)
                && password.equals(adminPassword);
    }
}

