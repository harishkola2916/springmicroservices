package com.personal.movieratingservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.movieratingservice.models.Rating;
import com.personal.movieratingservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@RequestMapping("/{movieId}")
	public Rating getRatings(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId,4);
	}
	

	@RequestMapping("/users/{userId}")
	public UserRating getMoviesByUser(@PathVariable("userId") String userId)
	{
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("1345",5)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRatings(ratings);
		return userRating;
	}
}


