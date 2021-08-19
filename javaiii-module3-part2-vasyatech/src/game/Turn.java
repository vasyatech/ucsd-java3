package game;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Turn {
	ROCK(0),
	PAPER(1),
	SCICCORS(2);
	
	private int numVal;
    
    private static final Map<Integer,Turn> lookup = new HashMap<Integer,Turn>();
	
	static {
	    for(Turn t: EnumSet.allOf(Turn.class))
	         lookup.put(t.getNumVal(), t);
	}
	
	
	private Turn(int numVal) {
	    this.numVal = numVal;
	}
	
	public int getNumVal() { return numVal; }
	
	public static Turn get(int numVal) { 
	    return lookup.get(numVal); 
	}


}
