package common.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameSet {
    private static final GameSet instance = new GameSet();
    private Map<String, Game> games = new HashMap<>();

    public static GameSet getInstance(){
        return instance;
    }

    private GameSet(){
        //todo: create game map, key is engine name
        Game g = new Game("pacman", "PACMAN");
        Game g2 = new Game("agar", "AGAR");
        games.put(g.getEngineName(), g);
        games.put(g2.getEngineName(), g2);
    }

    public Game findGame(String engineName){
        return games.get(engineName);
    }

    public List<Game> findAll(){
        return new ArrayList<>(games.values());
    }
}
