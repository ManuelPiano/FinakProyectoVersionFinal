package DAO;

import Model.Usuario;
import java.util.ArrayList;

public interface UsuarioDAO {
    
    //Definir los métodos, como la clase en interface. Los métodos no se implementan 
    //aqui, los métodos son de tipo abstractos.
    public ArrayList<Usuario> startSesion(String user, String clave);
   
}
