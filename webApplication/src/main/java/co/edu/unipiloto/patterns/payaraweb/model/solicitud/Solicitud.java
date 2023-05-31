/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.solicitud;

/**
 *
 * @author USUARIO
 */
public class Solicitud {
    private int id;
    private String nombreDelObjeto;
    private TypeSolicitud typeSolicitud;
    private String state;


    //Constructor
    public Solicitud() {
        this.id=0;
        this.nombreDelObjeto=" ";
        this.typeSolicitud= null;
        this.state="";
    }

    public Solicitud(int id, String nombreDelObjeto, TypeSolicitud typeSolicitud, String state) {
        this.id = id;
        this.nombreDelObjeto = nombreDelObjeto;
        this.typeSolicitud = typeSolicitud;
        this.state = state;
    }

    //Metodos get y set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDelObjeto() {
        return nombreDelObjeto;
    }

    public void setNombreDelObjeto(String nombre) {
        this.nombreDelObjeto = nombre;
    }

    public TypeSolicitud getTypeSolicitud() {
        return typeSolicitud;
    }

    public void setTypeSolicitud(TypeSolicitud typeSolicitud) {
        this.typeSolicitud = typeSolicitud;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
}
