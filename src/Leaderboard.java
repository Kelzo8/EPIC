import java.util.ArrayList;
class Leaderboard {
    private ArrayList<Player> players;

    // Constructor to initialize the players list
    public Leaderboard() {
        this.players = new ArrayList<>();
    }

    // Add a player to the leaderboard
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Get the list of players on the leaderboard
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
