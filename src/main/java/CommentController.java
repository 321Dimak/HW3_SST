public class CommentController {

    public static class Comment {
        private String text;
        private int rating;

        public Comment(String text, int rating) {
            this.text = text;
            this.rating = rating;
        }

        public String getText() {
            return text;
        }

        public int getRating() {
            return rating;
        }
    }

    public boolean isValidText(String text) {
        if (text == null || text.length() < 3 || text.length() > 300) {
            return false;
        }
        return !text.matches(".*[\"';()%].*");
    }

    public boolean isValidRating(int rating) {
        return rating >= 1 && rating <= 10;
    }

    public Comment saveComment(String text, int rating) {
        if (isValidText(text) && isValidRating(rating)) {
            return new Comment(text, rating);
        }
        return null;
    }
}
