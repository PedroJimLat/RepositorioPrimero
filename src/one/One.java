/*
 * Write an application to simulate the rolling of two dice. The application
should use an object of class Random once to roll the first die and again to roll the second die. The
sum of the two values should then be calculated. Each die can show an integer value from 1 to 6, so
the sum of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the
least frequent. Figure 7.30 shows the 36 possible combinations of the two dice. Your application
should roll the dice 36,000 times. Use a one-dimensional array to tally the number of times each
possible sum appears. Display the results in tabular format.
 */
package one;

import java.util.Random;

/**
 *
 * @author Pedro Jiménez Latorre
 * 
 */
public class One {
    public static void main(String[] args) {
        Random r = new Random();
        int die1, die2;
        int [] sums = new int[13];
        for (int i = 0; i < 36000; i++) {
            die1 = r.nextInt(6)+1;
            die2 = r.nextInt(6)+1;
            sums[die1+die2]++;
        }
        System.out.println("Sums\tTotal");
        
        for (int i = 2; i < sums.length; i++) {
            System.out.printf("%d\t%d\n",i,sums[i]);
        
        }
        
    }
}
