package TesterClasses;

import orderedStructures.Arithmetic;
import orderedStructures.Fibonacci;
import orderedStructures.Geometric;
import orderedStructures.Progression;

public class ProgressionTester1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Progression p; 
		Progression p2;
		Progression p3;
		
////		
//		System.out.println("Testing Fibonaci:"); 
//		p = new Fibonacci(); 
//		p.printAllTerms(20);
		
		
//		System.out.println("\n\n\nTesting Geometric:"); 
		p2 = new Arithmetic(2, 3); 
//		System.out.println(p.getTerm(5));
//		p.printAllTerms(20);
//		
		System.out.println("\n\n\nTesting Arithmetic:"); 
		p = new Arithmetic(2, 3); 
//		System.out.println(p.getTerm(5));
//		p.printAllTerms(20);
		System.out.println(p2.equals(p2));
//		p3 = ((Arithmetic) p).add((Arithmetic) p2);
//		p3.printAllTerms(20);
		p3 = ((Arithmetic) p).substract((Arithmetic) p2);
		p3.printAllTerms(20);
	}

}
