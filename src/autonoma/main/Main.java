package autonoma.main;

import autonoma.models.*;
import autonoma.excepciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear Localización
        Localizacion localizacionHospital = new Localizacion(37.25157313140872, -121.94667417922749);

        // Crear Hospital
        Hospital hospital = new Hospital("Hospital San José St. Bonaventure", 
                                          "2425 Samaritan Dr, San Jose, CA 95124, Estados Unidos", 
                                          "+1 408-559-2011", 
                                          "logo.png", 
                                          LocalDate.of(1965, 1, 1), 
                                          1000000.0, 
                                          2000000.0, 
                                          localizacionHospital);

        // Crear Gerente
        Gerente gerente = new Gerente("Aaron Glassman", "84941564", 69, "Neurocirujano");
        hospital.setGerente(gerente);

        // Crear Empleados
        EmpleadoOperativo empleadoOperativo = new EmpleadoOperativo("Limpieza", 1500.0, "Carlos Ramírez", "1012345678", 30);
        EmpleadoSalud empleadoSalud = new EmpleadoSalud("Cardiología", 160, 3000.0, "María Gómez", "1023456789", 35);
        
        // Registrar empleados en el hospital
        hospital.registrarEmpleado(empleadoOperativo);
        hospital.registrarEmpleado(empleadoSalud);

        // Crear Pacientes
        Paciente paciente1 = new Paciente("Pedro López", "1034567890", 50, "pedro@example.com", "+1 408-123-4567", "saludable");
        Paciente paciente2 = new Paciente("Ana María", "1045678901", 40, "ana@example.com", "+1 408-765-4321", "saludable");

        // Registrar pacientes en el hospital
        hospital.registrarPaciente(paciente1);
        hospital.registrarPaciente(paciente2);

        // Crear Enfermedades
        Enfermedad enfermedad1 = new Enfermedad("Hipertensión", "Condición crónica en la que la presión arterial está elevada.");
        Enfermedad enfermedad2 = new Enfermedad("Diabetes", "Enfermedad crónica que afecta la forma en que el cuerpo metaboliza la glucosa.");
        
        // Agregar enfermedades a los pacientes
        paciente1.agregarEnfermedad(enfermedad1);
        paciente2.agregarEnfermedad(enfermedad2);

        // Crear Medicamentos
        MedicamentoGenerico medicamentoGenerico = new MedicamentoGenerico("Paracetamol", "Medicamento para el dolor", 500.0, 100);
        MedicamentoDeMarca medicamentoDeMarca = new MedicamentoDeMarca("Ibuprofeno", "Medicamento antiinflamatorio", 1000.0, 50, "MarcaX");

        // Registrar medicamentos en el hospital
        hospital.registrarMedicamento(medicamentoGenerico);
        hospital.registrarMedicamento(medicamentoDeMarca);

        // Crear Citas Médicas
        CitaMedica cita1 = new CitaMedica(LocalDate.of(2024, 10, 18), paciente1, empleadoSalud, 200.0);
        CitaMedica cita2 = new CitaMedica(LocalDate.of(2024, 10, 19), paciente2, empleadoSalud, 250.0);

        // Registrar citas médicas en el hospital
        hospital.registrarCita(cita1);
        hospital.registrarCita(cita2);

        // Proceso de nómina
        try {
            hospital.procesoNomina(); // Genera y almacena la nómina
        } catch (PresupuestoNegativoException e) {
            System.out.println("Error en el presupuesto: " + e.getMessage());
        }

        // Acción de curar a un paciente
        try {
            paciente1.curarse("Hipertensión", medicamentoGenerico);
            System.out.println("El paciente " + paciente1.getNombre() + " ha sido tratado de " + enfermedad1.getNombre());
        } catch (EnfermedadNoExisteException e) {
            System.out.println("Error al curar paciente: " + e.getMessage());
        }

        // Generar Reporte
        Reporte reporte = new Reporte();
        reporte.generarReporte(hospital);

        // Mostrar información del hospital y sus registros
        System.out.println("\nInformación del hospital: ");
        System.out.println("Nombre: " + hospital.getNombre());
        System.out.println("Dirección: " + hospital.getDireccion());
        System.out.println("Presupuesto: " + hospital.getPresupuesto());
        System.out.println("Estado: " + hospital.getEstado());

        System.out.println("\nLista de empleados: ");
        for (Empleado emp : hospital.getListaEmpleados()) {
            System.out.println(emp.getNombre() + " - " + emp.obtenerTipoPersona() + " - Salario: " + emp.calcularSalario());
        }

        System.out.println("\nLista de pacientes: ");
        for (Paciente paciente : hospital.getListaPacientes()) {
            System.out.println(paciente.getNombre() + " - Estado: " + paciente.getEstado());
        }

        System.out.println("\nLista de citas médicas: ");
        for (CitaMedica cita : hospital.getListaCitas()) {
            System.out.println("Fecha: " + cita.getFecha() + " - Paciente: " + cita.getPaciente().getNombre() + " - Médico: " + cita.getMedico().getNombre());
        }

        System.out.println("\nInventario de medicamentos: ");
        for (Medicamento med : hospital.getInventario().getListaMedicamentos()) {
            System.out.println(med.getNombre() + " - Precio: " + med.getPrecio());
        }
    }
}
