package Model;


public class Producto {
    private int id_producto;
    private String nom_producto;
    private int catogoria_id;
    private double stock;
    private double precio;
    private String unidadMedida;
    private int estado;
    private Categoria categoria;
    private String catogoria_nom;

    public Producto() {
        this.id_producto = 0;
        this.nom_producto = "";
        this.estado = 0;
        this.precio = 0;
        this.stock = 0;
        this.unidadMedida = "";
        this.catogoria_nom = "";
        this.categoria = new Categoria();
    }

    public Producto(int id_producto, String nom_producto, int catogoria_id, double stock, double precio, String unidadMedida, String categorianom, int estado, Categoria categoria) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.catogoria_id = catogoria_id;
        this.stock = stock;
        this.precio = precio;
        this.unidadMedida = unidadMedida;
        this.estado = estado;
        this.categoria = categoria;
        this.catogoria_nom = categorianom;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public int getCatogoria_id() {
        return catogoria_id;
    }

    public void setCatogoria_id(int catogoria_id) {
        this.catogoria_id = catogoria_id;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCatogoria_nom() {
        return catogoria_nom;
    }

    public void setCatogoria_nom(String catogoria_nom) {
        this.catogoria_nom = catogoria_nom;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    
    
}
