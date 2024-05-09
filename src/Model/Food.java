/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Food {
    private String Name;
    private String Price;
    private byte[] Image;
    private String Type;
    public Food(){
        super();
    }
    public Food(String Name, String Price, byte [] Image, String Type){
        this.Name= Name;
        this.Price= Price;
        this.Image= Image;
        this.Type= Type;
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

    public String getType() {
        return Type;
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

    public void setType(String Type) {
        this.Type = Type;
    }
    
    
}
