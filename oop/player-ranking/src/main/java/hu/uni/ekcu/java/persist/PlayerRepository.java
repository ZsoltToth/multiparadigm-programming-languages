package hu.uni.ekcu.java.persist;

import hu.uni.ekcu.java.model.Player;
import hu.uni.ekcu.java.persist.exceptions.PlayerNotFoundException;

import java.util.Collection;

public interface PlayerRepository {

    Collection<Player> readAll();
    Player readByUsername(String username) throws PlayerNotFoundException;

    Player save(Player player);
    void delete(Player player);
}
