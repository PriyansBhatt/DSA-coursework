/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Player;
import java.util.ArrayList;

/**
 *
 * @author Priyans
 */
public class PlayerController {

    private ArrayList<Player> playerList = new ArrayList<>();

    public void addPlayer(Player p) {
        playerList.add(p);
    }

    public ArrayList<Player> getAllPlayers() {
        return playerList;
    }

    public void deletePlayer(int index) {
        if (index >= 0 && index < playerList.size()) {
            playerList.remove(index);
        }
    }

    public Player linearSearch(String key) {
        for (Player p : playerList) {
            if (p.getId().equalsIgnoreCase(key)) {
                return p;
            }
        }
        return null;
    }

    public void sortById() {
        playerList.sort((p1, p2) -> p1.getId().compareToIgnoreCase(p2.getId()));
    }

    public Player binarySearch(String key) {
        sortById();
        int low = 0, high = playerList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Player p = playerList.get(mid);
            int cmp = p.getId().compareToIgnoreCase(key);

            if (cmp == 0) {
                return p;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public void updatePlayer(int index, Player p) {
        if (index >= 0 && index < playerList.size()) {
            playerList.set(index, p);
        }
    }
}
