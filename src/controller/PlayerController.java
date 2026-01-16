/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Player;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Priyans
 */
public class PlayerController {

    private ArrayList<Player> playerList = new ArrayList<>();
    private Queue<Player> recentPlayers = new LinkedList<>();

    public void loadDummyPlayers() {
        try {
            addPlayer(new Player("P005", "John Doe", 25, 5000, "Active"));
            addPlayer(new Player("P002", "Alex Smith", 30, 3000, "Active"));
            addPlayer(new Player("P004", "Robert Brown", 22, 1500, "Disabled"));
            addPlayer(new Player("P003", "Chris Evans", 28, 8000, "Active"));
            addPlayer(new Player("P001", "David Miller", 35, 12000, "Disabled"));
        } catch (Exception e) {
            System.out.println("Error loading dummy players");
        }
    }

    // ADD PLAYER
    public boolean addPlayer(Player p) {
        try {
            // Check duplicate ID
            for (Player existing : playerList) {
                if (existing.getId().equalsIgnoreCase(p.getId())) {
                    return false; // duplicate found
                }
            }

            playerList.add(p);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Player> getAllPlayers() {
        return playerList;
    }

    public Queue<Player> getRecentPlayers() {
        return recentPlayers;
    }

    // ===================== UPDATE (BY ID) =====================
    public boolean updatePlayerById(Player updated) {
        try {
            for (int i = 0; i < playerList.size(); i++) {
                if (playerList.get(i).getId().equals(updated.getId())) {
                    playerList.set(i, updated);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Update Player Error");
        }
        return false;
    }

    // ===================== DELETE (BY ID) =====================
    public boolean deletePlayerById(String id) {
        try {
            for (int i = 0; i < playerList.size(); i++) {
                if (playerList.get(i).getId().equals(id)) {
                    playerList.remove(i);
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Delete Player Error");
        }
        return false;
    }

    // ===================== SEARCH =====================
    public Player searchPlayerById(String id) {
        try {
            for (Player p : playerList) {
                if (p.getId().equalsIgnoreCase(id)) {
                    return p;
                }
            }
        } catch (Exception e) {
            System.out.println("Search Player Error");
        }
        return null;
    }

    // ===================== SORT (BUBBLE SORT) =====================
    public void sortPlayersById() {
        try {
            for (int i = 0; i < playerList.size() - 1; i++) {
                for (int j = 0; j < playerList.size() - i - 1; j++) {
                    if (playerList.get(j).getId()
                            .compareTo(playerList.get(j + 1).getId()) > 0) {

                        Player temp = playerList.get(j);
                        playerList.set(j, playerList.get(j + 1));
                        playerList.set(j + 1, temp);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Sort Player Error");
        }
    }
}
