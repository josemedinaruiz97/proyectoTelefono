package com.example.a2damm.proyectotelefono.modelo.pojo;

/**
 * Created by 2damm on 24/1/18.
 */

public class Llamada {
    private String fecha;
    private String numero;
    private String estado;

    public Llamada(String fecha, String numero, String estado) {
        this.fecha = fecha;
        this.numero = numero;
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Llamada{" +
                "fecha='" + fecha + '\'' +
                ", numero='" + numero + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
