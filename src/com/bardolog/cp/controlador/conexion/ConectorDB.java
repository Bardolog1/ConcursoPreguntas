package com.bardolog.cp.controlador.conexion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ConectorDB {

    // establezco la ruta del archivo de config y variables
    private static final String CONFIG_CONEXION = "src\\config\\ConfigConexion.properties";
    private static Connection con;
    private static String driver;
    private static String userDB;
    private static String passDB;
    private static String dataB;
    private static String zonaH;
    private static String ruta;
    private static String url;

    // metodo para conectar base de datos
    public Connection conectar() throws IOException {
        traerConfig();
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userDB, passDB);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar", "Error conexión", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return con;
    }

    //para cerrar conexion
    public void desconectar() throws SQLException {
        con.close();
    }

    public Connection getConnection() {
        return con;
    }

    //obtengo los valores de configuracion de la bd
    public void traerConfig() throws FileNotFoundException, IOException {
        var propiedades = new Properties();
        propiedades.load(new FileReader(CONFIG_CONEXION));
        driver = propiedades.getProperty("Driver");
        userDB = propiedades.getProperty("UserDB");
        passDB = propiedades.getProperty("PassDB");
        dataB = propiedades.getProperty("DataB", "concursopreguntas");
        zonaH = propiedades.getProperty("ZonaH");
        ruta = propiedades.getProperty("Ruta");
        url = ruta + dataB + zonaH;
    }

}
