import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    private Board boardUnderTest;

    @BeforeEach
    void setUp() {
        boardUnderTest = new Board();
    }

    @Test
    void testClear() {

        boardUnderTest.clear();
    }

    @Test
    void testSetSpace() {

        boardUnderTest.setSpace(0, 0, Board.Space.EMPTY);
    }

    @Test
    void testGetSpace() {

        final Board.Space result = boardUnderTest.getSpace(0, 0);

        assertEquals(Board.Space.EMPTY, result);
    }

    @Test
    void testGetStatus() {

        final Board.Status result = boardUnderTest.getStatus();

        assertEquals(Board.Status.STATUS, result);
    }
}
