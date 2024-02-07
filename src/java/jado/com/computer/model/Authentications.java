
package jado.com.computer.model;

public class Authentications {
    private String phone;
    private String name;
    private String email;
    private String role;
    private int id;
    private String passwords;
    
    
    public Authentications(String name,String email,String phone,String passwords){
        super();
        this.phone =phone;
        this.name =name;
        this.email =email;
        this.passwords =passwords;
        
    }
     public Authentications(int id,String name,String email,String phone){
        super();
        this.id =id;
        this.phone =phone;
        this.name =name;
        this.email =email;
        
    }
      public Authentications(int id,String name,String email,String phone,String passwords){
        super();
        this.id =id;
        this.phone =phone;
        this.name =name;
        this.email =email;
        this.passwords =passwords;
        
        
    }
       public Authentications(int id,String name,String email,String phone,String passwords,String role){
        super();
       this.id=id;
        this.phone =phone;
        this.name =name;
        this.email =email;
        this.passwords =passwords;
        this.role=role;
        
        
    }
       public Authentications(String name,String email,String phone){
        super();
        this.phone =phone;
        this.name =name;
        this.email =email;
       
        
    }
     public Authentications(String phone,String passwords){
        super();
        this.phone =phone;
        this.passwords =passwords;
        
    }
     public int getId(){
         return id; 
     }
     public void setId(int id){
         this.id = id;
     }
    public String getRole(){
        return this.role;
    }
    public void setRole(String role){
        this.role = role;
    }
   
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
     public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
     public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
     public String getPasswords(){
        return passwords;
    }
    public void setPasswords(String passwords){
        this.passwords=passwords;
    }
    
}
