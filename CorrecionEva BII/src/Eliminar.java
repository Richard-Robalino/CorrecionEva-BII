import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Eliminar extends JFrame {
    private JTextField txtcedula;
    private JButton btnEliminar;

    public Eliminar() {
        super("Eliminar");
        setLayout(new FlowLayout());

        JLabel lblcedula = new JLabel("Cedula:");
        add(lblcedula);

        txtcedula = new JTextField(20);
        add(txtcedula);

        btnEliminar = new JButton("Eliminar");
        add(btnEliminar);

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cedula = txtcedula.getText();

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_hospitalario", "root", "123456");
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate("DELETE FROM paciente WHERE cedula=" + cedula);

                    JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar datos");
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

        setSize(300, 150);
    }

    public static void main(String[] args) {
        Eliminar ventanaEliminar = new Eliminar();
        ventanaEliminar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaEliminar.pack();
        ventanaEliminar.setVisible(true);
    }
}
