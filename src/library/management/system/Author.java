
package library.management.system;

public class Author extends Person{
    private String email,workplace;

    public Author() {
    }

    public Author(String email, String workplace, String identityNum, String name, String gender, String phone) {
        super(identityNum, name, gender, phone);
        this.email = email;
        this.workplace = workplace;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
    
    @Override
    public String toString(){
    
        return super.toString()+"\nEmail: "+email+"\nWorkplace"+workplace;
    }
}
