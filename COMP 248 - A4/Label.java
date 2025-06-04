
public class Label {
	//------------------------------------------------------------------------------- // 
	//						         Attributes 			  		             	  //
	//------------------------------------------------------------------------------- // 
	private String type; //  {"Standard", "Small", "Oversize", "Express", "Fragile", "Confidential"};
	private int iD , day, month; 
	// ID is 8 digits starting with 98
	
	public Label() {
		
	} // Default Constructor // 
	
	public Label(String type, int id, int expD, int expM)
	{
		this.type = type; 
		this.iD = id;
		this.day = expD; 
		this.month = expM;
		if(expD >=  1 && expD <= 31)
		{
			this.day = expD;
		}
		else 
		{
			expD= 0; 
		}
		if(expM >= 1 && expM <= 12 )
		{
			this.month = expM;
		}
		else
		{
			expM = 0; 
		}
	} // END of Parameterized Constructor // 
	
	public Label(Label label) {
		this.type = label.type; 
		this.iD = label.iD;
		this.day = label.day; 
		this.month = label.month; 
	}
	
	//------------------------------------------------------------------------------- // 
	//						      These are the Getters    			             	  //
	//------------------------------------------------------------------------------- // 
	public int getUnitID() {
		return iD;
	} // END of Getter for unit ID // 
	
	public String getType() {
		return type;
	} // END of Getter for Parcel Type // 
	
	public int getExpiryDay() {
		return day;
	} // END of Getter for day // 
	
	public int getExpiryMonth() {
		return month;
	} // END of Getter for month // 
	//------------------------------------------------------------------------------- // 
	//					These are the Setters  -- Fitting There Constraints 		  //
	//------------------------------------------------------------------------------- // 
	public void setType(String type) {
		if(type != null) // Making sure the content of the String isn't anything but a word. 
		{
			this.type  = type; 
		}
		else
		{
			System.out.println("Invalid Value: This Type cannot be null");
		}
		
	}// END of Setter for String Type. // 
	
	public void setUnitID(int iD) {
		if(iD >= 98000000 && iD <= 98999999)
		{
			this.iD = iD; 
		}
		else
		{
			System.out.println("Invalid Value: Unit ID must be an 8-Digit number starting with 98");
		}
	}// END of Setter for iD //
	
	public void setExpiryDay(int day) {
		if(day >= 1 && day <= 31)
		{
			this.day = day;
		}
		else
		{
			this.day = 0;
		}
	}// END of Setter for day // 
	
	public void setExpiryMonth(int month) {
		if(month >= 1 && month <= 12)
		{
			this.month = month;
		}
		else
		{
			this.month = 0; 
		}
	}// END of Setter for Month // 
	
	//------------------------------------------------------------------------------- // 
	//					   toString Method and Equals Method                    	  //
	//------------------------------------------------------------------------------- //
		
	public String toString() {
		String formatDay;
		String formatMonth;
		if(day < 10)
		{
			formatDay = "0" + this.day ; 
		}
		else 
		{ 	
			formatDay = "" + this.day;
		}
		 
		if( month < 10)
		{
			formatMonth = "0" + this.month;
		}
		else
		{
			formatMonth = "" + this.month; 
		}
		if(month == 2 && day>28) //Forcing the month of febuaray and any date grater than 28 to be just 28. //
		{
			formatDay = "28";
			formatMonth = "0"+this.month;
		}
		if((month == 4 || month == 6 ||month == 9) && day >30) // When either April, June, Septmeber and greater than 30 days. // 
		{
			formatDay = "30";
			formatMonth = "0" + this.month;
		}
		if(month == 11 && day > 30) // When November //
		{
			formatDay = "30";
			formatMonth = ""+this.month; 
		}

		 return type + " ~ "  + iD  + " ~ "+ formatDay +  "/"  + formatMonth + ".";
				 
	} // End of toString Method //  
	
	
	public boolean equals(Object obj) {
	    // Check if the two objects are the same reference
	    if (this == obj) {
	        return true;
	    }

	    // Check if the passed object is null or of a different class
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    // Cast the object to a Label
	    Label other = (Label) obj;

	    // Compare each attribute for equality
	    return this.type.equals(other.type) &&
	           this.iD == other.iD &&
	           this.day == other.day &&
	           this.month == other.month;
	} // END of Equals Method // 

}
