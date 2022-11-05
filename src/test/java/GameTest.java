import net.bytebuddy.jar.asm.ClassReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game repo = new Game();

    Player player1 = new Player(1, "Kate", 10);
    Player player2 = new Player(2, "Annet", 8);
    Player player3 = new Player(3, "Tony", 14);
    Player player4 = new Player(4, "Natalie", 9);
    Player player5 = new Player(5, "Mary", 7);
    Player player6 = new Player(6, "Lizzie", 9);

    @Test
    public void roundTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        int expected = 2;
        int actual = repo.round("Mary", "Kate");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void roundTest2() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        int expected = 1;
        int actual = repo.round("Tony", "Annet");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIfEqual() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        int expected = 0;
        int actual = repo.round("Lizzie", "Natalie");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void notRegisteredFirstTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("Michael", "Tony");
        });
    }

    @Test
    public void notRegisteredSecondTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("Annet", "Maggie");
        });
    }

    @Test
    public void notRegisteredBothTest() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            repo.round("Michael", "Alex");
        });
    }

    @Test
    public void notFoundStrength() {
        repo.register(player1);
        repo.register(player2);
        repo.register(player3);
        repo.register(player4);
        repo.register(player5);
        repo.register(player6);

        int expected = 0;
        int actual = repo.findPlayerStrength("Dave");

        Assertions.assertEquals(expected, actual);
    }
}
