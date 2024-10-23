package autonoma.main;

import autonoma.models.*;
import autonoma.excepciones.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        int opcion;
        do {
            System.out.println("\n===== MENÚ HOSPITAL =====");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Agregar Paciente");
            System.out.println("3. Registrar Cita Médica");
            System.out.println("4. Consultar Información del Hospital");
            System.out.println("5. Mostrar Lista de Empleados");
            System.out.println("6. Mostrar Lista de Pacientes");
            System.out.println("7. Mostrar Lista de Citas Médicas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarEmpleado(hospital, scanner);
                    break;
                case 2:
                    agregarPaciente(hospital, scanner);
                    break;
                case 3:
                    registrarCitaMedica(hospital, scanner);
                    break;
                case 4:
                    consultarInformacionHospital(hospital);
                    break;
                case 5:
                    mostrarEmpleados(hospital);
                    break;
                case 6:
                    mostrarPacientes(hospital);
                    break;
                case 7:
                    mostrarCitasMedicas(hospital);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 8);

        scanner.close();
    }

    // Método para agregar un empleado
    private static void agregarEmpleado(Hospital hospital, Scanner scanner) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del empleado: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese la edad del empleado: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = scanner.nextLine();

        EmpleadoOperativo nuevoEmpleado = new EmpleadoOperativo(departamento, salario, nombre, cedula, edad);
        hospital.agregarEmpleado(nuevoEmpleado);

        System.out.println("Empleado agregado exitosamente.");
    }

    // Método para agregar un paciente
    private static void agregarPaciente(Hospital hospital, Scanner scanner) {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del paciente: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el correo del paciente: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el teléfono del paciente: ");
        String telefono = scanner.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre, cedula, edad, correo, telefono);
        hospital.agregarPaciente(nuevoPaciente);

        System.out.println("Paciente agregado exitosamente.");
    }

    // Método para registrar una cita médica
    private static void registrarCitaMedica(Hospital hospital, Scanner scanner) {
        System.out.print("Ingrese la cédula del paciente: ");
        String cedulaPaciente = scanner.nextLine();
        Paciente paciente = hospital.buscarPacientePorCedula(cedulaPaciente);
        
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.print("Ingrese la cédula del médico: ");
        String cedulaMedico = scanner.nextLine();
        EmpleadoSalud medico = (EmpleadoSalud) hospital.buscarEmpleadoPorCedula(cedulaMedico);
        
        if (medico == null) {
            System.out.println("Médico no encontrado.");
            return;
        }

        System.out.print("Ingrese la fecha de la cita (YYYY-MM-DD): ");
        String fechaCita = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaCita);

        System.out.print("Ingrese el costo de la cita: ");
        double costo = scanner.nextDouble();

        CitaMedica nuevaCita = new CitaMedica(paciente, medico, fecha, costo);
        hospital.registrarCita(nuevaCita);

        System.out.println("Cita médica registrada exitosamente.");
    }

    // Método para consultar la información del hospital
    private static void consultarInformacionHospital(Hospital hospital) {
        System.out.println("\n===== INFORMACIÓN DEL HOSPITAL =====");
        System.out.println("Nombre: " + hospital.getNombre());
        System.out.println("Dirección: " + hospital.getDireccion());
        System.out.println("Presupuesto: " + hospital.getPresupuesto());
        System.out.println("Estado: " + hospital.getEstado());
    }

    // Método para mostrar la lista de empleados
    private static void mostrarEmpleados(Hospital hospital) {
        System.out.println("\n===== LISTA DE EMPLEADOS =====");
        for (Empleado empleado : hospital.obtenerEmpleados()) {
            System.out.println(empleado.getNombre() + " - " + empleado.obtenerTipoPersona() + " - Salario: " + empleado.calcularSalario());
        }
    }

    // Método para mostrar la lista de pacientes
    private static void mostrarPacientes(Hospital hospital) {
        System.out.println("\n===== LISTA DE PACIENTES =====");
        for (Paciente paciente : hospital.obtenerPacientes()) {
            System.out.println(paciente.getNombre() + " - Estado: " + paciente.getEstado());
        }
    }

    // Método para mostrar la lista de citas médicas
    private static void mostrarCitasMedicas(Hospital hospital) {
        System.out.println("\n===== LISTA DE CITAS MÉDICAS =====");
        for (CitaMedica cita : hospital.obtenerCitas()) {
            System.out.println("Fecha: " + cita.getFecha() + " - Paciente: " + cita.getPaciente().getNombre() + " - Médico: " + cita.getMedico().getNombre());
        }
    }
}
