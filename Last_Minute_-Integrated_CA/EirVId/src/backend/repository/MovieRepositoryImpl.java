
package backend.repository;

import backend.models.Movie;
import java.util.List;

    public class MovieRepositoryImpl implements MovieRepository{

    /**
     *
     * @param movieList
     * @return
     */
    @Override
    public void listMovies(List <Movie> movieList) {
        
      
        for(int i = 0; i < movieList.size(); i++ ){
            Movie currnetMovie = movieList.get(i);
            System.out.println(i + " "+ currnetMovie.getTitle());
        }
      
    }

}
