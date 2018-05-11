/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author root
 */
public class Alumno {
  private String nombres;
  private int codigo_alumno;

    public Alumno() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getCodigo_alumno() {
        return codigo_alumno;
    }

    public void setCodigo_alumno(int codigo_alumno) {
        this.codigo_alumno = codigo_alumno;
    }
  
}
