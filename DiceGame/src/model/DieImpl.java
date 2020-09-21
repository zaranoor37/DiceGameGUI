/**
 * This class is implemented from the Die interface. 
 * It contains the Die constructor as well as getters method, equals, hashCode and the to string method
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-04-23
 * 
 */

package model;

import model.interfaces.Die;

public class DieImpl implements Die {
	
	//declaration of the attributes
	private int number;
	private int value;
	private int numFaces;
	
	//creation of the die constructor
	public DieImpl (int number, int value, int numFaces) throws IllegalArgumentException {
		  
		this.number = number;
		this.value = value;
	
		//throwing illegal argument exception for when there are invalid inputs of the attributes upon calling the constructor
		if (number < 1 || number > 2 || value < 1 || value > numFaces || numFaces < 1) {
			throw new IllegalArgumentException("Invalid number");
		}
	}

	@Override
	public int getNumber() {
		
		return this.number;
	}

	@Override
	public int getValue() {

		return this.value;
	}

	@Override
	public int getNumFaces() {
		return numFaces ;
	}

	@Override
	public boolean equals(Die die) {
		if ((this.getValue() == die.getValue()) && ((this.getNumFaces() == die.getNumFaces()))) {
			return true;
		}
		return false;
	}
	
	public boolean equals (Object die) {
		if ((this.getValue() == ((Die)die).getValue()) && (this.getNumFaces() == ((Die)die).getNumFaces())) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numFaces;
		result = prime * result + number;
		result = prime * result + value;
		return result;
	}
	
	public String toString() {
		
		String returnValue = "";
		
		switch (this.value) {
		case 1:
			returnValue += "One";
			break;
		case 2:
			returnValue += "Two";
			break;
		case 3:
			returnValue += "Three";
			break;
		case 4:
			returnValue += "Four";
			break;
		case 5:
			returnValue += "Five";
			break;
		case 6:
			returnValue += "Six";
			break;
		case 7:
			returnValue += "Seven";
			break;
		case 8:
			returnValue += "Eight";
			break;
		default:
			returnValue += "> Nine";
			break;
		}
		
		return returnValue;
	}

}
