
package ec.gob.senagua.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class Coneccion {
 
    private Connection connnection;
    final String DRIVER = "org.postgresql.Driver";
    final String URL = "jdbc:postgresql://localhost:5433/mibase";
    final String USER = "postgres";
    final String PASSWORD = "alex";

    public void connect() {
        try {
            Class.forName(DRIVER);
            try {
                connnection = DriverManager.getConnection(URL, USER, PASSWORD);

            } catch (SQLException e) {
                System.out.println("Error when connecting database");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error when loading driver.");
        }
    }

    public ResultSet queryGet(String sql) throws ClassNotFoundException, SQLException {
        ResultSet result = null;

        try {
            connect();
            Statement stm = connnection.createStatement();
            result = stm.executeQuery(sql);
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnect();
        }
        return result;
    }

    public ResultSet queryGet(String sql, List<Parametro> list) throws Exception {
        ResultSet result = null;
        try {
            connect();
            PreparedStatement statement = connnection.prepareStatement(sql);
            for (Parametro par : list) {
                if (par.getValor() instanceof java.util.Date) {
                    statement.setObject(par.getPosicion(),
                            new java.sql.Date(((java.util.Date) par.getValor()).getTime()));
                } else {
                    statement.setObject(par.getPosicion(), par.getValor());
                }
            }
            result = statement.executeQuery();
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnect();
        }
        return result;
    }

    public int querySet(String sql) throws Exception {
        int affected = 0;
        try {
            connect();
            Statement stm = connnection.createStatement();
            if (stm.executeUpdate(sql) > 0) {
                affected = 1;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            disconnect();
        }
        return affected;
    }

    public int querySet(String sql, List<Parametro> lst) throws Exception {
        int affected = 0;
        try {
            connect();
            PreparedStatement statement = connnection.prepareStatement(sql);
            for (Parametro prm : lst) {
                if (prm.getValor() instanceof java.util.Date) {
//                    java.sql.Date fechaBD;
//                    java.util.Date fechaOriginal = (java.util.Date) prm.getValor();
//                    fechaBD = new java.sql.Date(fechaOriginal.getTime());
//                    statement.setObject(prm.getPosicion(), fechaBD);
                    statement.setObject(prm.getPosicion(),
                            new java.sql.Date(((java.util.Date) prm.getValor()).getTime()));
                } else {
                    statement.setObject(prm.getPosicion(), prm.getValor());
                }
            }
            if (statement.executeUpdate() >= 0) {
                affected = 1;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            disconnect();
        }
        return affected;
    }

    public void disconnect() {
        if (connnection != null) {
            try {
                connnection.close();
            } catch (SQLException e) {
                System.err.println("Database cannot be disconnected.");
            }
        }
}
  
    
}
