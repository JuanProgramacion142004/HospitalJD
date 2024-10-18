package autonoma.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Juan David Arcila
 * @fecha 10/18/2024
 * @version 1.0.0
 */
public class Reporte {

    // ATRIBUTOS
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;

    // METODOS DE ACCESO
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    // MÉTODOS
    public Reporte(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void guardarEnArchivo(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("***** Reporte *****\n");
            writer.write("Título: " + titulo + "\n");
            writer.write("Fecha de creación: " + fechaCreacion + "\n");
            writer.write("*************************\n\n");
            writer.write(contenido + "\n");
            writer.write("*************************\n");
            writer.write("Fin del reporte.\n");
            System.out.println("Reporte guardado exitosamente en: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el reporte: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Reporte [Título: " + titulo + ", Fecha: " + fechaCreacion + "]";
    }
}
