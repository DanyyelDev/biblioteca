package co.edu.unipiloto.patterns.payaraweb.model.socio;

import java.util.List;

public interface SocioDAO {
    public List<Socio> getAllSocios();
    public void updateSocio (Socio est);
    public void deleteSocio (Socio est);
    public void addSocio (Socio est);
    public Socio searchSocio(int id);

}
