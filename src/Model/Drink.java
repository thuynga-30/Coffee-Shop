package Model;

public class Drink {
	
	
	    private String Name;
	    private String Price;
	    private byte[] Image;
	    public Drink(){
	        super();
	    }
	    public Drink(String Name, String Price, byte [] Image){
	        this.Name= Name;
	        this.Price= Price;
	        this.Image= Image;
	    }

	    public String getName() {
	        return Name;
	    }

	    public String getPrice() {
	        return Price;
	    }

	    public byte[] getImage() {
	        return Image;
	    }

	    

	    public void setName(String Name) {
	        this.Name = Name;
	    }

	    public void setPrice(String Price) {
	        this.Price = Price;
	    }

	    public void setImage(byte[] Image) {
	        this.Image = Image;
	    }

	    
	    
	    
	}


