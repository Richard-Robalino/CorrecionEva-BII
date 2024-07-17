import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Insertar extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEdad;
    private JButton btnInsertar;
    private JTextField txtcedula;
    private JTextField txthistorial;
    private JTextField txtdescripcion;
    private JTextField txttelefono;

    public Insertar() {
        super("Insertar");
        setLayout(new FlowLayout());

        JLabel lblNombre = new JLabel("Nombre:");
        add(lblNombre);

        txtNombre = new JTextField(20);
        add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        add(lblApellido);

        txtApellido = new JTextField(20);
        add(txtApellido);

        JLabel lblEdad = new JLabel("Edad:");
        add(lblEdad);

        txtEdad = new JTextField(20);
        add(txtEdad);

        JLabel lblcedula = new JLabel("Cedula:");
        add(lblcedula);

        txtcedula = new JTextField(20);
        add(txtcedula);

        JLabel lblhistorial = new JLabel("Numero Historial:");
        add(lblhistorial);

        txthistorial = new JTextField(20);
        add(txthistorial);

        JLabel lbldescripcion = new JLabel("Descripcion de enfermedad:");
        add(lbldescripcion);

        txtdescripcion = new JTextField(20);
        add(txtdescripcion);

        JLabel lbltelefono = new JLabel("Telefono:");
        add(lbltelefono);

        txttelefono = new JTextField(20);
        add(txttelefono);

        btnInsertar = new JButton("Insertar");
        add(btnInsertar);

        btnInsertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String cedula = txtcedula.getText();
                String descripcion = txtdescripcion.getText();
                int historial = Integer.parseInt(txthistorial.getText());
                String telefono = txttelefono.getText();

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_hospitalario", "root", "123456");
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate("INSERT INTO paciente (nombre, apellido, edad,cedula ,n_historial_clinico,descripcion_enfermedad,telefono) VALUES ('" + nombre + "', '" + apellido + "', " + edad + ", '" + cedula + "', " + historial + ", '" + descripcion + "', '" + telefono + "')");

                    JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al insertar datos");
                }
            }
        });

        JButton btnVolver = new JButton("Volver");
        add(btnVolver);

        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Seleccion ventanaSeleccion = new Seleccion();
                ventanaSeleccion.setVisible(true);
                dispose();
            }
        });
        setSize(300, 200);
    }

    public static void main(String[] args) {
        Insertar ventanaInsertar = new Insertar();
        ventanaInsertar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaInsertar.pack();
        ventanaInsertar.setVisible(true);
    }
}