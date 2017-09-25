# Selection Sort Workshop for Algorithms Fall 2017

__When you run the code, make sure to include the algs4.jar file in the command line, like so: `java -cp algs4.jar:. MovieSorter movie_title_score.sorted.csv 1600`__

Selection Sort was used on three .csv files of movies, ranked by IMDb scores. One file was in random order, another was already sorted, and a third was in reverse sorted order. I implemented the missing code in `MovieScore.java` and `MovieSorter.java` and ran it on the three data sets for N = 2000, 4000, 8000, and 16000, respectively. I then graphed the average runtime vs input (N) for each data set and analyzed runtimes by a) looking at the results of each run, and b) looking at the code in `Selection.java` (located in the `.jar` file) and using the number array accesses as a cost model. 

## Random order dataset
![Random order dataset](https://image.ibb.co/hCRuUQ/random_runtime.png)

## Reverse-sorted dataset
![Reverse-sorted dataset](https://image.ibb.co/jVYxik/reversed_runtime.png)

## Sorted dataset
![Sorted dataset](https://image.ibb.co/mNfcik/sorted_runtime.png)

## Rate of Growth Analysis
We can tell from the graphs that runtimes for Selection Sort do not have a linear rate of growth. The bigger the input size, the longer the runtime; when input size doubles, the program takes more than twice the amount of time to run. 

For all the datasets, the **runtime increases by an approximate factor of n^2** (N = 2000 -> N = 4000 grows by 2x, N = 4000 -> N = 8000 grows by 4x, N = 8000 -> N = 16000 grows by 8x, etc). 

The sorted dataset takes less time overall to be "re-sorted", but its runtime still grows at the same rate as the other two datasets' runtimes. 

## Code Analysis
`Selection.java` accesses the array of unsorted elements using a nested for loop, so the runtime will be ~O(n^2). 

## Does Order Matter?
The order of input data does not affect Selection Sort -- even if the minimum unsorted element was found before the array reached the end, the algorithm still has to check the entire array to ensure that said element was indeed the smallest. `less` is still called for every iteration, and `exch` is called each time the algorithm has iterated through the entire array and verified the minimum unsorted element for that iteration. 

As we can see with the runtime graph of the sorted dataset, it doesn't matter if the data is already sorted; the algorithm still has to go through each element to verify. 
