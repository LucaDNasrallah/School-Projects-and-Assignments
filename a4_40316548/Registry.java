public class Registry {
    //------------------------------------------------------------------------------- // 
    //                               Attributes                                       //
    //------------------------------------------------------------------------------- // 
    Stamps stamps;       // A single Stamps object
    private Label[] labels;      // An array of Label objects

    //------------------------------------------------------------------------------- // 
    //                             Constructors                                       //
    //------------------------------------------------------------------------------- // 

    // Default Constructor
    public Registry() {
        this.stamps = new Stamps(); // Initialize default Stamps object // 
        this.labels = null;         // No labels initially // 
    }

    // Parameterized Constructor
    public Registry(Stamps stamps, Label[] labels) {
        this.stamps = new Stamps(stamps); // Preventing Privacy Leaks // 

        // Handle the labels array (deep copy if not null)
        if (labels != null) {
            this.labels = new Label[labels.length];
            for (int i = 0; i < labels.length; i++) {
                this.labels[i] = new Label(labels[i]); // Assuming Label has a copy constructor
            }
        } else {
            this.labels = null; // No labels provided
        }
    }
  //------------------------------------------------------------------------------- // 
  //                                 Methods		                                //
  //------------------------------------------------------------------------------- // 
    
    // Method seeing if the $ of two registry are the same. // 
    public boolean isTotalValueTrue(Registry registry) {
    	if(this.stamps.stampTotal() == registry.stamps.stampTotal())
    	{
    		return true;
    	}
    	else
    	{
    		return false; 
    	}
    	
    }
    
    // Method that is True if the number of each stamps in a registry is equal to the number of stamps in another registry. // 
    public boolean isStampDistributionEquals(Registry registry ) {
    	if(this.stamps.equals(registry.stamps))
    	{
    		return true; 
    	}
    	else 
    	{
    		return false; 
    	}
    }
    // Method that Return the total amount of $ of a registry. // 
    public int totalAmountOfShipments() {
    	return this.stamps.stampTotal();
    }
    
    // Method returning the number of labels inside of a registry. // 
    public int numberOfLabels() {
    	if (this.labels != null) {
    	    return this.labels.length;
    	} else {
    	    return 0;
    	}
    }
    public int addLabel(Label newLabel) {
        if (this.labels == null) {
            this.labels = new Label[1];
            this.labels[0] = new Label(newLabel); // Initialize the first label
        } else {
            Label[] newLabels = new Label[this.labels.length + 1]; // Create a new array with an additional slot
            for (int i = 0; i < this.labels.length; i++) { // Correct loop boundary
                newLabels[i] = this.labels[i]; // Copy existing labels
            }
            newLabels[this.labels.length] = new Label(newLabel); // Add the new label at the end
            this.labels = newLabels; // Update the labels array
        }
        return this.labels.length; // Return the updated length
    }

    
    public boolean removeLabel(int index) {
    	if(this.labels == null || index < 0 || index >= this.labels.length)
    	{
    		return false;  // Invalid index condition. // 
    	}
    	if(this.labels.length == 1)
    	{
    		this.labels = null; 
    	}
    	else
    	{
    		Label[] newLabels  = new Label[this.labels.length -1 ];
    		for(int i = 0 , j = 0; i < this.labels.length ; i++ )
    		{
    			if( i!= index)
    			{
    				newLabels[j++] = this.labels[i];
    			}
    		}
    		this.labels = newLabels; 
    	}
    	return true;  // Proving the Removal will have been Successful // 
    }
    public void updateExpiryDate(int index, int newDay, int newMonth) {
    	if(this.labels!=null && index >= 0 && index < this.labels.length)
    	{
    		this.labels[index].setExpiryDay(newDay);
    		this.labels[index].setExpiryMonth(newMonth);
    	}
    	else
    	{
    		System.out.println("Invalid label index"); 
    	}
    }
    public int addingStamps(int a , int b, int c, int d, int e) {
    	this.stamps.addStamps(a, b, c, d, e);
    	return this.stamps.stampTotal();
    }
    
    //------------------------------------------------------------------------------- // 
    //            Equals and ToString || Getting Stamp Breakdown	                  //
    //------------------------------------------------------------------------------- //     
    
    public boolean equals(Object obj) {
    	if( this == obj) return true;
    	if( obj == null || getClass() != obj.getClass()) return false;
    	Registry registry = (Registry) obj ;
    	return  this.stamps.stampTotal() == registry.stamps.stampTotal() && 
    			this.numberOfLabels() == registry.numberOfLabels(); 
    }
    
    public String toString() {
        // Start with the stamp details
        String result = "Stamp Details:\n" + this.stamps.toString();

        // Add the label details
        result += "\nLabel Details:\n";
        if (this.labels == null || this.labels.length == 0) 
        {
            result += "No Prepaid Labels.\n";
        } 
        else
        {
            for (int i = 0; i < this.labels.length; i++) 
            {
                result += this.labels[i].toString() + "\n";
            }
        }

        // Return the constructed string
        return result;
    }

    public String getStampBreakDown()
    {
    	return this.stamps.toString(); 
    }
}
    
  
