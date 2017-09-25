/* Reads a file with "title|score" on each line (it's fragile)
*/
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.io.BufferedReader;

public class MovieScoreArrayReader {
	private String filename;

	public MovieScoreArrayReader(String fn) {
		filename = fn;
	}

	public MovieScore[] read(int N) throws FileNotFoundException, IOException {
		MovieScore[] movies = new MovieScore[N]; 
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int idx=0;
        String line = null;
        while((line = reader.readLine()) != null) {
        	String[] ts = line.split("[|]");
            movies[idx] = new MovieScore(ts[0], new Double(ts[1]));
            idx++;
            if (idx >= N) break;
        }
        reader.close();
        return movies;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	MovieScoreArrayReader ar = new MovieScoreArrayReader("movie_title_score.random.csv");
    	MovieScore[] movies = null;
    	movies = ar.read(10);    		
    	for (MovieScore m: movies) {
			System.out.println(m.getTitle() + ", " + m.getScore());
    	}
    }

}
