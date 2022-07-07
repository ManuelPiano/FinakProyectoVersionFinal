package DAO;

import Factory.ConexionBD;
import Factory.FactoryConexionDB;
import Model.Categoria;
import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImplementar implements UsuarioDAO{
    
    ConexionBD conn;  //Crear el objeto tipo conexión.

    public UsuarioDaoImplementar() {
        //Definir a la base de datos que se conectará por defecto.
        //this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
    }

    @Override
    public ArrayList<Usuario> startSesion(String user, String clave) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_usuario WHERE BINARY correo = '").append(user);
        miSQL.append("' and clave = md5('").append(clave);
        miSQL.append("');");  
        System.out.println(miSQL);
        //ArrayList<Usuario> user = new ArrayList(); // crear el array de almacenamiento en cada fial los registros encontrados
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
        //Se crea el objeto ResultSet implementando el método (consultaSQL) creado para la consulta.
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Usuario usuario = new Usuario();
                //Asignar cada campo consultado al atributo en la clase.
                usuario.setId(resultadoSQL.getInt("id"));
                usuario.setNombre(resultadoSQL.getString("nombre"));
                usuario.setApellido(resultadoSQL.getString("apellido"));
                usuario.setCorreo(resultadoSQL.getString("correo"));
                usuario.setUsuario(resultadoSQL.getString("usuario"));
                usuario.setClave(resultadoSQL.getString("clave"));
                usuario.setTipo(resultadoSQL.getInt("tipo"));
                usuario.setEstado(resultadoSQL.getInt("estado"));
                usuario.setPregunta(resultadoSQL.getString("pregunta"));
                usuario.setRespuesta(resultadoSQL.getString("respuesta"));
                usuario.setFecha(resultadoSQL.getString("fecha_registro"));
                lista.add(usuario); //Agregar al array cada registro encontrado.
                
                /*lista.add(new Usuario(usuario.setId(resultadoSQL.getInt("id")),
                        usuario.setNombre(resultadoSQL.getString("nombre")),
                        usuario.setApellido(resultadoSQL.getString("apellido")),
                        usuario.setCorreo(resultadoSQL.getString("correo")),
                        usuario.setUsuario(resultadoSQL.getString("usuario")),
                        usuario.setClave(resultadoSQL.getString("clave")),
                        usuario.setTipo(resultadoSQL.getInt("tipo")),
                        usuario.setEstado(resultadoSQL.getInt("estado")),
                        usuario.setPregunta(resultadoSQL.getString("pregunta")),
                        usuario.setRespuesta(resultadoSQL.getString("respuesta")),
                        usuario.setFecharegistro(resultadoSQL.getString("fecha_registro"))));*/       
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return lista;
    }
    
    
    
    //Método creado para probar de inmediato el método startSesion()
    public static void main(String[] args){
        //UsuarioDaoImplementar p = new UsuarioDaoImplementar();  
        UsuarioDAO p = new UsuarioDaoImplementar();
        //p.sesion("chovi", "123");
        ArrayList<Usuario> user = new ArrayList();
        user = p.startSesion("manuel.gamez@itca.edu.sv", "12345");
        //Para obtener el tamaño de un arraylist. El tamaño esta dado en base
        //a la cantidad de filas o registros existentes en la BD.
        int size = user.size();
        //Buble for para recorrer un arrylist.
          for (int i = 0; i < user.size(); i++) {
              System.out.println(user.get(i).getUsuario() + "\t" + user.get(i).getClave() + "\t" + user.get(i).getCorreo() + "\t" + user.get(0).getNombre() + "\t" + 
                      user.get(0).getTipo());
              System.out.println("El valor máximo de i es: " + i);
            } 
      }
    
    
}
