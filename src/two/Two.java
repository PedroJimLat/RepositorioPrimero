/*
 * A small airline has just purchased a computer for its new automated reservations system.
You have been asked to develop the new system. You are to write an application to assign seats on each
flight of the airline’s only plane (capacity: 10 seats). Your application should display the following alternatives:
Please type 1 for First Class and Please type 2 for Economy. If the user types 1, your application should assign a seat in the firstclass
section (seats 1–5). If the user types  2, your application should assign a seat in the economy section (seats 6–10). Your application should then
display a boarding pass indicating the person’s seat number and whether it is in the first-class or economy section of the plane. 
Use a two-dimensional array of primitive type  boolean to represent the seating chart of the plane. Initialize all the elements of the array to
false to indicate that all the seats are empty. As each seat is assigned, set the corresponding elements of the array to true to indicate that the seat is
no longer available.
Your application should never assign a seat that has already been assigned. When the economy
section is full, your application should ask the person if it is acceptable to be placed in the first-class
section (and vice versa). If yes, make the appropriate seat assignment. If no, display the message "Next flight leaves in 3 hours."
 */
package two;

import java.util.Scanner;

/**
 *
 * @author Pedro Jiménez Latorre
 */
public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scc = new Scanner(System.in);
        boolean seats[][] = new boolean[3][5];
        int option;    
        System.out.println("Please type 1 for First Class and Please type 2 for Economy, or 0 to exit");
        option = sc.nextInt();
        int free;
        while (option != 0) {
            if (option == 1 || option == 2) {
                free = free(option, seats);
                if (free < 5) {
                    boardingPass(option, free);
                }
                if (free == 5) {
                    if (option == 2) {
                        System.out.println("It is acceptable to be placed in the first-class (Y/N)");
                    } else {
                        System.out.println("It is acceptable to be placed in the economy class (Y/N)");
                    }
                    char yes = scc.next().toUpperCase().charAt(0);
                    if (yes == 'Y') {
                        if (option == 2) {
                            option = 1;
                        } else {
                            option = 2;
                        }
                    }
                    free = free(option, seats);
                    if (free < 5) {
                        boardingPass(option, free);
                    }
                    if (free == 5) {
                        System.out.println("Next flight leaves in 3 hours.");
                    }
                }

            }

            System.out.println("Please type 1 for First Class and Please type 2 for Economy, or 0 to exit");
            option = sc.nextInt();
        }
        System.out.println("Thank you very much for using our services");
    }

    private static int free(int option, boolean[][] seats) {
        int free = 0;
        while (free < 5 && seats[option][free]) {
            free++;
        }
        if (free < 5) {
            seats[option][free] = true;
        }
        return free;
    }

    private static void boardingPass(int option, int free) {
        if (option == 1) {
            System.out.println("You seat is in First Class, number " + (free + 1));
        } else {
            System.out.println("You seat is in Economy Class, number " + (free + 1));
        }
    }
}
