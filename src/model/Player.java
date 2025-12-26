/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;





/**
 *
 * @author Priyans
 */
public class Player implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int age;
    private double chips;
    private String status;
    private String contact;

    public Player(String id, String name, int age, double chips, String status, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.chips = chips;
        this.status = status;
        this.contact = contact;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getChips() { return chips; }
    public void setChips(double chips) { this.chips = chips; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}

    
