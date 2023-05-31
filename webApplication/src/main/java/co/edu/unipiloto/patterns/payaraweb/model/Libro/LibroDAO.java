/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.Libro;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface LibroDAO {
  
    public List<Libro> getAllLibro();
    public void updateLibro (Libro est);
    public void deleteLibro (Libro est);
    public void addLibro (Libro est);
    public Libro searchLibro(int id);

}
