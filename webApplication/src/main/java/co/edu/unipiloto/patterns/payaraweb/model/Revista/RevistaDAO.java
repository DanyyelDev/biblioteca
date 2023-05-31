/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.Revista;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface RevistaDAO {
  
    public List<Revista> getAllRevista();
    public void updateRevista (Revista est);
    public void deleteRevista (Revista est);
    public void addRevista (Revista est);
    public Revista searchRevista(int id);

}
