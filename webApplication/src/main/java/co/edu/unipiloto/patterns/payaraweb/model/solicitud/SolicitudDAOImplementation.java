/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.patterns.payaraweb.model.solicitud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class SolicitudDAOImplementation implements SolicitudDAO {

    //Atributos
    private String driver;
    private String url;
    private String user;
    private String password;
    private String sentencia;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;
    private Solicitud est;

    //Constructor
    public SolicitudDAOImplementation() {
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/biblioteca";
        user = "root";
        password = "root";
        sentencia = "";
        connection = null;
        statement = null;
        rs = null;
    }

    //Metodos 
    protected void conectar() {
        try {
            //Cargar los controladores para el acceso a la BD
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error 1-" + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("Error 2-" + sqle.getMessage());
        }
    }

    public void desconectar(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Solicitud> getAllSolicitud() {
        if (connection == null) {
            conectar();
        }
        List<Solicitud> lista = new ArrayList();

        sentencia = "SELECT * FROM SOLICITUDES  WHERE STATE=\" + PRESTADO + \"";
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sentencia);
            System.out.println("consulta ok");
            if (rs == null) {
                System.out.println("!No se encontraron socios!");
            }
            System.out.println(rs.first() + " " + rs.getRow() + " " + rs.getCursorName());
            do {

                int id = rs.getInt(1);

                String nombreDelObjeto = rs.getString(2);

                TypeSolicitud typeSolicitud = TypeSolicitud.valueOf(rs.getString(3));

                String state = rs.getString(4);

                //Convierte el result set a un Array List
                lista.add(new Solicitud(id, nombreDelObjeto, typeSolicitud, state));
                System.out.println(id + "\t\t" + nombreDelObjeto+ "\t\t" + typeSolicitud + "\t\t" + state);
            } while (rs.next());

        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }

        return lista;

    }

    @Override
    public void updateSolicitud(Solicitud est) {
        if (connection == null) {
            conectar();
        }
        try {
            sentencia = "UPDATE SOLICITUDES SET "
                    + "NAMEOBJETO = '" + est.getNombreDelObjeto() + "',"
                    + "TYPESOLICITUD = '" + est.getTypeSolicitud() + "',"
                    + "STATE =" + est.getState() + ""
                    + " WHERE ID = " + est.getId();
           
            System.out.println("Sentencia " + sentencia);
            //Crear una sentencia
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            statement.executeUpdate(sentencia);
        } catch (SQLException sqle) {
            System.out.println("Error en " + sqle.getSQLState());
        }
    }

    @Override
    public void deleteSolicitud(Solicitud est) {
        if (connection == null) {
            conectar();
        }
    }

    @Override
    public void addSolicitud(Solicitud est) {
        if (connection == null) {
            conectar();
        }
        System.out.println("Guardar estudiante");

        try {
            sentencia = "INSERT INTO SOLICITUDES VALUES("
                    + est.getId() + ",'"
                    + est.getNombreDelObjeto() + "','"
                    + est.getTypeSolicitud() + "',"
                    + est.getState() + ""
                    + ")";

            System.out.println("Sentencia " + sentencia);
            //Crear una sentencia
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            statement.executeUpdate(sentencia);
        } catch (SQLException sqle) {
            System.out.println("Error en " + sqle.getSQLState());
        }

    }

    @Override
    public Solicitud searchSolicitud(int idBuscar) {
        Solicitud est = null;
        if (connection == null) {
            conectar();
        }
        sentencia = "SELECT * FROM SOLICITUDES WHERE ID=" + idBuscar + "";
        System.out.println("Sentencia: " + sentencia);
        try {

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sentencia);
            //no devuelve un resultado
            if (rs == null) {
                System.out.println("EL id: "+idBuscar+" no es un socio de la biblioteca");
            }
            //Se coloca en la primer posicion del result set
            rs.first();
            //Extrae los datos de cada fila del result set
            int id = rs.getInt(1);

            String nombreDelObjeto = rs.getString(2);

            TypeSolicitud typeSolicitud = TypeSolicitud.valueOf(rs.getString(3));

            String state = rs.getString(4);

            est = new Solicitud(id, nombreDelObjeto, typeSolicitud, state);
            System.out.println(id + "\t\t" + nombreDelObjeto + "\t\t" + typeSolicitud + "\t\t" + state );
        } catch (SQLException sqle) {
            System.out.println("Excepcion " + sqle.getSQLState());
        }

        return est;

    }

}
