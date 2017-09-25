/* Uses SelectionSort to sort N movies from a file by IMDb score,
   and reports the time.
   Usage:  MovieSorter <filename> <number>
*/
import java.lang.Throwable;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Selection;

class MovieSorter {
	public static void main(String[] args) {
		int N = 0;
        MovieScore[] movies = null;

		// parse the arguments
		String filename = args[0];

		try {
			N = Integer.parseInt(args[1]);
	    	MovieScoreArrayReader ar = new MovieScoreArrayReader(filename);
    		movies = ar.read(N);    
    	} catch (Throwable e) {
    		System.out.println("Error building movie array.");
    	}		

		Stopwatch stopwatch = new Stopwatch();
		// insert code
        
        for (int i = 0; i < movies.length-1; i++) {
            // Finding minimum element
            int min = i;
            
            // Iterate through rest of list and compare minimums
            for (int j = i+1; j < movies.length; j++) {
                if (movies[min].compareTo(movies[j]) == 1) {
                    min = j;
                }
            }
            
            // Swap with old element at index i
            // Makes sorted portion of the array
            MovieScore tempMovieScore = movies[min];
            movies[min] = movies[i];
            movies[i] = tempMovieScore;
        }
        
        // Logs how long the process took
		double time = stopwatch.elapsedTime();
        System.out.println("Time passed: " + time);
	}
}
