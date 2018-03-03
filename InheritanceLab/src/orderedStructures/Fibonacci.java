package orderedStructures;

public class Fibonacci extends Progression {

	private double prev; 
	
	public Fibonacci() { 
		this(1); 
		prev = 0; 
	}
	private Fibonacci(double first) {
		super(first);
	}

	@Override
	public double nextValue() {
        prev = current - prev;
        current = current + prev;
		
		return current;
	}
	
	@Override
	public String toString(){
		return "Fibo(" + (int)super.firstValue() + ")";
	}
	
	@Override	
	public double firstValue() { 
		double value = super.firstValue(); 
		prev = 0; 
		return value; 
	}
	
	@Override
	public boolean equals(Progression o) {
		if(this.toString().equals(o.toString())) {
			return true;
		}
		return false;
	}

}
