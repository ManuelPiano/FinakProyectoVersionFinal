package DAO;

import Model.Categoria;
import java.util.List;

public interface CategoriaDAO {
    //public int dato1 = 10;
    
    public List<Categoria> Listar();
    public List<Categoria> Listar2();
    public Categoria editarCat(int id_cat_edit);
    public boolean guardarCat(Categoria categoria);
    public boolean borrarCat(int id_cat_borrar);
    
    //public boolean metodo1();
    
}
