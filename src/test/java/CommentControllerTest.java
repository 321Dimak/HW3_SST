import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentControllerTest {

    private final CommentController controller = new CommentController();

    @Test
    public void testValidTextAndRating() {
        CommentController.Comment c = controller.saveComment("This is a safe comment", 5);
        assertNotNull(c);
        assertEquals("This is a safe comment", c.getText());
        assertEquals(5, c.getRating());
    }

    @Test
    public void testShortText() {
        assertNull(controller.saveComment("Hi", 5));
    }

    @Test
    public void testLongText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 301; i++) sb.append("a");
        assertNull(controller.saveComment(sb.toString(), 5));
    }

    @Test
    public void testTextWithInvalidCharacters() {
        assertNull(controller.saveComment("This comment contains %", 5));
        assertNull(controller.saveComment("Invalid character: '", 5));
        assertNull(controller.saveComment("Bad char: ( )", 5));
    }

    @Test
    public void testInvalidRatingLow() {
        assertNull(controller.saveComment("Valid comment", 0));
    }

    @Test
    public void testInvalidRatingHigh() {
        assertNull(controller.saveComment("Valid comment", 11));
    }

    @Test
    public void testNullText() {
        assertNull(controller.saveComment(null, 5));
    }
}