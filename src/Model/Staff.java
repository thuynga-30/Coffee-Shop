/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Staff {
	private String fname;
	private String phonenumber;
	private String password;
	private String repassword;
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(String fname, String phonenumber, String password, String repassword) {
		super();
		this.fname = fname;
		this.phonenumber = phonenumber;
		this.password = password;
		this.repassword = repassword;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
    
}
