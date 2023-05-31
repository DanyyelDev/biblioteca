package co.edu.unipiloto.patterns.payaraweb.model.solicitud;

import java.util.List;

public interface SolicitudDAO {
    public List<Solicitud> getAllSolicitud();//solicitudes pendientes
    public void updateSolicitud (Solicitud est);
    public void deleteSolicitud (Solicitud est);
    public void addSolicitud (Solicitud est);
    public Solicitud searchSolicitud(int id);
}
