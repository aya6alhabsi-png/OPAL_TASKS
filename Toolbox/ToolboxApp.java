
//Create a package named ToolboxApp and a class named ToolboxApp.
// Use one shared static Scanner for the whole class 

package ToolboxApp;

import java.util.Scanner;

public  class ToolboxApp {
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("ToolboxApp is working!!");
        
        int choice;

        do {
            menu();
            System.out.print("enter the number between 0-9");
            choice = userInput.nextInt();
            switch(choice){
                case 1:
                    celsiusToFahrenheit();
                    break;
                case 2:
                    evenOrOdd();
                    break;
                case 3:
                       maxOfThree();
                       break;
                case 4:
                       factorial();
                       break;
                case 5:
                       multiplicationTable();
                       break;
                case 6:
                      starTriangle();
                      break;
                case 7:
                    isPrime();
                    break;
                case 8:
                    reverseNumber();
                    break;
                case 9:
                      numberPyramid();
                      break;
                case 0:
                     System.out.println("Print Goodbye! and end the program.");
                    break;
                default:
                    System.out.println("the number you choice invalid");           

            }

        }while (choice != 0);

        userInput.close();

        
    }

    public static void menu(){// mune the user can choose from  
            System.out.println("1.Celsius to Fahrenheit");
            System.out.println("2.Even or odd");
            System.out.println("3.Maximum of three numbers");
            System.out.println("4.Factorial");
            System.out.println("5.Multiplication table");
            System.out.println("6.Triangle of stars");
            System.out.println("7.Prime check");
            System.out.println("8.Reverse a number");
            System.out.println("9.Number pyramid");
            System.out.println("0.Exit");
          

    }
   //caculation 
    //Celsius to Fahrenheit
  public static void  celsiusToFahrenheit(){
    System.out.print("Enter the temp in Celsius : ");

    double c = userInput.nextDouble();
    double f = c * 9 / 5 + 32;
    System.out.println("Fahrenheit: " + f);
  }

  //even/odd

  public static void evenOrOdd(){
    System.out.print("Enter the number :");
    int num = userInput.nextInt();
    if(num %2 == 0){
        System.out.print("the number is even");
    }
    else {

        System.out.print("the number is odd");
    }
  }



  //max of three
  public static void  maxOfThree(){
     System.out.print("Enter the first number :");
            int  num1 = userInput.nextInt();
     System.out.print("Enter the sec number :");
            int num2 = userInput.nextInt();
     System.out.print("Enter the thired number :");
            int num3 = userInput.nextInt();
    ///max int 
            int max = Math.max(num1,Math.max(num2,num3));
     System.out.print("the maximum number is :" + max);
  }



  //factorial
  public static void factorial(){
    System.out.print("Enter the number :");
    int x = userInput.nextInt();
    long r = 1;
    for (int i=1; i<= x && i <=15; i++){
        r *= i;

    }
    System.out.println(x + "! =" + r);
  }



// multiplaction 
  public static void multiplicationTable() {
        System.out.print("Enter a number: ");
        int num1 = userInput.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(num1 + " x " + i + " = " + (num1 * i));
        }
    }




    //stars
      public static void starTriangle() {
        System.out.print("Enter number of rows: ");
        int row= userInput.nextInt();

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }



   //Prime check
 
    public static void isPrime() {
        System.out.print("Enter an integer greater than 1: ");
        int number = userInput.nextInt();

        if (number <= 1) {
            System.out.println("Invalid number. Please enter an integer greater than 1.");
            return;
        }

        boolean prime = true;

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println(number + " is prime.");
        } else {
            System.out.println(number + " is not prime.");
        }
    }




    // Reverse a positive integer
    public static void reverseNumber() {
        System.out.print("Enter a positive integer: ");
        int number = userInput.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number. Please enter a positive integer.");
            return;
        }

        int original = number;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

        System.out.println("Reversed number: " + reversed);
    }




    // Number pyramid
    public static void numberPyramid() {
        System.out.print("Enter number of rows: ");
        int rows = userInput.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}


 