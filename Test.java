
import java.util.Random;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Test {

  public static void main(String args[]) {

    int arrayCount = 1000;
    String report = "";
    String arrayString = "";
    String sortedArrayString = "";

    Random random = new Random();

    int[] randomlyGeneratedArray = new int[arrayCount];

    // populate the arrays with 1000 random numbers (unsorted)
    for (int i = 0; i < randomlyGeneratedArray.length; i++) {
      int randomNum = random.nextInt(1000);
      randomlyGeneratedArray[i] = randomNum;
      arrayString += randomNum + " ";
    }

    report += "The randomly generated array is: \n " + arrayString + "\n\n\n\n";

    long startTime = System.nanoTime();
    int[] sortedNumbersFromFirstSort = firstSort(Arrays.copyOf(randomlyGeneratedArray, arrayCount));
    long duration = System.nanoTime() - startTime;

    for (int i = 0; i < sortedNumbersFromFirstSort.length; i++) {
      sortedArrayString += sortedNumbersFromFirstSort[i] + " ";
    }

    report += "The sorted Array is : \n " + sortedArrayString + "\n\n\n\n";

    report += "The time taken by the first sort is " + duration + " nanoseconds." + "\n";
    // printSortedArray(sortedNumbersFromFirstSort);

    startTime = System.nanoTime();
    int[] sortedNumbersBySecondSort = secondSort(Arrays.copyOf(randomlyGeneratedArray, arrayCount));
    duration = System.nanoTime() - startTime;
    report += "The time taken by the second sort is " + duration + " nanoseconds."+ "\n";
    // printSortedArray(sortedNumbersBySecondSort);

    startTime = System.nanoTime();
    int[] sortedNumbersByThirdSort = thirdSort(Arrays.copyOf(randomlyGeneratedArray, arrayCount));
    duration = System.nanoTime() - startTime;
    report += "The time taken by the third sort is " + duration + " nanoseconds."+ "\n";
    // printSortedArray(sortedNumbersByThirdSort);

    try (PrintStream out = new PrintStream(new FileOutputStream("DurationReport.txt"))) {
      out.print(report);
    }
    catch(Exception e) {
      System.out.println("Error");
    }

  }

  public static int[] firstSort(int[] givenNumbers) {

        for (int j = 0; j < givenNumbers.length; j++) {

          for (int i = 0; i < givenNumbers.length - 1; i++) {

            if (givenNumbers[i] > givenNumbers[i+1]) {
              int temp = givenNumbers[i];
              givenNumbers[i] = givenNumbers[i+1];
              givenNumbers[i+1] = temp;
            }

          }
        }

        return givenNumbers;
  }

  public static int[] secondSort(int[] givenNumbers) {

    for (int j = 0; j < givenNumbers.length; j++) {

      for (int i = 0; i < givenNumbers.length - 1 - j; i++) {

        if (givenNumbers[i] > givenNumbers[i+1]) {
          int temp = givenNumbers[i];
          givenNumbers[i] = givenNumbers[i+1];
          givenNumbers[i+1] = temp;
        }

      }
    }

    return givenNumbers;

  }

  public static int[] thirdSort(int[] givenNumbers) {

    boolean flag = true;
    int j = 0;

    while (flag && j < givenNumbers.length - 1) {

      flag = false;

      for (int i = 0; i < givenNumbers.length - 1 - j; i++) {

        if (givenNumbers[i] > givenNumbers[i+1]) {
          int temp = givenNumbers[i];
          givenNumbers[i] = givenNumbers[i+1];
          givenNumbers[i+1] = temp;
          flag = true;
        }

      }

      j++;
    }

    return givenNumbers;

  }

  public static void printSortedArray(int[] sortedArray) {
    for (int i = 0; i < sortedArray.length; i++) {
      System.out.print(sortedArray[i] + " ");
    }
    System.out.println();
  }


}
