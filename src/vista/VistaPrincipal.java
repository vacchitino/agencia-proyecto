package vista;
import javax.swing.*;

import java.awt.HeadlessException;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame{
	private JTextField campoDocumento;
	private JTextField campoNombre;
	private JTextField campoSueldoBruto;
	private JTextField campoAniosAntiguedad;
	private JTextField campoObraSocial;
	private JButton btnAgregarEmpleado;
	private JButton btnEliminarEmpleado;
	private JButton btnExisteEmpleado;
	private JButton btnEmpleadoMayorSueldo;
	private JTextArea areaResultado;
	
	
	public VistaPrincipal() {
		setTitle("Gestión de empleados");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		campoDocumento = new JTextField(15);
		campoNombre= new JTextField(15);
		campoSueldoBruto = new JTextField(15);
		campoAniosAntiguedad = new JTextField(15);
		campoObraSocial = new JTextField(15);
		btnAgregarEmpleado = new JButton("Agregar empleado");
		btnEliminarEmpleado = new JButton("Eliminar empleado");
		btnExisteEmpleado = new JButton("Comprobar la carga del empleado");
		btnEmpleadoMayorSueldo = new JButton("Mostrar el empleado con mayor sueldo");
		
		areaResultado = new JTextArea(10, 30);
		areaResultado.setEditable(false);
		
		panel.add(new JLabel("Documento:"));
		panel.add(campoDocumento);
		panel.add(new JLabel("Nombre:"));
		panel.add(campoNombre);
		panel.add(new JLabel("Sueldo Bruto:"));
		panel.add(campoSueldoBruto);
		panel.add(new JLabel("Años de antiguedad:"));
		panel.add(campoAniosAntiguedad);
		panel.add(new JLabel("Obra Social:"));
		panel.add(campoObraSocial);
		panel.add(btnAgregarEmpleado);
		panel.add(btnEliminarEmpleado);
		panel.add(btnExisteEmpleado);
		panel.add(btnEmpleadoMayorSueldo);
		panel.add(new JScrollPane());
		
		add(panel);
		
	}
	public String getDocumento() {
		return campoDocumento.getText();
	}
	public String getNombre() {
		return campoNombre.getText();
	}
	public double getSueldoBruto() {
		return Double.parseDouble(campoSueldoBruto.getText());
	}
	public double getAniosAntiguedad() {
		return Double.parseDouble(campoAniosAntiguedad.getText());
	}
	public String getObraSocial() {
		return campoObraSocial.getText();
	}
	public void agregarListenerAgregarEmpleado(ActionListener listener) {
		btnAgregarEmpleado.addActionListener(listener);
	}
	public void agregarListenerEliminarEmpleado(ActionListener listener) {
		btnEliminarEmpleado.addActionListener(listener);
	}
	public void agregarListenerEmpleadoMayorSueldo(ActionListener listener) {
		btnEmpleadoMayorSueldo.addActionListener(listener);
	}
	public void mostrarResultado(String resultado) {
		areaResultado.setText(resultado);
	}
}
