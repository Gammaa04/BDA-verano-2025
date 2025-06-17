package Interfaz;

import Fachada.IFinanzasGlobalesFachada;
import Negocio.IFinanzasGlobalesFachada;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private IFinanzasGlobalesFachada fachada;

    public LoginFrame() {
        // Inicializar fachada (simplificado, en producción usa inyección de dependencias)
        fachada = new IFinanzasGlobalesFachada(
            new Negocio.EmpleadoServicio(new Persistencia.EmpleadoDAO(new Persistencia.ConexionBD))),
            new Negocio.DepartamentoServicio(new Persistencia.DepartamentoDAO(new Persistencia.ConexionBDImpl())),
            // Otros servicios
            new Negocio.PrestamoService(
                new Persistencia.PrestamoDAO(new Persistencia.ConexionBD()),
                new Persistencia.HistorialEstatusPrestamoDAO(new Persistencia.ConexionBD()),
                new Persistencia.EmpleadoDAO(new Persistencia.ConexionBD()),
                new Persistencia.JefeDAO(new Persistencia.ConexionBD()),
                new Persistencia.ConexionBD()
            )
        );

        // Configuración de la ventana
        setTitle("Inicio Sesión - Finanzas Globales");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Etiquetas y campos
        JLabel usernameLabel = new JLabel("Usuario:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Iniciar sesión");

        // Agregar componentes al panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Espacio vacío
        panel.add(loginButton);

        // Acción del botón
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    if (fachada.autenticarUsuario(username, password)) {
                        JOptionPane.showMessageDialog(LoginFrame.this, "Inicio de sesión exitoso!");
                        // Abrir la pantalla principal (pendiente de implementación)
                        dispose(); // Cierra la ventana de login
                        new MainFrame().setVisible(true); // Ejemplo de transición
                    } else {
                        JOptionPane.showMessageDialog(LoginFrame.this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Error al iniciar sesión: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Añadir panel a la ventana
        add(panel);
    }

    // Clase de ejemplo para la pantalla principal (pendiente de implementación completa)
    private class MainFrame extends JFrame {
        public MainFrame() {
            setTitle("Pantalla Principal - Finanzas Globales");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            add(new JLabel("Bienvenido a Finanzas Globales", SwingConstants.CENTER));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
