/*
 * A small airline has just purchased a computer for its new automated reservation system.  You've been asked to develop the new system.  You're to write an application to assign seats on each flight of the airline's only plane (capacity: 10 seats).
 * Your application should display the following alternatives: Please type 1 for First Class and Please type 2 for Economy.  If the user types 1, your application should assign a seat in the first class section (seats 1-5).  If the user types 2, your application should assign a seat in the economy section (seats 6-10).  Your application should then display a boarding pass indicating the person's seat number and whether it's in the first class or economy section of the plane.
 * Use a one dimensional array of primitive type boolean to represent the seating chart of the plane.  Initialize all the elements of the array to false to indicate that all the seats are empty.  As each seat is assigned, set the corresponding element of the array to true to indicate that the seat is no longer available.
 * Your application should never assign a seat that has already been assigned.  When the economy section is full, your application should ask the person if it's acceptable to be placed in the first class section (and vice versa).  If yes, make the appropriate seat assignment.  If no, display the message "Next flight leaves in 3 hours."
 */
import java.util.Scanner;

public class AssignSeat{
	private static int SIZE = 10;
	public static enum Space {FULL, FIRST_CLASS, ECONOMY};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] plane = new int[SIZE];
		int seat = 0;
		while(seat != -1) {
			
			System.out.print("Please type 1 for First Class or 2 for Economy: ");
			switch (input.nextInt()) {
			case 1:
				seat = nextEmpty(plane, Space.FIRST_CLASS);
				if (seat != -1) {
					++plane[seat];
					printPass(seat, Space.FIRST_CLASS);
				}
				else {
					
					System.out.print("First Class is full.  Would you accept Economy seating?  Press 1 for yes or 2 for no: ");
					switch (input.nextInt()) {
					case 1:
						seat = nextEmpty(plane, Space.ECONOMY);
						++plane[seat];
						printPass(seat, Space.ECONOMY);
						break;
					case 2:
						System.out.printf("%s%n%n", "Next flight leaves in 3 hours.");
						break;
					}
				}
				break;
				
			case 2:
				seat = nextEmpty(plane, Space.ECONOMY);
				if (seat != -1) {
					++plane[seat];
					printPass(seat, Space.ECONOMY);
				}
				else {
					
					System.out.print("Economy is full.  Would you accept First Class seating?  Press 1 for yes or 2 for no: ");
					switch (input.nextInt()) {
					case 1:
						seat = nextEmpty(plane, Space.FIRST_CLASS);
						++plane[seat];
						printPass(seat, Space.FIRST_CLASS);
						break;
					case 2:
						System.out.printf("%s%n%n", "Next flight leaves in 3 hours.");
						break;
					}
				}
				break;
			default:
					
			}
			seat = nextEmpty(plane, Space.FULL);
		}
		System.out.println("All seats have been purchased.");
	}
	
	public static int nextEmpty(int[] plane, Space section) {
		int start = 0;
		int end = plane.length;
		switch (section) {
		case FIRST_CLASS:
			end = 5;
			break;
		case ECONOMY:
			start = 5;
			break;
		case FULL:
		}
		for(int i = start; i < end; ++i) {
			if (plane[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void printPass(int seat, Space section) {
		++seat;
		String response = "First Class";
		switch(section) {
		case ECONOMY:
			response = "Economy";
			break;
		case FIRST_CLASS:
		case FULL:
		}
		System.out.printf("Seat #%d  Section: %s%n%n", seat, response);
	}
}