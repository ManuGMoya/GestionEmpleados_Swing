package Clases;

import java.io.Serializable;

/**
 *
 * @author Manu
 */
public class Empleado implements Serializable, Comparable<Empleado> {

    private String nombre;
    private float sueldo;
    private String sexo;

    public Empleado(String nombre, float sueldo, String sexo) {

        this.nombre = nombre;
        this.sueldo = sueldo;
        this.sexo = sexo;

    }

    public Empleado() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int compareTo(Empleado t) { //ORDENACION SEGUN ENUNCIADO POR NOMBRE ASCENDENTE
        return nombre.compareTo(t.nombre);
    }

}
