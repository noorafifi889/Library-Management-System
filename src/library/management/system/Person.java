
package library.management.system;

public class Person {
    private  String identityNum,name,gender,phone;

    public Person() {
    }

    public Person(String identityNum, String name, String gender, String phone) {
        this.identityNum = identityNum;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString(){
    
        return "\nIdentityNum: "+identityNum+"\nName: "+name+"\nGender: "+gender+"\nPhone: "+phone;
    }
   
    
}
