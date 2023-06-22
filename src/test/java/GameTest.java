import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameTest {
    Player player1 = new Player(101, "Александр", 100);
    Player player2 = new Player(121, "Евгений", 50);
    Player player3 = new Player(501, "Анна", 100);
    Player player4 = new Player(50, "Михаил", 1);

    @Test
    public void shouldRegisterPlayers1Win() throws NotRegisteredException {
        Game game = new Game();
        game.register(player1);
        game.register(player4);
        int act = game.round("Александр", "Михаил");
        int exp = 1;
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldRegisterPlayers2Win() throws NotRegisteredException {
        Game game = new Game();
        game.register(player2);
        game.register(player3);

        int exp = 2;
        int act = game.round("Евгений", "Анна");
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void shouldRegisterPlayersTie() throws NotRegisteredException {
        Game game = new Game();
        game.register(player1);
        game.register(player3);
        int exp = 0;
        int act = game.round("Александр", "Анна");
        Assertions.assertEquals(exp,act);
    }
    @Test
    public void shouldNotFindPlayer () {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> game.findPlayerByName("Александр"));
    }

    @Test
    public void shouldFailureGameWhenOneOfThenOrTwoNotRegister() throws NotRegisteredException {
        Game game = new Game();
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Иван", "Евгений"));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Евгений", "Алина"));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Иван", "Алина"));

    }
    @Test
    public void shouldFailureRegistrationAlreadyRegister() throws NotRegisteredException {
        Game game = new Game();
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.register(player4));
    }

}
