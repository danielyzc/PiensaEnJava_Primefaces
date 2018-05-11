/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import clases.Alumno;
import clases.Alumno_Curso;
import clases.Curso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class ManagedBeanDatos implements Serializable {

    private List<Curso> cursos;
    private List<Alumno> alumnos;
    private List<Alumno_Curso> detalles;

    public ManagedBeanDatos() {
        cursos = new LinkedList<>();
        alumnos = new LinkedList<>();
        detalles = new LinkedList<>();
    }

    public void llenar_datos() {

        cursos = new LinkedList<>();
        alumnos = new LinkedList<>();
        detalles = new LinkedList<>();

        Curso curso01 = new Curso();
        curso01.setNombre("Fundamentos de la Programacion");
        curso01.setNumero_creditos(5);

        Curso curso02 = new Curso();
        curso02.setNombre("Curso Primefaces");
        curso02.setNumero_creditos(3);

        Curso curso03 = new Curso();
        curso03.setNombre("Curso Base Datos MYSQL");
        curso03.setNumero_creditos(4);

        cursos.add(curso01);
        cursos.add(curso02);
        cursos.add(curso03);

        Alumno alumno01 = new Alumno();
        alumno01.setNombres("DANIEL");
        alumno01.setCodigo_alumno(100);

        Alumno alumno02 = new Alumno();
        alumno02.setNombres("JUAN");
        alumno02.setCodigo_alumno(101);

        Alumno alumno03 = new Alumno();
        alumno03.setNombres("DIANA");
        alumno03.setCodigo_alumno(102);

        alumnos.add(alumno01);
        alumnos.add(alumno02);
        alumnos.add(alumno03);

        Alumno_Curso detalle = new Alumno_Curso();
        detalle.setAlumno(alumno01);
        detalle.setCurso(curso01);
        detalle.setFecha_registro(new Date());

        Alumno_Curso detalle02 = new Alumno_Curso();
        detalle02.setAlumno(alumno01);
        detalle02.setCurso(curso02);
        detalle02.setFecha_registro(new Date());

        Alumno_Curso detalle03 = new Alumno_Curso();
        detalle03.setAlumno(alumno01);
        detalle03.setCurso(curso03);
        detalle03.setFecha_registro(new Date());

        Alumno_Curso detalle04 = new Alumno_Curso();
        detalle04.setAlumno(alumno03);
        detalle04.setCurso(curso03);
        detalle04.setFecha_registro(new Date());

        detalles.add(detalle);
        detalles.add(detalle02);
        detalles.add(detalle03);
        detalles.add(detalle04);

    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Alumno_Curso> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Alumno_Curso> detalles) {
        this.detalles = detalles;
    }

    public int calcular_creditos(int cod_alumno) {
        int resultado = 0;
        for (Alumno_Curso a : detalles) {
            if (a.getAlumno().getCodigo_alumno() == cod_alumno) {
                resultado = a.getCurso().getNumero_creditos();
            }
        }
        return resultado;
    }

}
