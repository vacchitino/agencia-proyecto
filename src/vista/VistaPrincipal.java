package vista;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame{
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
		
		btnAgregarEmpleado = new JButton("Agregar empleado");
		btnAgregarEmpleado.setLayout(new GridLayout(2, 2, 5, 5));
		btnEliminarEmpleado = new JButton("Eliminar empleado");
		btnEliminarEmpleado.setLayout(new GridLayout(2, 2, 5, 5));
		btnExisteEmpleado = new JButton("Comprobar la carga del empleado");
		btnExisteEmpleado.setLayout(new GridLayout(2, 2, 5, 5));
		btnEmpleadoMayorSueldo = new JButton("Mostrar el empleado con mayor sueldo");
		btnEmpleadoMayorSueldo.setLayout(new GridLayout(2, 2, 5, 5));
		
		areaResultado = new JTextArea(10, 30);
		areaResultado.setEditable(false);
		
		panel.add(btnAgregarEmpleado);
		panel.add(btnEliminarEmpleado);
		panel.add(btnExisteEmpleado);
		panel.add(btnEmpleadoMayorSueldo);
		panel.add(new JScrollPane());
		
		add(panel);
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
