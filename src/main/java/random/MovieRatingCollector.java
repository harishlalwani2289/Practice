package random;

import java.util.*;

public class MovieRatingCollector {

    static Map<String, List<Double>> movieRatingMap = new HashMap<>();


    public static class RatingCollectorImpl implements RatingCollector {
        @Override
        public void putNewRating(String movie, double rating) {
            List<Double> movieRating;
            if(!movieRatingMap.containsKey(movie) &&  movieRatingMap.get(movie) != null) {
                movieRating = movieRatingMap.get(movie);
                movieRating.add(rating);
            }
            else {
                movieRating = new ArrayList<Double>();
                movieRating.add(rating);
            }
            movieRatingMap.put(movie, movieRating);
        }

        @Override
        public double getAverageRating(String movie) {
            double sum = 0.0;
            if(movieRatingMap.containsKey(movie)) {
                for (Double rating :
                        movieRatingMap.get(movie)) {
                    sum = sum + rating;
                }
            }
            return sum/movieRatingMap.get(movie).size();
        }

        @Override
        public int getRatingCount(String movie) {
            return movieRatingMap.containsKey(movie)?movieRatingMap.get(movie).size():0;
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface RatingCollector {
        // This is an input. Make note of this rating.  Rating can be a double number between 0 and 100.
        void putNewRating(String movie, double rating);

        // Get the average rating
        double getAverageRating(String movie);

        // Get the total number of ratings received for the movie
        int getRatingCount(String movie);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final RatingCollector stats = new RatingCollectorImpl();
            final Set<String> movies = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                movies.add(symbol);
                final double price = Double.parseDouble(tokens[1]);

                stats.putNewRating(symbol, price);

            }

            for (String movie : movies) {
                System.out.println(
                        String.format("%s %.4f %d", movie, stats.getAverageRating(movie), stats.getRatingCount(movie)));
            }

        }
        scanner.close();

    }
}