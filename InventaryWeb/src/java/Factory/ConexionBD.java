package Factory;

import java.sql.*;

public abstract class ConexionBD {
    protected String[] parametros;
    protected Connection conexion;
    abstract Connection open();
    
    public ResultSet consultaSQL(String consulta){
        Statement st;
        ResultSet rs = null;
        try{
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rs;
    }
    
    public boolean ejecutarSQL(String consulta){
        Statement st;
        boolean guardar = true;
        try{
            st = conexion.createStatement();
            st.executeUpdate(consulta);
        }catch(SQLException ex){
            guardar = false;
            ex.printStackTrace();
        }
        return guardar;
    }
    
    
    public boolean cerrarConexion(){
        boolean ok = true;
        try{
            conexion.close();
        }catch(SQLException ex){
            ok = false;
            ex.printStackTrace();
        }
        return ok;
    }
    
}
