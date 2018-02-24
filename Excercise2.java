import java.util.ArrayList;
import java.util.Scanner;

public class Excercise2 {
	public static void main(String[] args) {
		System.out.println("Hello World");
		actions();
	}
	static Scanner input = new Scanner(System.in);
	public static void actions() {
		System.out.println("Enter amount of cases:");
		int m = input.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<5; i++) {
			System.out.println("Enter action number between 1 and 3: ");
			int n = input.nextInt();
			
			if(n == 1) {
				System.out.println("Enter element: ");
				int b = input.nextInt();
				list.add(b);
			}
			else if(n == 2) {
				System.out.println("Enter element: ");
				int b = input.nextInt();
				remove(list,b);
			}
			else {
				System.out.println(list.size());
			}
		}
	}
	
	public static ArrayList<Integer> remove (ArrayList<Integer> aL, int r){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(aL);
		aL.clear();
		for(int a : temp) {
			if(a!=r) {
				aL.add(a);
			}
		}
		return aL;
	}

}
