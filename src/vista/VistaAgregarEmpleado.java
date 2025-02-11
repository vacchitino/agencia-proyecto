package vista;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class VistaAgregarEmpleado extends JFrame{
	private JComboBox<String> comboTipoEmpleado; //Multiple choice para elegir el tipo de empleado
	private JPanel panelPermanente, panelContratado;
	private JTextField campoDocumento;
	private JTextField campoNombre;
	private JTextField campoSueldoBruto;
	private JTextField campoAniosAntiguedad;
	private JTextField campoObraSocial;
	private JTextField campoDuracionHsContrato;
	private JTextField campoMontoXHora;
	private JButton btnAgregar, btnVolverMenu;
	
	public VistaAgregarEmpleado() {
        setTitle("Agregar Empleado");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Campos comunes
        campoDocumento = new JTextField(15);
        campoNombre = new JTextField(15);
        campoSueldoBruto = new JTextField(15);

        // ComboBox para seleccionar el tipo de empleado
        String[] tiposEmpleado = { "Permanente", "Contratado" };
        comboTipoEmpleado = new JComboBox<>(tiposEmpleado);
        
        //Panel para Empleado Permanente
        panelPermanente = new JPanel();
        panelPermanente.setLayout(new GridLayout(2, 2, 5, 5));
        campoAniosAntiguedad = new JTextField(5);
        campoObraSocial = new JTextField(10);
        panelPermanente.add(new JLabel("Años de Antigüedad:"));
        panelPermanente.add(campoAniosAntiguedad);
        panelPermanente.add(new JLabel("Obra Social:"));
        panelPermanente.add(campoObraSocial);

        //Panel para Empleado Contratado
        panelContratado = new JPanel();
        panelContratado.setLayout(new GridLayout(2, 2, 5, 5));
        campoDuracionHsContrato = new JTextField(5);
        campoMontoXHora = new JTextField(10);
        panelContratado.add(new JLabel("Duración del Contrato (Horas):"));
        panelContratado.add(campoDuracionHsContrato);
        panelContratado.add(new JLabel("Monto por Hora ($):"));
        panelContratado.add(campoMontoXHora);
        
        //Botones
        btnAgregar = new JButton("Agregar Empleado");
        btnVolverMenu = new JButton("Volver al Menú");

        //Agregar componentes al panel principal
        panel.add(new JLabel("Tipo de Empleado:"));
        panel.add(comboTipoEmpleado);
        panel.add(new JLabel("Documento:"));
        panel.add(campoDocumento);
        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(new JLabel("Sueldo Bruto:"));
        panel.add(campoSueldoBruto);
        panel.add(panelPermanente);
        panel.add(panelContratado);
        panel.add(btnAgregar);
        panel.add(btnVolverMenu);
		panelContratado.setVisible(false);//Ocultar panel contratado por defecto
		
		comboTipoEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esPermanente = comboTipoEmpleado.getSelectedItem().equals("Permanente");
				panelPermanente.setVisible(esPermanente);
				panelContratado.setVisible(!esPermanente);
				revalidate();
				repaint();
				
				//agregar documento, n ombre y sueldo bruto
			}
		});
		add(panel);
		setVisible(true);
		
	}
	
	public String getDocumento() {
		return campoDocumento.getText();
	}
	public String getNombre() {
		return campoNombre.getText();
	}
	public double getSueldoBruto() {
		return Double.parseDouble(campoDocumento.getText());
	}
	public int getAniosAntiguedad() {
		return Integer.parseInt(campoAniosAntiguedad.getText());
	}
	public String getObraSocial() {
		return campoObraSocial.getText();
	}
	public int getDuracionHsContratado() {
		return Integer.parseInt(campoDuracionHsContrato.getText());
	}
	public double getMontoXHora() {
		return Double.parseDouble(campoMontoXHora.getText());
	}
	public String getTipoEmpleado() {
		return (String) comboTipoEmpleado.getSelectedItem();
	}
	
	public void agregarListenerAgregarEmpleado(ActionListener listener) {
		btnAgregar.addActionListener(listener);
	}
	public void agregarListenerVolverMenu(ActionListener listener) {
		btnVolverMenu.addActionListener(listener);
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
