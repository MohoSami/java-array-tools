/**
 *  <i>ArrayTools</i>. This library features methods for dealing with doubles arrays
 *  <p>
 *
 * This documentation will take you through it
 *
 *  <p>
 *  <h5>Created by Mohammed Sami</h5>
 *  @author Mohammed Sami
 */

public class ArrayTools {

/**
*Prints the values of the array on a single line,
*with a comma and a space between each element
* @param array an array of doubles
* @author Mohammed Sami
*/
  public static void print(double[] array){
    for (int i = 0; i < array.length; i++){
      if(i == array.length - 1){
        System.out.print(array[i]);
      } else {
        System.out.print(array[i] + ", ");
      }
    }
    System.out.println("");
  }

/**
*Returns a string version of the array, with a comma and a space between each element on a single-line
*
* @param array an array of doubles
* @return result a string version of the doubles array
*/
  public static String toString(double[] array){
    String result = "";
    for (int i = 0; i < array.length; i++){
      if(i == array.length - 1){
        result = result + array[i];
      } else {
        result = result + array[i] + ", ";
      }
    }
      return result;
  }


  /**
  *Compares two arrays for equality, including size and content
  *
  * @param array1 an array of doubles
  * @param array2 an array of doubles
  * @return true/false boolean value for whether or not array1 and array2 are equal
  */
  public static boolean equals(double[] array1, double[] array2){
    if(array1.length != array2.length) return false;

    for(int i = 0; i < array1.length; i++){
      if(array1[i] != array2[i]) return false;
    }
    return true;
}


/**
*Returns the maximum value in an array, or Double.NEGATIVE_INFINITY in case of an empty array
*
* @param givenArray an array of doubles
* @return maxDouble largest double in the array or Double.NEGATIVE_INFINITY if empty array
*/
  public static double max(double[] givenArray){
    double maxDouble = Double.NEGATIVE_INFINITY;
    if(givenArray.length == 0){
      return maxDouble;
    } else {
      for(int i = 0; i < givenArray.length; i++){
        if(givenArray[i] > maxDouble){
          maxDouble = givenArray[i];
        }
      }
    }
    return maxDouble;
  }


  /**
  *Returns the minimum value in an array, or Double.POSITIVE_INFINITY in case of an empty array
  *
  * @param givenArray an array of doubles
  * @return smallest double value in array of Double.POSITIVE_INFINITY if empty
  */
  public static double min(double[] givenArray){
    double minInt = Double.POSITIVE_INFINITY;
    if(givenArray.length == 0){
      return minInt;
    } else {
      for(int i = 0; i < givenArray.length; i++){
        if(givenArray[i] < minInt){
          minInt = givenArray[i];
        }
      }
    }
    return minInt;
  }


  /**
  *Returns a new array in reverse order
  *
  * @param givenArray an array of doubles
  * @return result a reversed version of givenArray
  */
  public static double[] reverse(double[] givenArray){
    double[] newArray = new double[givenArray.length];
    for(int i = 0; i < givenArray.length; i++){
      newArray[i] = givenArray[givenArray.length - (i+1)];
    }
    return newArray;
  }


  /**
  *Returns a new array, with the value at each index correspoding to the original array index mulitplied by multiplier
  *
  * @param givenArray an doubles array of doubles
  * @param multiplier an int with which to multiply each indice
  * @return new array consisting of the value of each indice of givenArray multiplied by multiplier
  */
  public static double[] scale(double[] givenArray, int multiplier){
    double[] newArray = new double[givenArray.length];
    for(int i = 0; i < givenArray.length; i++){
      newArray[i] = givenArray[i] * multiplier;
    }
    return newArray;
  }


  /**
  *Returns a new array with the result of the weighted addition of two arrays. 
  *If the arrays are of different size, assumes that missing tail values of the smaller array are 0. Ensures that the weights sum to 1.
  *
  * @param givenarray1 an array of doubles
  * @param givenarray2 an array of doubles
  * @param num1 a double with whom num2 must add to equal 1
  * @param num2 a double with whom num1 must add to equal 1
  * @return an array of doubles equal to the length of the larger array
  */
  public static double[] weightedAdd(double[] givenarray1, double[] givenarray2, double num1, double num2){
    double[] emptyArray = {};
    if((num1 + num2) != 1){
      return emptyArray;
    }
    double[] array1;
    double[] array2;

    if(givenarray1.length >= givenarray2.length){
      array1 = new double[givenarray1.length];
      array2 = new double[givenarray1.length];
    } else {
      array1 = new double[givenarray2.length];
      array2 = new double[givenarray2.length];
    }

    for(int i = 0; i < givenarray1.length; i++){
      array1[i] = givenarray1[i] * num1;
    }

    for(int i = 0; i < givenarray2.length; i++){
      array2[i] = givenarray2[i] * num2;
    }

    double[] newArray = new double[array1.length];

    for(int i = 0; i < array1.length; i++){
      newArray[i] = array1[i] + array2[i];
    }
    return newArray;

  }



  /**
  *Returns a new array that is a smaller portion of the original array, according to the portion of the array specified by two parameters (inclusive, exclusive)
  *
  * @param givenArray an array of doubles
  * @param inclusive integer index on which to start on (inclusive)
  * @param exclusive integer index before which to stop (exclusive)
  * @return an array of doubles that is copied from the original array at the indices specified
  */
  public static double[] copy(double[] givenArray, int inclusive, int exclusive){
    double[] emptyArray = {};
    if(exclusive < inclusive){
      return emptyArray;
    }
    if((inclusive < 0) || (exclusive < 0)){
      return emptyArray;
    }
    int newArrayLength = exclusive - inclusive;
    double[] newArray = new double[newArrayLength];
    for(int i = 0; i < newArray.length; i++){
      newArray[i] = givenArray[i + inclusive];
    }
    return newArray;
  }


  /**
  *Returns a new array that removes a portion of the original array, according to the portion of the array specified by two parameters (inclusive, exclusive)
  *
  * @param givenArray an array of doubles
  * @param inclusive an integer value index at which to begin the cut (inclusive)
  * @param exclusive an integer value index at which to end cut (exclusive)
  * @return new array that is the cut version of original array 
  */
  public static double[] cut(double[] givenArray, int inclusive, int exclusive){
    double[] emptyArray = {};
    if(exclusive < inclusive){
      return emptyArray;
    }
    if((inclusive < 0) || (exclusive < 0)){
      return emptyArray;
    }
    int newArrayLength = givenArray.length - (exclusive - inclusive);
    double[] newArray = new double[newArrayLength];
    for(int i = 0; i < inclusive; i++){
      newArray[i] = givenArray[i];
    }
    for(int i = exclusive; i < givenArray.length; i++){
      newArray[i - (exclusive - inclusive)] = givenArray[i];
    }
    return newArray;
  }




  /**
  *Returns a new array that is one array appended to the end of a second array
  *
  * @param array1 an array of doubles
  * @param array2 an array of doubles
  * @return a doubles array that is a new concatenated version of the two arrays
  */
  public static double[] concat(double[] array1, double[] array2){
    int finalLength = array1.length + array2.length;

    double[] result = new double[finalLength];

    for(int i = 0; i < array1.length; i++){
      result[i] = array1[i];
    }

    for(int i = 0; i < array2.length; i++){
      result[i + array1.length] = array2[i];
    }
    return result;
  }


  /**
  *Returns a new array that is one array inserted into a second array at the specified index
  *
  * @param array1 an array of doubles
  * @param array2 an array of doubles
  * @param index an integer index value
  * @return new doubles array that has array2 inserted into array1 at specified index 
  */
  public static double[] splice(double[] array1, double[] array2, int index){
    double[] emptyArray = {};
    if(index >= array1.length){
      return emptyArray;
    }
    if(index < 0){
      return emptyArray;
    }
    int finalLength = array1.length + array2.length;
    double[] result = new double[finalLength];
    for(int i = 0; i < index; i++){
      result[i] = array1[i];
    }
    for(int i = 0; i < array2.length; i++){
      result[i + index] = array2[i];
    }
    for(int i = index; i < array1.length; i++){
      result[i + array2.length] = array1[i];
    }
    return result;
  }
//note to self: functions end when a function returns


























  public static void main(String args[]){
    double[] a = {1.0, 2.0, 3.0, 4.0, 5.0};
    double[] b = {6.0, 7.0, 8.0, 9.0, 10.0};
    double[] c = {1.0, 2.0, 3.0, 4.0, 5.0};
    double[] d = {};

    System.out.println("printing each array after using ArrayTools.toString(): ");
    System.out.println("");
    System.out.print("doubles array a: ");
    System.out.println(toString(a));
    System.out.print("doubles array b: ");
    System.out.println(toString(b));
    System.out.print("doubles array c: ");
    System.out.println(toString(c));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.equals(): ");
    System.out.print("equals(a, b) : ");
    System.out.println(equals(a, b));
    System.out.print("equals(a, c) : ");
    System.out.println(equals(a, c));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.max() : ");
    System.out.println("max(a) : " + max(a));
    System.out.println("max(b) : " + max(b));
    System.out.println("max(c) : " + max(c));
    System.out.println("max(d) : " + max(d));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.min() : ");
    System.out.println("min(a) : " + min(a));
    System.out.println("min(b) : " + min(b));
    System.out.println("min(c) : " + min(c));
    System.out.println("min(d) : " + min(d));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.reverse() : ");
    System.out.println("reverse(a) : " + toString(reverse(a)));
    System.out.println("reverse(b) : " + toString(reverse(b)));
    System.out.println("reverse(c) : " + toString(reverse(c)));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.scale() : ");
    System.out.println("scale(a, 2) : " + toString(scale(a, 2)));
    System.out.println("scale(b, 17) : " + toString(scale(b, 17)));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.weightedAdd() : ");
    System.out.println("weightedAdd(a, b, 1.0, 0.0) : " + toString(weightedAdd(a, b, 1.0, 0.0)));
    System.out.println("weightedAdd(a, b, 0.5, 0.5) : " + toString(weightedAdd(a, b, 0.5, 0.5)));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.copy() : ");
    System.out.println("copy(a, 1, 4) : " + toString(copy(a, 1, 4)));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.cut() : ");
    System.out.println("cut(b, 1, 4) : " + toString(cut(b, 1, 4)));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.concat() : ");
    System.out.println("concat(a, b) : " + toString(concat(a, b)));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("ArrayTools.splice() : ");
    System.out.println("splice(a, b, 2) : " + toString(splice(a, b, 2)));
    System.out.println("");
    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    System.out.println("");
    System.out.println("USING ArrayTools.print() to print each array from before: ");
    System.out.print("array a : ");
    print(a);
    System.out.print("array c : ");
    print(b);
    System.out.print("array c : ");
    print(c);
 
    
  }
}