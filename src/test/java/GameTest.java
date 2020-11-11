import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    private Game gameUnderTest;

    @BeforeEach
    void setUp() {
        gameUnderTest = new Game();
    }

    @Test
    void testPrint() {

        gameUnderTest.print();
    }


    @Test
    void testResult() {

        final Board.Status result = gameUnderTest.Result();

        assertEquals(Board.Status.STATUS, result);
    }
}
