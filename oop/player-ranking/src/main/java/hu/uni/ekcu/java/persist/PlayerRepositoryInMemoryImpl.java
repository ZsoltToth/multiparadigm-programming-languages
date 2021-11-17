package hu.uni.ekcu.java.persist;

import hu.uni.ekcu.java.model.Player;
import hu.uni.ekcu.java.persist.exceptions.PlayerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class PlayerRepositoryInMemoryImpl implements PlayerRepository {

    private Set<Player> database;

    public PlayerRepositoryInMemoryImpl(){
        this(new HashSet<>());
    }

    protected PlayerRepositoryInMemoryImpl(Collection<Player> database){
        this.database = new HashSet<>(database);
    }

    @Override
    public Collection<Player> readAll() {
        return new HashSet<>(database);
    }

    @Override
    public Player readByUsername(String username) throws PlayerNotFoundException {
        try{
            return database.stream().filter(player -> player.getName().equals(username)).findFirst().get();
        }
        catch (NoSuchElementException ex){
            throw new PlayerNotFoundException(String.format("Player (%s) was not found!", username));
        }
    }

    @Override
    public Player save(Player player) {
        return null;
    }

    @Override
    public void delete(Player player) {

    }
}
