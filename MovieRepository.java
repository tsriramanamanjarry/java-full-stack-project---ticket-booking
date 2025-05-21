package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.MovieShow;

public interface MovieRepository extends JpaRepository<MovieShow, Long> {

	 
	 public List<MovieShow> findByMovieNameAndShowDate(String movieName, String showDate);
	 public List<MovieShow> findByMovieName(String movieName);
	 public List<MovieShow> findByShowDate(String showDate);

    
}
