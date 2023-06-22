import java.util.*;

public class Game {
    private final List<Player> players;

    public Game() {
        players = new ArrayList<>();
    }
    public void register(Player player) throws NotRegisteredException {
        if (!players.contains(player)) {
            players.add(player);
        } else throw new NotRegisteredException("This player is already registered");
    }
    public Player findPlayerByName(String name) throws NotRegisteredException {
        boolean isRegistered = false;
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            } isRegistered = true;
        } if (!isRegistered) {
         throw new NotRegisteredException("This player is not registered");
        }
        return null;
    }
    public int round(String player1Name, String player2Name) throws NotRegisteredException {
        Player player1 = findPlayerByName(player1Name);
        Player player2 = findPlayerByName(player2Name);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("One or both players are not registered");
        } else {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else if (player1.getStrength() < player2.getStrength()) {
                return 2;
            } else {
                return 0;
            }
        }
    }



}
