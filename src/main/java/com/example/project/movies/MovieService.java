package com.example.project.movies;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

@Component
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public static <E> List<E> toList(Iterable<E> iter) {
        List<E> list = new ArrayList<E>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }


    public List<Movie> getMoviesPlanned() {
        return toList(this.movieRepository.findByPlannedIsTrue());
    }

    public List<Movie> getMoviesWatched() {
        return this.movieRepository.findByWatchedIsTrue();
    }

    public List<Movie> getMoviesFavourites() {
        return this.movieRepository.findByFavouritesIsTrue();
    }

    public List<Movie> getMoviesPostponed() {
        return this.movieRepository.findByPostponedIsTrue();
    }

    public List<Movie> getMoviesAbandoned() {
        return this.movieRepository.findByAbandonedIsTrue();
    }


    public List<Movie> findMovies(String s) {
        return findMovies(s, 1);
    }

    public List<Movie> findMovies(String s, int page) {
        ArrayList<Movie> Movies = new ArrayList<Movie>();
        try {

            URL url = new URL("https://kinopoiskapiunofficial.tech/api/v2.2/films?type=ALL&" +
                    "keyword=" + URLEncoder.encode(s, StandardCharsets.UTF_8)
                    + "&page=" + page
            );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("X-API-KEY", "79309bde-6cab-48d6-a717-e633cf5fbc89");

            int responsecode = conn.getResponseCode();

            JSONObject response;

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(conn.getInputStream());
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();
                response = new JSONObject(inline);

                // Здесь в бой вступаем МЫ!
                JSONArray movies = (JSONArray) response.get("items");
                for (int i = 0; i < movies.length(); i++) {
                    Movie movie = new Movie();

                    movie.nameRU = movies.getJSONObject(i).optString("nameRu");
                    movie.ratingKinopoisk = movies.getJSONObject(i).optDouble("ratingKinopoisk");
                    movie.filmId = movies.getJSONObject(i).getInt("kinopoiskId");
                    movie.years = movies.getJSONObject(i).optInt("year");
                    movie.shortDescription = movies.getJSONObject(i).optString("type");
                    movie.Genres = movies.getJSONObject(i).optString("genres");
                    movie.nameEN = movies.getJSONObject(i).optString("nameOriginal");
                    movie.PosterURL = movies.getJSONObject(i).optString("posterUrlPreview");
                    movie.country = movies.getJSONObject(i).optString("countries");

                    Movies.add(movie);

                    System.out.println(movies.getJSONObject(i).optString("nameRu"));


                }

            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Movies;

    }

    public Movie saveMovie(Movie m) {
        return this.movieRepository.save(m);
    }

}
