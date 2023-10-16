package com.example.project.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>{

    @Query
    List<Movie> findByPlannedIsTrue();
    @Query
    List<Movie> findByWatchedIsTrue();
    @Query
    List<Movie> findByFavouritesIsTrue();
    @Query
    List<Movie> findByPostponedIsTrue();
    @Query
    List<Movie> findByAbandonedIsTrue();

}
