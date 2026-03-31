import java.util.*;
import java.util.stream.*;
public class TopTrendingMovies{
    public static void main(String[] args){
        class Movie {
            String name;
            double rating;
            int year;
            Movie(String name, double rating, int year){
                this.name = name;
                this.rating = rating;
                this.year = year;
            }
        }
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("MovieA", 4.8, 2024));
        movies.add(new Movie("MovieB", 4.6, 2023));
        movies.add(new Movie("MovieC", 4.8, 2022));
        movies.add(new Movie("MovieD", 4.9, 2024));
        movies.add(new Movie("MovieE", 4.5, 2021));
        movies.add(new Movie("MovieF", 4.7, 2023));
        movies.stream()
                .sorted((m1, m2) ->{
                    if (m2.rating != m1.rating){
                        return Double.compare(m2.rating, m1.rating);
                    }
                    return m2.year - m1.year;
                })
                .limit(5)
                .forEach(m -> System.out.println(m.name + " " + m.rating + " " + m.year));
    }
}
