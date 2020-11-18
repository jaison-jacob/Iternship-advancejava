package AdvanceJava;

public class data {

  private String name;
  private String password;  
  
  public data(){
	  
  }
  public data(String name,String password){
	  this.name = name;
	  this.password = password;
  }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
