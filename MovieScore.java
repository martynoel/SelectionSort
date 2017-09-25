/* A class for comparing movies by IMDb score 
*/

public class MovieScore implements Comparable<MovieScore> {
	private final String title;
	private final Double score;

	public MovieScore(String t, Double s) {
		title = t;
		score = s;
	}

	public String getTitle() {
		return title;
	}

	public Double getScore() {
		return score;
	}

	public int compareTo(MovieScore that) {
		// implement this method
        if (this.getScore() == that.getScore()) {
            return 0;
        } else if (this.getScore() < that.getScore()) {
            return 1;
        } else {
            return -1;
        }
	}

	public static void main(String[] args) {
		MovieScore movie = new MovieScore("Alien", 3.0);
		System.out.println(movie.getTitle() + ", " + movie.getScore());
	}
}
