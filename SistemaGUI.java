package co.edu.tdea.proyectosegurcol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SistemaGUI extends JFrame {

    private GestorSistema gestor;
    private JTextArea outputArea;

    public SistemaGUI() {
        gestor = new GestorSistema();  // Se instancia GestorSistema para manejar la lógica
        setTitle("SegurCol");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton userRegisterBtn = new JButton("Registrar Usuario");
        userRegisterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userRegister();
            }
        });

        JButton singInBtn = new JButton("Iniciar Sesión");
        singInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                singIn();
            }
        });

        JButton addProductBtn = new JButton("Agregar Producto");
        addProductBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        JButton searchProductBtn = new JButton("Buscar Producto");
        searchProductBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchProduct();
            }
        });

        JButton makePurchaseBtn = new JButton("Realizar Compra");
        makePurchaseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makePurchase();
            }
        });

        panel.add(userRegisterBtn);
        panel.add(singInBtn);
        panel.add(addProductBtn);
        panel.add(searchProductBtn);
        panel.add(makePurchaseBtn);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void userRegister() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del usuario:");
        String email = JOptionPane.showInputDialog(this, "Ingrese el email del usuario:");
        String resultado = gestor.userRegister(nombre, email);
        outputArea.append(resultado + "\n");
    }

    private void singIn() {
        String email = JOptionPane.showInputDialog(this, "Ingrese el email del usuario:");
        String resultado = gestor.singIn(email);
        outputArea.append(resultado + "\n");
    }

    private void addProduct() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto:");
        try {
            double precio = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese el precio del producto:"));
            String resultado = gestor.addProduct(nombre, precio);
            outputArea.append(resultado + "\n");
        } catch (NumberFormatException e) {
            outputArea.append("El precio debe ser un número válido.\n");
        }
    }

    private void searchProduct() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto:");
        String resultado = gestor.searchProduct(nombre);
        outputArea.append(resultado + "\n");
    }

    private void makePurchase() {
        String nombreProducto = JOptionPane.showInputDialog(this, "Ingrese el nombre del producto a comprar:");
        String resultado = gestor.makePurchase(nombreProducto);
        outputArea.append(resultado + "\n");
    }

    public static void main(String[] args) {
        SistemaGUI gui = new SistemaGUI();
        gui.setVisible(true);
    }
}
