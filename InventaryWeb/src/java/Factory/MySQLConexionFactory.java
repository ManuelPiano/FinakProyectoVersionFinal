package Factory;

import java.sql.Connection;
import java.sql.DriverManager;


public final class MySQLConexionFactory extends ConexionBD{

    public MySQLConexionFactory(String[] criterios) {
        this.parametros = criterios;
        this.open();
    }

    
    
    @Override
    Connection open() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.parametros[0], this.parametros[1], this.parametros[2]);
            System.out.println("Conexion ok");
        }catch(Exception ex){
            System.out.println("Conexion no ok");
            ex.printStackTrace();
        }
        return this.conexion;
    }
    
}
