
package backend.models;


    public class UsersMovies {
        private int userId;
        private int movieId;
        private String title;
        private int UserVote;

    public UsersMovies(int userId, int movieId, String title, int UserVote) {
        this.userId = userId;
        this.movieId = movieId;
        this.title = title;
        this.UserVote = UserVote;
    }

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getMovieId() {
        return movieId;
    }


    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public int getUserVote() {
        return UserVote;
    }


    public void setUserVote(int UserVote) {
        this.UserVote = UserVote;
    }
        
}
