package backend.repository;

import backend.models.UsersMovies;
import java.util.List;


public interface UsersMoviesRepository {

    void listMovies(List<UsersMovies> movieList);
    public void rentMovie(int userId, int movieId, String title, int vote);
}
