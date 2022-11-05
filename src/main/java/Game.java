

public class Game {

    private Player[] players = new Player[0];

    public void register(Player player) {
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];

        }
        tmp[tmp.length - 1] = player;
        players = tmp;
    }

    public int round(String playerName1, String playerName2) {
        if (findPlayer(playerName1) == null) {
            throw new NotRegisteredException("Такой игрок не найден");
        }
        if (findPlayer(playerName2) == null) {
            throw new NotRegisteredException("Такой игрок не найден");

        }
        return compare(findPlayerStrength(playerName1), findPlayerStrength(playerName2));

    }


    public Player[] findPlayer(String name) {
        Player[] result = new Player[0];
        for (Player list : getPlayers()) {
            if (matches(list.getName(), name)) {
                Player[] tmp = new Player[result.length + 1];
                tmp[tmp.length - 1] = list;
                result = tmp;
                return result;
            }
        }
        return null;
    }


    public Player[] getPlayers() {
        return players;
    }

    public int findPlayerStrength(String name) {
        for (Player list : getPlayers()) {
            if (matches(list.getName(), name)) {
                int value = list.getStrength();
                return value;
            }
        }
        return 0;
    }

    private boolean matches(String id1, String id2) {
        if (id1 == id2) {
            return true;
        } else {
            return false;
        }
    }

    public int compare(int o1, int o2) {
        if (o1 < o2) {
            return 2;
        } else if (o1 > o2) {
            return 1;
        } else {
            return 0;
        }
    }
}


