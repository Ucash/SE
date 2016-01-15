package projekt1.common.game;

import common.game.Game;

import java.util.*;

public class GameSet {
    private static final GameSet instance = new GameSet();
    private Map<String, Game> games = new HashMap<>();

    public static GameSet getInstance(){
        return instance;
    }

    private GameSet(){
        prepareGames().forEach(q -> games.put(q.getEngineName(), q));
    }

    public Game findGame(String engineName){
        return games.get(engineName);
    }

    private List<Game> prepareGames() {
        return new LinkedList<>(Arrays.asList(
                new Game("age_of_empires_2", "Age of Empires II"),
                new Game("heroes_3", "Heroes 3"),
                new Game("civilization_5", "Civilization V"),
                new Game("theme_park_world", "Theme Park World"),
                new Game("lol", "League of Legends"),
                new Game("dota", "DotA"),
                new Game("tibia", "Tibia"),
                new Game("wow", "World of Warcraft"),
                new Game("the_sims", "The Sims"),
                new Game("dyna", "Dyna"),
                new Game("cs", "Counter Strike"),
                new Game("quake", "Quake"),
                new Game("call_of_duty", "Call of Duty"),
                new Game("munchkin", "Munchkin"),
                new Game("magia_i_miecz", "Magia i Miecz"),
                new Game("neuroshima", "Neuroshima"),
                new Game("szachy", "Szachy"),
                new Game("mlynek", "Młynek"),
                new Game("brydz", "Brydż"),
                new Game("polska1939", "Polska1939"),
                new Game("eurobusiness", "Eurobusiness"),
                new Game("monopoly", "Monopoly"),
                new Game("carcassone", "Carcassone"),
                new Game("gra_o_tron", "Gra o Tron"),
                new Game("doodle", "Doodle"),
                new Game("dixit", "Dixit"),
                new Game("mafia", "Mafia")
        ));
    }
}
