/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.Revista;

/**
 *
 * @author USUARIO
 */
public class Revista {
    private int id;
    private String name;
    private String autor;
    private boolean state;
    private String editorial;
    private String edicion;
    private int tiempoDePrestamo;

    //Constructor

    public Revista() {
        this.id=0;
        this.name=" ";
        this.autor=" ";
        this.state=false;
        this.editorial="";
        this.edicion="";
        this.tiempoDePrestamo=0;
    }



    public Revista(int id, String name, String autor, boolean state, String editorial, String edicion, int tiempoDePrestamo) {
        this.id = id;
        this.name = name;
        this.autor = autor;
        this.state = true;
        this.editorial = editorial;
        this.edicion = edicion;
        this.tiempoDePrestamo = tiempoDePrestamo;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public int getTiempoDePrestamo() {
        return tiempoDePrestamo;
    }

    public void setEditorial(int tiempoDePrestamo) {
        this.tiempoDePrestamo = tiempoDePrestamo;
    }
    
    
}
