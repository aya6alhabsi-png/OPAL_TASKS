
package ArraysTask;

import java.util.Scanner;

public class ArraysTask {

    static Scanner userInput = new Scanner(System.in); //to read the value 

    public static void main(String[] args) {

        // the array 
        int[] num = {12, 7, 25, 3, 18, 9, 30, 14};

        //sum && average
        System.out.println("sum: " + sumArray(num));
        System.out.println("average: " + averageArray(num));

        
        int max = findMax(num);//find the largest num
        int min = findMin(num);//find the smallest num

        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("difference: " + (max - min));

        
        System.out.println("Even numbers: " + countEven(num));//count even numbers

        // search for two numbers entered by the user
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter a number to search for");
            int target = userInput.nextInt();

            // find the index of the number
            int index = indexOf(num, target);

            // check if the number is found
            if (index == -1) {
                System.out.println(target + " not found");
            } else {
                System.out.println(target + " found at index " + index);
            }
        }

    
        System.out.print("Original: ");  // the original array
        printArray(num);

        // reverse the array and store it in a new array
        int[] reversed = reverseArray(num);

        // print the reversed array
        System.out.print("Reversed: ");
        printArray(reversed);

        
        int[] grades = readGrades(5);//read grades for 5 students

        
        int passed = countPassed(grades);// count the students who passed

        // calculate the num of student who fail
        int failed = grades.length - passed;

        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
    }

    //calculate the sum of all num
    static int sumArray(int[] arr) {
        int sum = 0;

        // add each number to the sum
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    // calculate the avg of the num
    static double averageArray(int[] arr) {
        return (double) sumArray(arr) / arr.length;//the len
    }

    //find the largest number(max)
    static int findMax(int[] arr) {
        int max = arr[0];

        // compare each number with the current max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    // find the smallest num(min)
    static int findMin(int[] arr) {
        int min = arr[0];

        // compare each number with the current min
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    static int countEven(int[] arr) {
    // count the even numbers
        int count = 0;  

        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {// check if each number is even
                count++;
            }
        }

        return count;
    }

   
    static int indexOf(int[] arr, int target) { // find the index of the number(start 0)

        
        for (int i = 0; i < arr.length; i++) {// check each element in the array
            if (arr[i] == target) {
                return i;
            }
        }

        // return -1 if the number is not found
        return -1;
    }

    //reverse the array
    static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];

        // copy the numbers in reverse order
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }

        return reversed;
    }

                                        
 
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {  // print all the numbers in one line
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

   
    static int[] readGrades(int size) {//read the grades entered by the user
        int[] grades = new int[size];

        
        for (int i = 0; i < size; i++) {    // enter the grade for each student
            System.out.println("Enter grade " + (i + 1));
            grades[i] = userInput.nextInt();
        }

        return grades;
    }

    
    static int countPassed(int[] grades) {// count the students who passed
        int count = 0;

        
        for (int i = 0; i < grades.length; i++) { // check if each grade is 50 or more
            if (grades[i] >= 50) {
                count++;
            }
        }

        return count;
    }
}
