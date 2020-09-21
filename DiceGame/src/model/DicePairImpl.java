/**
 * This class is implemented from the DicePair interface. 
 * It contains the DicePair constructor as well as getters method, equals, hashCode, CompareTo and the to string method.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-04-23
 * 
 */

package model;

import java.util.Random;
import model.interfaces.DicePair;
import model.interfaces.Die;

public class DicePairImpl implements DicePair{
	
	//creation of two die for the dice pair
	private Die die1;
	private Die die2;

	public DicePairImpl () {
		
		//the two die objects added in DicePair constructor. With random values to be passed for the value.
		die1 = new DieImpl(1, random(), 6);
		die2 = new DieImpl(2, random(), 6);
	}
	
	//A private int method used to generate random numbers for the dice values.
	private int random () {
		
		Random random = new Random();
		int maxValue = 6;
		int minValue = 1;
		int r = random.nextInt((maxValue - minValue) + 1) + minValue;
		
		return r;
	}
	
	//The method contains the constructor for die1 with the random method passed in the value. 
	//this is to generate random numbers every time the method is called.
	@Override
	public Die getDie1 () {
		
		this.die1 = new DieImpl(1, random(), 6);
		
		return this.die1;
	}
	//The method contains the constructor for die1 with the random method passed in the value. 
	//This is to generate random numbers every time the method is called.
	@Override
	public Die getDie2 () {
		
		this.die2 = new DieImpl (2, random(), 6);
		
		return this.die2;
	
	}
	
	@Override
	public int getTotal () {
		int die1Value = die1.getValue();
		int die2Value = die2.getValue();
		int total = die1Value + die2Value;
		
		return total;
	}

	@Override
	public boolean equals(DicePair dicePair) {
		
		if ((this.die1.equals(dicePair.getDie1())) && (this.die2.equals(dicePair.getDie2()))) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals (Object dicePair) {
		
		if (this == dicePair) {
			return true;
		} else if ((dicePair == null) || (!(dicePair instanceof DicePairImpl))){
			return false;
		}
		
		return equals((DicePairImpl) dicePair);
	}

	
	@Override
	public int compareTo(DicePair dicePair) {
		int compare = 0;
		
		if (this.getTotal() == dicePair.getTotal()) {
			compare = 0;
		} else if (this.getTotal() > dicePair.getTotal()) {
			compare = 1;
		} else if (this.getTotal() < dicePair.getTotal()) {
			compare = -1;
		}
	  return compare;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((die1 == null) ? 0 : die1.hashCode());
		result = prime * result + ((die2 == null) ? 0 : die2.hashCode());
		return result;
	}
	
	@Override 
	public String toString () {
		return "Dice 1:" + " " + this.die1.toString() + " , " + "Dice 2:" + " " + this.die2.toString() 
		+ ".." + "Total:" + this.getTotal();
	}
	
}
