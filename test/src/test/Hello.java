package test;

interface Climb{
	boolean isTooHigh(int height, int limit);
}
public class Hello {

	public static void main(String[] args) {
		
			check((h, l) -> h > 1, 5);	
		}
		
		private static void check (Climb climb, int height) {
			if(climb.isTooHigh(height,  10))
				System.out.println("too high");
			else
				System.out.println("ok");	
		}
	
	

}
