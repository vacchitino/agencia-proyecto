package controlador;

import modelo.*;
import vista.VistaAgregarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEmpleado {
    private Empresa empresa;
    private VistaAgregarEmpleado vistaAgregarEmpleado;

    public ControladorEmpleado(Empresa empresa, VistaAgregarEmpleado vistaAgregarEmpleado) {
        this.empresa = empresa;
        this.vistaAgregarEmpleado = vistaAgregarEmpleado;
        inicializarEventos();
    }

    private void inicializarEventos() {
        vistaAgregarEmpleado.agregarListenerAgregarEmpleado(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String documento = vistaAgregarEmpleado.getDocumento();
                    String nombre = vistaAgregarEmpleado.getNombre();
                    double sueldoBruto = vistaAgregarEmpleado.getSueldoBruto();
                    String tipoEmpleado = vistaAgregarEmpleado.getTipoEmpleado();

                    if (tipoEmpleado.equals("Permanente")) {
                        int aniosAntiguedad = vistaAgregarEmpleado.getAniosAntiguedad();
                        String obraSocial = vistaAgregarEmpleado.getObraSocial();
                        Empleado empleado = new EmpleadoPermanente(documento, nombre, sueldoBruto, aniosAntiguedad, obraSocial);
                        empresa.agregarEmpleado(empleado);
                    } else {
                        int duracionContrato = vistaAgregarEmpleado.getDuracionHsContratado();
                        double montoXHora = vistaAgregarEmpleado.getMontoXHora();
                        Empleado empleado = new EmpleadoContratado(documento, nombre, sueldoBruto, duracionContrato, montoXHora);
                        empresa.agregarEmpleado(empleado);
                    }

                    vistaAgregarEmpleado.mostrarMensaje("Empleado agregado con éxito.");
                    vistaAgregarEmpleado.dispose(); // Cierra la ventana después de agregar el empleado

                } catch (NumberFormatException ex) {
                    vistaAgregarEmpleado.mostrarMensaje("Error: Verifique que todos los campos sean válidos.");
                }
            }
        });

        vistaAgregarEmpleado.agregarListenerVolverMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaAgregarEmpleado.dispose(); // Cierra la ventana sin agregar el empleado
            }
        });
    }
}
