package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.MovieShow;
  // Ensure this is the correct repository
import com.repository.MovieRepository;

@Service
public class BusService {  // Renaming the service to reflect its responsibility

    @Autowired
    private MovieRepository movieShowRepository;  

 
    public List<MovieShow> getAllMovieShows() {
        return movieShowRepository.findAll();  
    }

   
    public MovieShow saveMovieShow(MovieShow movieShow) {
        return movieShowRepository.save(movieShow);  
    }

    public List<MovieShow> filterMovies1(String movieName, String showDate) {
        if (movieName != null && showDate != null) {
            return movieShowRepository.findByMovieNameAndShowDate(movieName, showDate);  // Add filtering logic here
        } else if (movieName != null) {
            return movieShowRepository.findByMovieName(movieName);
        } else if (showDate != null) {
            return movieShowRepository.findByShowDate(showDate);
        } else {
            return movieShowRepository.findAll();  // Return all if no filter is applied
        }
    }

    @Autowired
    private MovieRepository movieRepository;

    public void updateMovieShow(MovieShow movieShow) {
        movieRepository.save(movieShow);  // Save with the existing ID to update
    }
    public void deleteMovieShow(Long id) {
        movieShowRepository.deleteById(id); 
    }
    @Autowired
    private MovieRepository movieRepository1;

    public List<MovieShow> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieShow getMovieById1(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<MovieShow> getAllMovieShows1() {
        return movieShowRepository.findAll();  // Return all movie shows from the repository
    }

    public List<MovieShow> filterMovies(String movieName, String showDate) {
        return movieShowRepository.findByMovieNameAndShowDate(movieName, showDate);  
    }

    // Get Movie Show by ID
    public MovieShow getMovieShowById(Long id) {
        return movieShowRepository.findById(id).orElse(null);  // Fetching a MovieShow by its ID, or null if not found
    }
    public MovieShow getMovieById12(Long movieId) {
        return movieRepository.findById(movieId).orElse(null); // or handle absence more explicitly
    }

    

    @Autowired
    private MovieRepository movieRepository11; // Assume you have a MovieRepository interface

    public MovieShow getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElse(null);  // Fetch movie or return null if not found
    }
}



