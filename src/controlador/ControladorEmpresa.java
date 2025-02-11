package controlador;

import vista.VistaAgregarEmpleado;
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
                //Crea una nueva instancia de la ventana agregar empleado
            	VistaAgregarEmpleado vistaAgregar = new VistaAgregarEmpleado();
                new ControladorEmpleado(empresa, vistaAgregar);
                vistaAgregar.setVisible(true);
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
