
package DAO;
import Factory.ConexionBD;
import Factory.FactoryConexionDB;
import Model.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImplementar implements ProductoDAO{ 
    ConexionBD conn;
    public ProductoDAOImplementar(){   
    }
@Override
    public List<Producto> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT PROD.id_producto, PROD.nom_producto, PROD.stock, PROD.precio, PROD.unidad_de_medida, PROD.estado_producto, CAT.nom_categoria FROM tb_producto AS PROD INNER JOIN tb_categoria AS CAT ON PROD.categoria=CAT.id_categoria; ");
        List<Producto> lista = new ArrayList<Producto>();
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Producto producto = new Producto();
                producto.setId_producto(resultadoSQL.getInt("id_producto"));
                producto.setNom_producto(resultadoSQL.getString("nom_producto"));
                producto.setEstado(resultadoSQL.getInt("estado_producto"));
                producto.setPrecio(resultadoSQL.getFloat("precio"));
                producto.setStock(resultadoSQL.getFloat("stock"));
                producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
                producto.setCatogoria_nom(resultadoSQL.getString("nom_categoria"));
                lista.add(producto);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            this.conn.cerrarConexion();
        }
        
        return lista;
    }

    @Override
    public Producto editarPro(int id_pro_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Producto producto = new Producto();
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("select * from tb_producto where id_producto = ").append(id_pro_edit);
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                producto.setId_producto(resultadoSQL.getInt("id_producto"));
                producto.setNom_producto(resultadoSQL.getString("nom_producto"));
                producto.setEstado(resultadoSQL.getInt("estado_producto"));
                producto.setPrecio(resultadoSQL.getFloat("precio"));
                producto.setStock(resultadoSQL.getFloat("stock"));
                producto.setUnidadMedida(resultadoSQL.getString("medida"));
            }
            
        }catch(SQLException e){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return producto;
    }    

    

    @Override
    public boolean borrarPro(int id_pro_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borra = false;
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("Delete from tb_producto where id_producto = ").append(id_pro_borrar);
            this.conn.ejecutarSQL(miSQL.toString());
            borra = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return borra;    }

    @Override
    public List<Producto> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean guardarPro(Producto producto) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false;
        
        try{
            if(producto.getId_producto()== 0){
                System.out.println("Guardar");
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("INSERT INTO tb_producto(nom_producto, estado_producto, precio, stock, unidad_de_medida, categoria) values('");
                miSQL.append(producto.getNom_producto()+ "', ").append(producto.getEstado());
                miSQL.append(", ").append(producto.getPrecio());
                miSQL.append(", ").append(producto.getStock());
                miSQL.append(", '").append(producto.getUnidadMedida());
                miSQL.append("', '").append(producto.getCatogoria_id());


                miSQL.append("');");
                this.conn.ejecutarSQL(miSQL.toString());
            }else if(producto.getId_producto()> 0){
                
                //System.out.println("Update");
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_producto SET id_producto = ").append(producto.getId_producto());
                miSQL.append(", nom_producto = '").append(producto.getNom_producto());
                miSQL.append("', estado_producto = ").append(producto.getEstado());
                miSQL.append("', precio = ").append(producto.getPrecio());
                miSQL.append("', stock = ").append(producto.getStock());
                miSQL.append("', unidad_de_medida = ").append(producto.getUnidadMedida());
                miSQL.append(" WHERE id_producto = ").append(producto.getId_producto()).append(";");
                this.conn.ejecutarSQL(miSQL.toString());
            }
           guarda = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();
        }
        
        return guarda;
    }
   
    }