import java.util.*;
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerAverage {
    public void printAverageRatings() {
        SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
        System.out.println("Movie size = " + sr.getMovieSize());
        System.out.println("Rater size = " + sr.getRaterSize());
        ArrayList<Rating> ratingList = sr.getAverageRatings(12);
        Collections.sort(ratingList);
        for (Rating i : ratingList) {
            System.out.printf("%-10.4f%s%n", i.getValue(), sr.getTitle(i.getItem()));
        }
    }
    
    public void getAverageRatingOneMovie() {
        SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
        ArrayList<Rating> ratingList = sr.getAverageRatings(2);
        String movieTitle = "Vacation";
        for (Rating i : ratingList) {
            if (sr.getTitle(i.getItem()).equals(movieTitle)) {
                System.out.printf("%-10.4f%s%n", i.getValue(), sr.getTitle(i.getItem()));
            }
        }
        
    }
}
