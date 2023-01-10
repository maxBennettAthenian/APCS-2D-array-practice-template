import java.util.ArrayList;

public class MyMain {

    // Returns the number of odd numbers in mat
    public static int countOdds(int[][] mat) {
        // YOUR CODE HERE
        int odd = 0;
        for (int[] arr : mat) {
            for (int v : arr) {
                if (v % 2 !=0) {
                    odd++;
                }
            }
        }
        return odd;
    }

    // Returns the largest value in mat
    public static int findLargest(int[][] mat) {
        // YOUR CODE HERE
        int result = mat[0][0];
        for (int[] arr : mat) {
            for (int v : arr) {
                if (v > result) {
                    result = v;
                }
            }
        }
        return result;
    }

    // Write a method that "left-shifts" each row in a 2D array.
    // This means that for each row, all the numbers should be
    // shifted to the left by 1, with wraparound (the first value
    // should wrap around to the last entry in the row)
    public static int[][] leftShift(int[][] mat) {
        // YOUR CODE HERE
        int rowLength = mat[0].length;
        int[][] result = new int[mat.length][rowLength];
        for (int j = 0; j < mat.length; j++) {
            for (int i = 0; i < rowLength; i++) {
                result[j][(i - 1 + rowLength) % rowLength] = mat[j][i];
            }
        }
        return result;
    }

    // Creates a 2D array of size arraySize x arraySize
    // where each value is each to the sum of its row and col indexes
    public static int[][] arrayBuilder(int arraySize) {
        // YOUR CODE HERE
        int[][] result = new int[arraySize][arraySize];
        for (int r = 0; r < arraySize; r++) {
            for (int c = 0; c < arraySize; c++) {
                result[r][c] = r + c;
            }
        }
        return result;
    }










    // Methods for the homework:

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        // YOUR CODE HERE
        double total = 0;
        for (double[] r : mat) {
            for (double c : r) {
                total += c;
            }
        }
        return total / (mat.length * mat[0].length);
    }

    // Returns the median of the 2D array mat
    // Remember that the array is sorted!
    public static double median(double[][] mat) {
        // YOUR CODE HERE
        double[] total = new double[mat.length * mat[0].length];
        int index = 0;
        //add the values to our new 1D array
        for (double[] r : mat) {
            for (double c : r) {
                total[index] = c;
                index++;
            }
        }
        //sort
        for (int i = 0; i < total.length; i++) {
            double v = total[i];
            int smallestI = i;

            for (int j = i; j < total.length; j++) {
                if (total[smallestI] > total[j]) {
                    smallestI = j;
                }
            }
            total[i] = total[smallestI];
            total[smallestI] = v;
        }
        int len = total.length;
        return len % 2 == 0 ? (total[len / 2] + total[(len / 2) - 1]) / 2 : total[len / 2];
    }


    // Returns the mode of the 2D array mat
    // Remember that the array is sorted!
    public static double mode(double[][] mat) {
        // YOUR CODE HERE
        double[] total = new double[mat.length * mat[0].length];
        int index = 0;
        //add the values to our new 1D array
        for (double[] r : mat) {
            for (double c : r) {
                total[index] = c;
                index++;
            }
        }
        //loop through all numbers and IF it is the first of that number count and compare
        int curModeI = 0;
        int curModeAmount = 0;
        for (int i = 0; i < total.length; i++) {
            double v = total[i];
            boolean isFirst = true;
            int amount = 0;
            for (int j = 0; j < total.length; j++) { //count and check for isFirst
                if (j < i && total[j] == v) { // if not first
                    isFirst = false;
                    break;
                } else if (total[j] == v) {
                    amount++;
                }
            }

            if (isFirst && curModeAmount < amount) {
                curModeI = i;
                curModeAmount = amount;
            }
        }
        return total[curModeI];
    }


    public static void main(String[] args) {
        // Write some code here to test your methods!
        // nope
        /*
        ArrayList<Double>[] data = new ArrayList[10];

        ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>(10);
        for (int i = 0; i < 10; i++) {
            data.set(i, new ArrayList<Double>(10));
        }
        // index = amount of the numbers inside the double[]
        for (double[] r : mat) {
            for (double value : r) {
                int currentAmount = -1;
                //find the current amount of this double number
                for (ArrayList<Double> row : data) {
                    for (int i = 0; i < row.size(); i++) {
                        double v = row.get(i);
                        if (v == value) {
                            currentAmount = i;
                            break;
                        }
                    }
                }

                data.get(currentAmount + 1).add(value);
            }
        }
        return data.get(data.size() - 1).get(0);
         */
    }
}
