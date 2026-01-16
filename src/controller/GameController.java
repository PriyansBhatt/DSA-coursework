/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Game;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Priyans
 */
public class GameController {
    // Stores all active games in the system
    private ArrayList<Game> gameList = new ArrayList<>();
    // Stack used to store deleted games for undo functionality
    private Stack<Game> deletedGames = new Stack<>();

    // CONSTRUCTOR → loads dummy data automatically
    public GameController() {
    }

    // DUMMY DATA (COURSEWORK)
    public void loadDummyGames() {
        try {
            gameList.add(new Game("G01", "Poker", 1000, 5000, "John"));
            gameList.add(new Game("G02", "Blackjack", 500, 3000, "Alex"));
            gameList.add(new Game("G03", "Roulette", 2000, 8000, "Emma"));
        } catch (Exception e) {
            System.out.println("Dummy Games Load Error");
        }
    }

    // CREATE
    public boolean addGame(Game g) {
        try {
            for (Game existing : gameList) {
                if (existing.getId().equalsIgnoreCase(g.getId())) {
                    return false; // duplicate
                }
            }

            gameList.add(g);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // READ
    public ArrayList<Game> getAllGames() {
        return gameList;
    }

    // UPDATE
    public boolean deleteGameById(String id) {
        try {
            for (int i = 0; i < gameList.size(); i++) {
                if (gameList.get(i).getId().equalsIgnoreCase(id)) {
                    deletedGames.push(gameList.remove(i)); // stack for undo
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Delete Game Error");
        }
        return false;
    }

    public boolean updateGameById(Game updated) {
    try {
        if (updated == null || updated.getId() == null) {
            return false;
        }

        String updatedId = updated.getId().trim();

        for (int i = 0; i < gameList.size(); i++) {
            Game existing = gameList.get(i);

            if (existing.getId() != null &&
                existing.getId().trim().equalsIgnoreCase(updatedId)) {

                // Update fields (better than replacing object)
                existing.setName(updated.getName());
                existing.setMinBet(updated.getMinBet());
                existing.setMaxBet(updated.getMaxBet());
                existing.setPlayerName(updated.getPlayerName());

                return true;
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); // IMPORTANT: don't hide errors
    }
    return false;
}

    // UNDO DELETE (STACK POP)
    public boolean undoDelete() {
        try {
            if (deletedGames.isEmpty()) {
                return false;
            }

            Game g = deletedGames.pop();
            gameList.add(g);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
// SORT games by ID (simple bubble sort – coursework friendly)

    public void sortGamesById() {
        for (int i = 0; i < gameList.size() - 1; i++) {
            for (int j = 0; j < gameList.size() - i - 1; j++) {
                if (gameList.get(j).getId()
                        .compareToIgnoreCase(gameList.get(j + 1).getId()) > 0) {

                    Game temp = gameList.get(j);
                    gameList.set(j, gameList.get(j + 1));
                    gameList.set(j + 1, temp);
                }
            }
        }
    }

    public Game binarySearchGameById(String id) {
        try {
            sortGamesById(); // MUST sort first

            int low = 0;
            int high = gameList.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                Game g = gameList.get(mid);

                int cmp = g.getId().compareToIgnoreCase(id);

                if (cmp == 0) {
                    return g;
                } else if (cmp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return null;

        } catch (Exception e) {
            return null;
        }
    }

}
