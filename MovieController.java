package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.MovieShow;
import com.repository.MovieRepository;
import com.service.BusService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class MovieController {

    @Autowired
    private MovieRepository movieShowRepository;

    @Autowired
    private BusService movieShowService;

    // Mapping to show the admin panel with all movie shows
    @RequestMapping("/admin")    
    public String showAdminPanel(Model model) {
        List<MovieShow> buses = movieShowService.getAllMovieShows1();
        model.addAttribute("buses", buses);
        return "admin-main";
    }

    // Mapping to display the form for adding a new movie show
    @RequestMapping("/new")
    public String showNewMovieShowForm() {
        return "create-bus";
    }

    // Mapping to save a new or updated movie show
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMovieShow(@ModelAttribute("movieShow") MovieShow movieShow) {
        movieShowRepository.save(movieShow);
        return "redirect:/student/list";
    }

    // Mapping to show the list of movie shows (for the "list" URL)
    @RequestMapping("/list")
    public String showMovieList(Model model) {
        List<MovieShow> buses = movieShowService.getAllMovieShows1();
        model.addAttribute("buses", buses);
        return "list-bus";  // Name of the JSP page to render the list
    }

    // Mapping to show the form for updating a specific movie show
    @GetMapping("/edit")
    public String showUpdateForm(@RequestParam("id") Long id, Model model) {
        MovieShow movieShow = movieShowService.getMovieById(id);
        model.addAttribute("movieShow", movieShow);
        return "update-bus";
    }
    @PostMapping("/update")  // Use @PostMapping for handling POST requests
    public String updateMovieShow(@ModelAttribute("movieShow") MovieShow movieShow) {
        movieShowService.updateMovieShow(movieShow);  // Ensure this method exists in your service
        return "redirect:/student/admin";  // Redirect to admin panel after update
    }

    // Mapping to delete a specific movie show
    @RequestMapping("/delete")
    public String deleteMovieShow(@RequestParam("id") Long id) {
        movieShowService.deleteMovieShow(id);
        return "redirect:/student/list";
    }

    // Mapping to show user movie booking page
    @GetMapping("/userMovieBooking")
    public String showMovies(Model model) {
        List<MovieShow> movies = movieShowService.getAllMovieShows1();
        model.addAttribute("movies", movies);
        return "userBooking";
    }
    @GetMapping("/bookTicketForm")
    public String showTicketBookingForm(@RequestParam("movieId") Long movieId, Model model) {
        MovieShow movie = movieShowService.getMovieById(movieId);  // Get movie by ID
        model.addAttribute("movie", movie);
        return "bookTicketForm";  // Return the booking form view
    }
    
    
    
    
    /* new for user login*/
    @RequestMapping("/login")
    public String login() {
    	 return "userLogin";
    }
    
    
    
    
    
  /* new code */
   
    
    

    @RequestMapping("/confirmBooking")
    public String confirmBooking() {

            return "confirmationPage"; 
        
    }

    // Handle payment processing via POST request
    @PostMapping("/processPayment")
    public String processPayment() {
            
            return "paymentPage";  // Redirect to confirmation page after successful payment
        }
    
   
    
    /* new code */
    @Controller
    @RequestMapping("/student")
    public class StudentController {

        @GetMapping("/authenticateAdmin")
        public String showAdminLoginForm() {
            return "adminLogin"; // Name of the JSP page for admin login
        }

        @PostMapping("/authenticateAdmin")
        public String authenticateAdmin(@RequestParam("email") String email, 
                                        @RequestParam("password") String password, 
                                        Model model) {

            final String adminEmail = "kisore@123";
            final String adminPassword = "kisore";

            if (email.equals(adminEmail) && password.equals(adminPassword)) {
                return "redirect:/student/admin"; // Redirect to admin panel if authenticated
            } else {
                model.addAttribute("error", "Invalid email or password.");
                return "adminLogin"; // Redirect back to login page with error message
            }
        }
    }


   /* new*/
    
    @GetMapping("/bookingReview")
    public String showBookingReview(@RequestParam("MovieId") Long Id, 
                                    @RequestParam("ticketCount") int ticketCount, 
                                    Model model) {
        // Fetch the movie using the movieId
        MovieShow movie = movieShowService.getMovieById(movieId);
        Long remainingSeats = movie.getAvailableSeats();

        // Set model attributes
        model.addAttribute("movie", movie);
        model.addAttribute("ticketCount", ticketCount);
        model.addAttribute("remainingSeats", remainingSeats);

      
        return "confirmationPage";
    }
 


}

    
    

