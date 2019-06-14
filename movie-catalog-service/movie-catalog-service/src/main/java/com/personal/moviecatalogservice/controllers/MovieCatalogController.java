package com.personal.moviecatalogservice.controllers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.personal.moviecatalogservice.models.CatalogItem;
import com.personal.moviecatalogservice.models.Movie;
import com.personal.moviecatalogservice.models.Rating;
import com.personal.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTmp;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
//		List<Rating> ratings = Arrays.asList(
//				new Rating("1234", 4),
//				new Rating("1345",5)
//				);
		/*******After making this service as client to eureka server**********/
		UserRating ratings = restTmp.getForObject("http://ratings-service/ratings/users/"+userId, UserRating.class);
		/********Before using eureka server and client concept***********/
		//UserRating ratings = restTmp.getForObject("http://localhost:8083/ratings/users/"+userId, UserRating.class);
		//RestTemplate restTmp = new RestTemplate();
		
//		for(Rating rating:ratings)
//		{
		return ratings.getUserRatings().stream().map(rating->
			{
			
				Movie returnedMovie = restTmp.getForObject("http://movie-info/movies/"+rating.getMovieId(), Movie.class);
				//Movie returnedMovie = restTmp.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);
				return new CatalogItem(returnedMovie.getMovieId(), "Tamil Movie", 4);
			}
		
		).collect(Collectors.toList());
			
		//}
		
//		return Collections.singletonList(
//				new CatalogItem("Ratsasan","Tamil Movie",5)
//				);
	}

}
