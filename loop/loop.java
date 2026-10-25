
//loop

public class loop {
    public static void main(String[] args) {

       
        for (int i = 1; i <= 5; i++) { //num of rows

            for (int j = 1; j <= 5 - i; j++) { // Print spaces 
                System.out.print(" "); 
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                // i = 3 --> 2 * 3 - 1 = 5 stars
                System.out.print("*"); // Print stars, adding 2 stars in each new row
            }

            System.out.println(); // Move to the next line (println not print)
        }

        /////////////////////////////////////////////////////// Part 2

        
        for (int i = 4; i >= 1; i--) {    // 4 rows 

            for (int j = 1; j <= 5 - i; j++) { 
                System.out.print(" ");
            }

            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*"); // Print stars, removing 2 stars in each row
            }

            System.out.println(); // Move to the next line 
        }
    }
}
