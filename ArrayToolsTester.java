/**
Run with Assertions enabled:
 > java -ea ArrayToolsTester
*/
public class ArrayToolsTester{

public static void main(String args[]){
  double[] a = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] b = {1.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  double[] c = {1.0, 2.0, 3.0};
  double[] d = {5.0, 6.0, 0.0};
  double[] negatives = {-1.0, -0.5, -1.0, -1.5, -2.0, -2.5};
  double[] positives = {0.5, 1.0, 1.5, 2.5, 2.0, 2.5};
  double[] mixed = {0.0, -0.5, 1.0, -1.5, 1.0, 2.0, -2.5};
  double[] zeroes = {0.0, 0.0, 0.0, 0.0};
  double[] one_spot= {2.5};
  double[] empty_a = {};
  String label = "", error_msg = "", expectedString="", actualString="";
  double[] expectedArray, actualArray;


  System.out.println("--------- ArrayTools.toString() -------------");
  expectedString = "0.0, 0.5, 1.0, 1.5, 2.0, 2.5";
  actualString = ArrayTools.toString(a);
  assertStringsAreEqual("basic array", expectedString, actualString, "basic arrayToString doesn't work");
  expectedString = "";
  actualString = ArrayTools.toString(empty_a);
  assertStringsAreEqual("emtpy array", expectedString, actualString, "empty array doesn't work");
  System.out.println("All tests for ArrayTools.toString() pass!");
  System.out.println("--------------------------------------------\n\n");

  System.out.println("--------- ArrayTools.equals() --------------");
  System.out.println("Checking two arrays that are different...Expected:"+false+" Actual:"+ArrayTools.equals(a, b));
  assert ArrayTools.equals(a, b) == false: "The a and b arrays are not equal, but arraysAreEqual says they are equal";
  System.out.println("Checking two arrays that are same...Expected:"+true+" Actual:"+ArrayTools.equals(a, a));
  assert ArrayTools.equals(a, a) == true: "The a and b arrays are equal, but arraysAreEqual says they are not equal";
  System.out.println("Checking first array that's empty...Expected:"+false+" Actual:"+ArrayTools.equals(empty_a, a));
  assert ArrayTools.equals(empty_a, a) == false: "First empty array should not be empty to an array with values.";
  System.out.println("Checking second array that's empty...Expected:"+false+" Actual:"+ArrayTools.equals(a,empty_a));
  assert ArrayTools.equals(a, empty_a) == false: "Second empty array should not be empty to an array with values.";
  System.out.println("Checking two arrays that are empty...");
  assert ArrayTools.equals(empty_a, empty_a) == true: "Two empty arrays should be equal.";
  System.out.println("All tests for ArrayTools.equals(arr1, arr2) pass!");
  System.out.println("--------------------------------------------\n\n");

  System.out.println("--------- ArrayTools.reverse() --------------");
  expectedArray = new double[]{2.5, 2.0, 1.5, 1.0, 0.5, 0.0};
  actualArray = ArrayTools.reverse(a);
  assertArraysAreEqual("basic reversal",expectedArray, actualArray, "The array is not reversed");
  expectedArray = one_spot;
  actualArray =  ArrayTools.reverse(expectedArray);
  assertArraysAreEqual("reversal of a one spot array",expectedArray, actualArray, "One spot array is not reversed");
  expectedArray = empty_a;
  actualArray =  ArrayTools.reverse(expectedArray);
  assertArraysAreEqual("empty array",expectedArray, actualArray, "Empty array is not reversed");
  System.out.println("All tests for ArrayTools.reverse() pass!");
  System.out.println("--------------------------------------------\n\n");


  System.out.println("--------- ArrayTools.min()/max() --------------");
  double expectedDouble = -2.5;
  double actualDouble = ArrayTools.min(negatives);
  assertDoublesAreEqual("Min-all negatives", expectedDouble, actualDouble, "Min in an array of all negatives doesn't work");
  expectedDouble = -0.5;
  actualDouble = ArrayTools.max(negatives);
  assertDoublesAreEqual("Max-all negatives", expectedDouble, actualDouble, "Max in an array of all negatives doesn't work");
  expectedDouble = 0.5;
  actualDouble = ArrayTools.min(positives);
  expectedDouble = 2.5;
  actualDouble = ArrayTools.max(positives);
  assertDoublesAreEqual("Max-all positives", expectedDouble, actualDouble, "Max in an array of all positives doesn't work");
  expectedDouble = -2.5;
  actualDouble = ArrayTools.min(mixed);
  assertDoublesAreEqual("Min-mixed", expectedDouble, actualDouble, "Min in an array of mixed numbers doesn't work");
  expectedDouble = 2.0;
  actualDouble = ArrayTools.max(mixed);
  assertDoublesAreEqual("Max-mixed", expectedDouble, actualDouble, "Max in an array of all mixed numbers  doesn't work");
  expectedDouble = 0.0;
  actualDouble = ArrayTools.min(zeroes);
  assertDoublesAreEqual("Min-zeros", expectedDouble, actualDouble, "Min in an array of zeros doesn't work");
  actualDouble = ArrayTools.max(zeroes);
  assertDoublesAreEqual("Max-zeros", expectedDouble, actualDouble, "Max in an array of zeros doesn't work");
  expectedDouble = 2.5;
  actualDouble = ArrayTools.min(one_spot);
  assertDoublesAreEqual("Min- One Spot Array", expectedDouble, actualDouble, "Min in an array of one spot doesn't work");
  actualDouble = ArrayTools.max(one_spot);
  assertDoublesAreEqual("Max- One Spot Array", expectedDouble, actualDouble, "Max in an array of one spot doesn't work");
  expectedDouble = Double.POSITIVE_INFINITY;
  actualDouble = ArrayTools.min(empty_a);
  assertDoublesAreEqual("Min- Empty Array", expectedDouble, actualDouble, "Min in an empty array doesn't work");
  expectedDouble = Double.NEGATIVE_INFINITY;
  actualDouble = ArrayTools.max(empty_a);
  assertDoublesAreEqual("Max- Empty Array", expectedDouble, actualDouble, "Max in an empty array doesn't work");
  System.out.println("All tests for ArrayTools.min()/max() pass!");
  System.out.println("--------------------------------------------\n\n");


  System.out.println("--------- ArrayTools.scale() --------------");
  expectedArray = new double[]{0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
  actualArray = ArrayTools.scale(a,2);
  assertArraysAreEqual("basic scale by 2", expectedArray, actualArray, "Basic scale is incorrect");
  expectedArray = new double[]{5.0};
  actualArray = ArrayTools.scale(one_spot,2);
  assertArraysAreEqual("scale one spot array", expectedArray, actualArray, "scale of one spot array is incorrect");
  expectedArray = empty_a;
  actualArray =  ArrayTools.scale(empty_a,2);
  assertArraysAreEqual("scale empty array", expectedArray, actualArray, "scale of empty is incorrect");
  System.out.println("All tests for ArrayTools.scale() pass!");
  System.out.println("--------------------------------------------\n\n");


  System.out.println("--------- ArrayTools.weightedAdd() --------------");
  expectedArray = new double[]{2.0,3.0,2.25};
  actualArray = ArrayTools.weightedAdd(c,d,.75,.25);
  assertArraysAreEqual("same length, weights .75/.25", expectedArray, actualArray, "basic weighted add is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.weightedAdd(c,d,.75,.75);
  assertArraysAreEqual("weights don't add to 1", expectedArray, actualArray, "weights don't add to 1 incorrect");
  expectedArray = new double[]{0.25,0.875,1.5,1.125,1.5,1.875};
  actualArray = ArrayTools.weightedAdd(a,c,.75,.25);
  assertArraysAreEqual("different length (1st longer)", expectedArray, actualArray, "diff length weighted add is incorrect");
  expectedArray = new double[]{0.75,1.625,2.5,0.375,0.5,0.625};
  actualArray = ArrayTools.weightedAdd(c,a,.75,.25);
  assertArraysAreEqual("different length (2nd longer)", expectedArray, actualArray, "diff length weighted add is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.weightedAdd(empty_a,d,.75,.75);
  assertArraysAreEqual("first array is empty", expectedArray, actualArray, "empty first array is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.weightedAdd(d,empty_a,.75,.75);
  assertArraysAreEqual("second array is empty", expectedArray, actualArray, "empty second array is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.weightedAdd(empty_a,empty_a,.75,.75);
  assertArraysAreEqual("both arrays are empty", expectedArray, actualArray, "return when both arrays are empty incorrect");
  System.out.println("All tests for ArrayTools.weightedAdd() pass!");
  System.out.println("--------------------------------------------\n\n");


  System.out.println("--------- ArrayTools.copy() --------------");
  expectedArray = new double[]{1.0,1.5};
  actualArray = ArrayTools.copy(a,2,4);
  assertArraysAreEqual("basic copy array", expectedArray, actualArray, "basic copy is incorrect");
  expectedArray = a;
  actualArray = ArrayTools.copy(a,0,a.length);
  assertArraysAreEqual("copy entire array", expectedArray, actualArray, "copy entire array is incorrect");
  expectedArray = new double[]{2.5};
  actualArray = ArrayTools.copy(one_spot,0,1);
  assertArraysAreEqual("copy array with one spot", expectedArray, actualArray, "copy array with one spot is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.copy(a,2,2);
  assertArraysAreEqual("same index start/end", expectedArray, actualArray, "same index for start/end is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.copy(a,2,0);
  assertArraysAreEqual("larger start than end", expectedArray, actualArray, "larger start than end is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.copy(a,-2,3);
  assertArraysAreEqual("negative index (start)", expectedArray, actualArray, "negative start incorrect");
  System.out.println("All tests for ArrayTools.copy() pass!");
  System.out.println("--------------------------------------------\n\n");


  System.out.println("--------- ArrayTools.cut() --------------");
  expectedArray = new double[]{0.0,0.5,2.0,2.5};
  actualArray = ArrayTools.cut(a,2,4);
  assertArraysAreEqual("basic cut array", expectedArray, actualArray, "basic cut is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.cut(a,0,a.length);
  assertArraysAreEqual("cut entire array", expectedArray, actualArray, "cut entire array is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.cut(one_spot,0,1);
  assertArraysAreEqual("cut array with one spot", expectedArray, actualArray, "cut array with one spot is incorrect");
  expectedArray = new double[]{0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = ArrayTools.cut(a,2,2);
  assertArraysAreEqual("same index start/end", expectedArray, actualArray, "same index for start/end is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.cut(a,4,2);
  assertArraysAreEqual("larger start than end", expectedArray, actualArray, "larger start than end is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.cut(a,-2,2);
  assertArraysAreEqual("negative index (start)", expectedArray, actualArray, "negative start incorrect");
  System.out.println("All tests for ArrayTools.cut() pass!");
  System.out.println("--------------------------------------------\n\n");


  System.out.println("--------- ArrayTools.concat() --------------");
  expectedArray = new double[]{0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 5.0, 6.0, 0.0};
  actualArray = ArrayTools.concat(a,d);
  assertArraysAreEqual("basic concat array", expectedArray, actualArray, "basic concat is incorrect");
  expectedArray = new double[]{5.0,6.0,0.0};
  actualArray = ArrayTools.concat(empty_a,d);
  assertArraysAreEqual("empty array 1st", expectedArray, actualArray, "empty 1st array is incorrect");
  expectedArray = new double[]{5.0,6.0,0.0};
  actualArray = ArrayTools.concat(d,empty_a);
  assertArraysAreEqual("empty array 2nd", expectedArray, actualArray, "empty 2nd array is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.concat(empty_a,empty_a);
  assertArraysAreEqual("both empty arrays", expectedArray, actualArray, "both empty arrays is incorrect");
  System.out.println("All tests for ArrayTools.concat() pass!");
  System.out.println("--------------------------------------------\n\n");


  System.out.println("--------- ArrayTools.splice() --------------");
  expectedArray = new double[]{0.0, 0.5, 5.0, 6.0, 0.0,1.0, 1.5, 2.0, 2.5};
  actualArray = ArrayTools.splice(a,d,2);
  assertArraysAreEqual("basic splice array", expectedArray, actualArray, "basic splice is incorrect");
  expectedArray = new double[]{5.0, 6.0, 0.0, 0.0, 0.5, 1.0, 1.5, 2.0, 2.5};
  actualArray = ArrayTools.splice(a,d,0);
  assertArraysAreEqual("splice array - first spot", expectedArray, actualArray, "splicing at the first spot is incorrect");
  expectedArray = new double[]{0.0, 0.5, 1.0, 1.5, 2.0, 5.0, 6.0, 0.0, 2.5};
  actualArray = ArrayTools.splice(a,d,a.length-1);
  assertArraysAreEqual("splice array - last spot", expectedArray, actualArray, "splicing at the last spot is incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.splice(a,d,8);
  assertArraysAreEqual("index too big", expectedArray, actualArray, "index too big incorrect");
  expectedArray = empty_a;
  actualArray = ArrayTools.splice(a,d,-2);
  assertArraysAreEqual("negative index", expectedArray, actualArray, "negative index incorrect");
  System.out.println("All tests for ArrayTools.splice() pass!");
  System.out.println("--------------------------------------------\n\n");

}//main

  public static void assertStringsAreEqual(String testLabel, String expected, String actual, String errorMessage){
    System.out.println("Checking "+testLabel+"...\nExpected:"+expected+"\nActual:"+actual);
    assert expected.equals(actual): errorMessage;
    System.out.println("++++++++");
  }//assertStringsAreEqual helper method
  public static void assertArraysAreEqual(String testLabel, double[] expected, double[] actual, String errorMessage){
    System.out.println("Checking "+testLabel+"...");
    System.out.println("Expected:"+ArrayTools.toString(expected)+"\nActual:"+ArrayTools.toString(actual));
    assert ArrayTools.equals(expected,actual): errorMessage;
    System.out.println("++++++++");
  }//assertArraysAreEqual helper method
  public static void assertDoublesAreEqual(String testLabel, double expected, double actual, String errorMessage){
    System.out.println("Checking "+testLabel+"...");
    System.out.println("Expected:"+expected+"\nActual:"+actual);
    assert expected==actual: errorMessage;
    System.out.println("++++++++");
  }//assertArraysAreEqual helper method

}//ArrayTools library
