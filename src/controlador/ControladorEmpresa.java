package controlador;

import vista.VistaPrincipal;
import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

public class ControladorEmpresa {
    private VistaPrincipal vista;
    private Empresa empresa;

    public ControladorEmpresa(VistaPrincipal vista, Empresa empresa) {
        this.vista = vista;
        this.empresa = empresa;
        inicializarEventos();
    }

    private void inicializarEventos() {
        this.vista.agregarListenerAgregarEmpleado(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String documento = vista.getDocumento();
                    String nombre = vista.getNombre();
                    double sueldoBruto = vista.getSueldoBruto();
                    double aniosAntiguedad = vista.getAniosAntiguedad();
                    String obraSocial = vista.getObraSocial();

                    // SOLUCIÓN: Creamos un empleado PERMANENTE por defecto (o puedes agregar una opción en la vista)
                    Empleado empleado = new EmpleadoPermanente(documento, nombre, sueldoBruto, aniosAntiguedad, obraSocial);
                    
                    empresa.agregarEmpleado(empleado);
                    vista.mostrarResultado("Empleado agregado: " + empleado.getNombre());

                } catch (NumberFormatException ex) {
                    vista.mostrarResultado("Error: Ingrese un sueldo válido.");
                }
            }
        });

        this.vista.agregarListenerEliminarEmpleado(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String documento = vista.getDocumento();
                if (empresa.existeEmpleado(documento)) {
                    empresa.eliminarEmpleado(documento);
                    vista.mostrarResultado("Empleado eliminado: " + documento);
                } else {
                    vista.mostrarResultado("Empleado no encontrado.");
                }
            }
        });

        this.vista.agregarListenerEmpleadoMayorSueldo(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado = empresa.empleadoMayorSueldo();
                    vista.mostrarResultado("Empleado con mayor sueldo: " + empleado.getNombre() +
                            " - Sueldo Neto: " + empleado.calcularSueldoNeto()); // SOLUCIÓN: método ahora es público
                } catch (NoSuchElementException ex) {
                    vista.mostrarResultado("No hay empleados registrados.");
                }
            }
        });
    }
}
