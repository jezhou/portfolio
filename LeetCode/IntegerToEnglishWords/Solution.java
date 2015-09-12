/**
 *  Author         : Jesse Zhou
 *  Date Completed : 9/4/2015
 *  Problem:       : Convert a non-negative integer to its english words
 *  								 representation. Given input is guaranteed to be less than
 *  								 2^31 - 1.
 *  Strategy       : 2^31 - 1 is around 2 billion, so we won't need words beyond
 *                   the standard nine digits, the "teens", the multiples of
 *                   ten, "hundred", "thousand", "million", and "billion".
 *                   General strategy is to break up the numbers into
 *                   "hundreds" groups (like 111,111,111,111 will become 4
 *                   groups of 111), process the groups individually, then
 *                   string them together appropriately. This problem has very
 *                   specific cases to tackle so make sure to handle them
 *                   carefully.
 *  Time           : O(1), because the loops are not dependent on how long the
 *                   number is. The time does not increase or decrease
 *                   linearly, and will always take the same amount of time.
 *  Dependencies   : StringBuilder
 *  Notes          : Super complicated implementation and not very readable.
 *  								 Consider revising in the future?
 */
public class Solution{

  /**
   * Given method to fill out, pretty much the main process
   * @param  num The number to convert
   * @return     Converted number
   */
  public String numberToWords(int num){

    if(num < 0){
      return null;    // if the number is not postive, return null object
    }
    if(num == 0){
      return "Zero";  // Return the word zero if the number 0 comes up
    }

    // Create initial arrays that will hold each part of the number and
    // the converted to english StringBuilders. Also make a StringBuilder
    // for the final string.
    int[] parts = new int[4];
    StringBuilder[] converted = new StringBuilder[4];
    StringBuilder finalString = new StringBuilder();

    // Split the number into 4 parts, hundreds, thousands, millions,
    // and billions. num will not go beyond 2 billion.
    for(int i = 0; i < 4; i++){
      parts[3-i] = num % 1000;
      num /= 1000;
    }

    // Process the number.
    for(int i = 0; i < 4; i++){

      // If the number in a particular part is empty (like 1,[000],111), then
      // skip this part of the processing.
      if(parts[i] == 0)
        continue;

      // Process each part accordingly.
      converted[i] = new StringBuilder();
      String hundreds = processHundreds(parts[i] / 100); // Send hundreds digit
      String tens = processTens(parts[i] % 100 / 10); // Send the Ten's digit
      String ones = processOnes(parts[i] % 10); // Send the ones digit
      boolean teens = false;

      // If tens processing wasn't empty and it classifies as a "teen", then
      // process the teens separately.
      if(tens != null && tens.equals("teens")){
        tens = processTeens(parts[i] % 100);
        teens = true;
      }

      // Append the hundreds digit if it isn't empty
      if(hundreds != null){
        converted[i].append(hundreds + " ");
      }

      // If tens wasn't empty, either apply the teen number or the non-teen
      // number
      if(tens != null){
        if(teens)
          converted[i].append(tens);
        else
          converted[i].append(tens + " ");
      }

      // If ones wasn't empty and tens WASN'T true, then append the ones number.
      // We must check for teens because no one says the number 19 as
      // "nineteen nine". If a teen was used, leave it.
      if(ones != null && !teens){
        converted[i].append(ones);
      }

      // Assemble each part of the converted hundreds string, and repeat
      // for each part of the number.
      converted[i] = new StringBuilder(converted[i].toString().trim());
    }

    // Create the final string, with the appropriate strings in between.
    for(int i = 0; i < 4; i++){
      if(converted[i] == null)
        continue;
      finalString.append(converted[i].toString());
      switch(i){
        case 0:
          finalString.append(" Billion ");
          break;
        case 1:
          finalString.append(" Million ");
          break;
        case 2:
          finalString.append(" Thousand ");
          break;
      }
    }

    return finalString.toString().trim();

  }

  /**
   * Process number by the hundreds place.
   * @param  num Single digit representing the hundreds place
   * @return     Converted hundreds place, to english
   */
  public String processHundreds(int num){
    if(num == 0){
      return null;
    }

    return processOnes(num) + " Hundred";
  }

  /**
   * Process number by the tens place
   * @param  num Single digit representing the tens place
   * @return     Converted tens place, to english
   */
  public String processTens(int num){
      if(num == 0){
        return null;
      }
      switch(num){
        case 1:
          return "teens";
        case 2:
          return "Twenty";
        case 3:
          return "Thirty";
        case 4:
          return "Forty";
        case 5:
          return "Fifty";
        case 6:
          return "Sixty";
        case 7:
          return "Seventy";
        case 8:
          return "Eighty";
        case 9:
          return "Ninety";
        default:
          return null;
      }
  }

  /**
   * Special case for "teen" numbers, 10 - 19
   * @param  num Number representing number from 10 to 19
   * @return     Converted "teen" number, in english
   */
  public String processTeens(int num){
    switch(num){
      case 10:
        return "Ten";
      case 11:
        return "Eleven";
      case 12:
        return "Twelve";
      case 13:
        return "Thirteen";
      case 14:
        return "Fourteen";
      case 15:
        return "Fifteen";
      case 16:
        return "Sixteen";
      case 17:
        return "Seventeen";
      case 18:
        return "Eighteen";
      case 19:
        return "Nineteen";
      default:
        return null;
    }
  }

  /**
   * Processes the ones place in a number
   * @param  num Number representing the ones place
   * @return     Converted ones number, in english
   */
  public String processOnes(int num){
    switch(num){
      case 1:
        return "One";
      case 2:
        return "Two";
      case 3:
        return "Three";
      case 4:
        return "Four";
      case 5:
        return "Five";
      case 6:
        return "Six";
      case 7:
        return "Seven";
      case 8:
        return "Eight";
      case 9:
        return "Nine";
      default:
        return null;
    }
  }

}
