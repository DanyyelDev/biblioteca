package co.edu.unipiloto.patterns.payaraweb.model.socio;

public class Socio {

    private int id;
    private String name;
    private String email;
    private int phoneNumber;
    private TypeSocio typeSocio;

    //Constructor

    public Socio() {
        this.id=0;
        this.name=" ";
        this.email=" ";
        this.phoneNumber=0;
        this.typeSocio = TypeSocio.DEFAULT;
    }



    public Socio(int id, String name, String email, int phoneNumber, TypeSocio typeSocio) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.typeSocio = typeSocio;
    }


    //Metodos get y set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TypeSocio getTypeSocio() {
        return typeSocio;
    }

    public void setTypeSocio(TypeSocio typeSocio) {
        this.typeSocio = typeSocio;
    }

}
