/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Game;
import java.util.ArrayList;
/**
 *
 * @author Priyans
 */
public class GameController {

    private ArrayList<Game> gameList = new ArrayList<>();

    public void addGame(Game g) {
        gameList.add(g);
    }

    public ArrayList<Game> getAllGames() {
        return gameList;
    }

    public void deleteGame(int index) {
        if (index >= 0 && index < gameList.size()) {
            gameList.remove(index);
        }
    }

    public void updateGame(int index, Game g) {
        if (index >= 0 && index < gameList.size()) {
            gameList.set(index, g);
        }
    }
}
