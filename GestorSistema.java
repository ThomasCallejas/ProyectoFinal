
package co.edu.tdea.proyectosegurcol;

class GestorSistema {

    private Usuario[] usuarios;
    private Producto[] productos;
    private int usuarioCount;
    private int productoCount;

    public GestorSistema() {
        this.usuarios = new Usuario[100]; 
        this.productos = new Producto[100]; 
        this.usuarioCount = 0;
        this.productoCount = 0;
    }

    public String userRegister(String nombre, String email) {
        if (nombre == null || nombre.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            return "Nombre o email no pueden estar vacíos.";
        }
        if (usuarioCount >= usuarios.length) {
            return "No se pueden registrar más usuarios.";
        }
        Usuario nuevoUsuario = new Usuario(nombre, email);
        this.usuarios[usuarioCount] = nuevoUsuario;
        usuarioCount++;
        return "Usuario " + nombre + " registrado exitosamente.";
    }

    public String singIn(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "Email no puede estar vacío.";
        }
        for (int i = 0; i < usuarioCount; i++) {
            if (usuarios[i].getEmail().equals(email)) {
                return "Bienvenido " + usuarios[i].getNombre() + "!";
            }
        }
        return "Usuario no encontrado.";
    }

    public String addProduct(String nombre, double precio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre del producto no puede estar vacío.";
        }
        if (precio <= 0) {
            return "El precio debe ser mayor que 0.";
        }
        if (productoCount >= productos.length) {
            return "No se pueden agregar más productos.";
        }
        Producto nuevoProducto = new Producto(nombre, precio);
        this.productos[productoCount] = nuevoProducto;
        productoCount++;
        return "Producto " + nombre + " agregado al catálogo.";
    }

    public String searchProduct(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre del producto no puede estar vacío.";
        }
        for (int i = 0; i < productoCount; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                return "Producto encontrado: " + productos[i].getNombre() + " - Precio: $" + productos[i].getPrecio();
            }
        }
        return "Producto no encontrado.";
    }

    public String makePurchase(String nombreProducto) {
        if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
            return "El nombre del producto no puede estar vacío.";
        }
        for (int i = 0; i < productoCount; i++) {
            if (productos[i].getNombre().equals(nombreProducto)) {
                return "Compra realizada: " + productos[i].getNombre() + " - Precio: $" + productos[i].getPrecio();
            }
        }
        return "Producto no disponible.";
    }
}
