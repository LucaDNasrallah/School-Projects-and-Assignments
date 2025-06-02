
public class Stamps {
	//------------------------------------------------------------------------------- // 
	//						         Attributes 			  		             	  //
	//------------------------------------------------------------------------------- // 
	// Each Category of the Stamps, along with their Corresponding Value.  // 
	private int category_A, category_B, category_C,category_D, category_E; 
	private  int VALUE_A = 2 , VALUE_B = 5 , VALUE_C = 10, VALUE_D = 15 , VALUE_E = 20;  // Pricing for each Stamp Type. 
	
	// Constructors // 
	public Stamps() {} // Default Constructor 
	
	// Constructor with 5 Parameters to set the number of each stamp Category in the registry. // 
	public Stamps(int a, int b , int c, int d, int e) {
		this.category_A = a;
		this.category_B = b;
		this.category_C = c;
		this.category_D = d;
		this.category_E = e; 
	} // END of Stamps Constructor // 
	
	// Copy Constructors // 
	public Stamps(Stamps stamps) {
		this.category_A = stamps.category_A;
		this.category_B = stamps.category_B;
		this.category_C = stamps.category_C;
		this.category_D = stamps.category_D;
		this.category_E = stamps.category_D;
		
		
	} // END of Copy Constructor // 
	//------------------------------------------------------------------------------- // 
	//								 These are the getters
	//------------------------------------------------------------------------------- // 
	public int getCategoryA() {
	    return category_A;
	} // END of Getter for CAT_A // 

	public int getCategoryB() {
	    return category_B;
	} // END of Getter for CAT_B // 

	public int getCategoryC() {
	    return category_C;
	} // END of Getter for CAT_C // 

	public int getCategoryD() {
	    return category_D;
	} // END of Getter of CAT_D // 

	public int getCategoryE() {
	    return category_E;
	} // END of Getter for CAT_E // 
	//------------------------------------------------------------------------------- // 
	//						These are the setters -- Non Negatives					  //
	//------------------------------------------------------------------------------- // 
	public void setCategoryA(int categoryA) {
	    if (categoryA >= 0)
	    { 
	        this.category_A = categoryA;
	    } else 
	    {
	        System.out.println("Invalid value: Category A stamp count cannot be negative.");
	    }
	} // END of Setter for CAT_A // 

	public void setCategoryB(int categoryB) {
	    if (categoryB >= 0) 
	    {
	        this.category_B = categoryB;
	    } 
	    else 
	    {
	        System.out.println("Invalid value: Category B stamp count cannot be negative.");
	    }
	} // END of Setter for CAT_B // 

	public void setCategoryC(int categoryC) {
	    if (categoryC >= 0)
	    {
	        this.category_C = categoryC;
	    } else
	    {
	        System.out.println("Invalid value: Category C stamp count cannot be negative.");
	    }
	} // END of Setter for CAT_C  // 

	public void setCategoryD(int categoryD) {
	    if (categoryD >= 0) 
	    {
	        this.category_D = categoryD;
	    } else 
	    {
	        System.out.println("Invalid value: Category D stamp count cannot be negative.");
	    }
	} // END of Setter for CAT_D //

	public void setCategoryE(int categoryE) {
	    if (categoryE >= 0) 
	    {
	        this.category_E = categoryE;
	    } else 
	    {
	        System.out.println("Invalid value: Category E stamp count cannot be negative.");
	    } 
	} // END of Setter for CAT_E // 
	
	//------------------------------------------------------------------------------- // 
	//							Methods and Functions      					          //
	//------------------------------------------------------------------------------- // 
	public void addStamps(int a , int b, int c , int d, int e) {
		this.category_A += a;
		this.category_B += b;
		this.category_C += c;
		this.category_D += d;
		this.category_E += e;
		
	} // END of Add Stamps Method //
	
	// Taking the sum of all the Current Saved Stamps of Each Category. // 
	public int stampTotal()
	{
		int total =(category_A * VALUE_A) + 
					  (category_B * VALUE_B) + 
					  (category_C * VALUE_C) + 
					  (category_D * VALUE_D) +
					  (category_E * VALUE_E); 
		return total;
	}// END of the Total Stamp Pricing Method
	
	//------------------------------------------------------------------------------- // 
	//					   toString Method and Equals Method                    	  //
	//------------------------------------------------------------------------------- // 
	
	// displaying all the counts for the Stamps of each Category. // 
	public String toString() {
		return "Details for the Stamps:\n"
			+ category_A + " x $2 + " + category_B + " x $5 + " + category_C
			+ " x $10 + " + category_D + " x $15 + " + category_E + " x $20"
			+ "\n------------------------------";
	} // END of toString Method // 
	
	public boolean equals(Object obj)
	{
		 // Check if the object is of type Stamps
	    if (this == obj) {
	        return true; // Same object reference
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false; // Different types or null object
	    }

	    // Cast the object to Stamps and compare field values
	    Stamps other = (Stamps) obj;
	    return this.category_A == other.category_A &&
	           this.category_B == other.category_B &&
	           this.category_C == other.category_C &&
	           this.category_D == other.category_D &&
	           this.category_E == other.category_E;
	}	
}