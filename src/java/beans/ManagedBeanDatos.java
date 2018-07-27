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
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import javax.faces.context.FacesContext;

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
    private Alumno_Curso objeto_seleccionado;
    private String firma_alumno = "";

    private String center_mapa = "-12.0459686,-77.0327614";
    private Date fecha;
    private String usuario = "";
    private String clave = "";
    private Boolean opcion = false;
    private Curso curso_seleccionado;

    public ManagedBeanDatos() {
        cursos = new LinkedList<>();
        alumnos = new LinkedList<>();
        detalles = new LinkedList<>();
        objeto_seleccionado = new Alumno_Curso();
        fecha = new Date();
        curso_seleccionado = new Curso();
    }

    public Curso getCurso_seleccionado() {
        return curso_seleccionado;
    }

    public void setCurso_seleccionado(Curso curso_seleccionado) {
        this.curso_seleccionado = curso_seleccionado;
    }

    public Boolean getOpcion() {
        return opcion;
    }

    public void setOpcion(Boolean opcion) {
        this.opcion = opcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void limpiar_firma() {
        firma_alumno = "";
    }

    public String getFirma_alumno() {
        return firma_alumno;
    }

    public void setFirma_alumno(String firma_alumno) {
        this.firma_alumno = firma_alumno;
    }

    public String getCenter_mapa() {
        return center_mapa;
    }

    public void setCenter_mapa(String center_mapa) {
        this.center_mapa = center_mapa;
    }

    public MapModel getSimpleModel() {
        DefaultMapModel simpleModel = new DefaultMapModel();

        //Coordenadas 
        LatLng coord1 = new LatLng(-12.0450236, -77.0309484);
        LatLng coord2 = new LatLng(-12.0461097, -77.0318492);
        LatLng coord3 = new LatLng(-12.0455507, -77.0314336);
        LatLng coord4 = new LatLng(-12.0452037, -77.0322574);

        //Marcadores
        simpleModel.addOverlay(new Marker(coord1, "Palacio Arzobispal de Lima"));
        simpleModel.addOverlay(new Marker(coord2, "Rocky's"));
        simpleModel.addOverlay(new Marker(coord3, "Restaurante el Diez"));
        simpleModel.addOverlay(new Marker(coord4, "Municipalidad Metropolitana de Lima"));
        return simpleModel;
    }

    public Alumno_Curso getObjeto_seleccionado() {
        return objeto_seleccionado;
    }

    public void setObjeto_seleccionado(Alumno_Curso objeto_seleccionado) {
        this.objeto_seleccionado = objeto_seleccionado;
    }

    public void llenar_datos() {

        cursos = new LinkedList<>();
        alumnos = new LinkedList<>();
        detalles = new LinkedList<>();

        Curso curso01 = new Curso();
        curso01.setCodigo(1);
        curso01.setNombre("Fundamentos de la Programacion");
        curso01.setNumero_creditos(5);

        Curso curso02 = new Curso();
        curso02.setCodigo(2);
        curso02.setNombre("Curso Primefaces");
        curso02.setNumero_creditos(3);

        Curso curso03 = new Curso();
        curso03.setCodigo(3);
        curso03.setNombre("Curso Base Datos MYSQL");
        curso03.setNumero_creditos(4);
        
        Curso curso04 = new Curso();
        curso04.setCodigo(4);
        curso04.setNombre("Curso Linux");
        curso04.setNumero_creditos(7);
        Curso curso05 = new Curso();
        curso05.setCodigo(5);
        curso05.setNombre("Administracion Windows");
        curso05.setNumero_creditos(5);
        Curso curso06 = new Curso();
        curso06.setCodigo(6);
        curso06.setNombre("Optimizacion de servidores");
        curso06.setNumero_creditos(4);
        Curso curso07 = new Curso();
        curso07.setCodigo(7);
        curso07.setNombre("Compiladores");
        curso07.setNumero_creditos(4);

        cursos.add(curso01);
        cursos.add(curso02);
        cursos.add(curso03);
        cursos.add(curso04);
        cursos.add(curso05);
        cursos.add(curso06);
        cursos.add(curso07);

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
                resultado = resultado + a.getCurso().getNumero_creditos();
            }
        }
        return resultado;
    }

    public void seleccionar(Alumno_Curso obj) {
        objeto_seleccionado = obj;
    }

    public void mostrar(int op) {

        if (op == 1) {
            fecha = new Date();
            RequestContext.getCurrentInstance().update("form:hora");
            RequestContext.getCurrentInstance().execute("PF('notificacion').show();");
        } else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('notificacion').hide();");
        }
    }

    public void agregarMensaje() {
        String summary = opcion ? "Activo" : "Desactivo";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public Curso obtenerCurso_codigo(int id_curso) {
        // Aqui se debe implementar una llamda a base de datos.
       Curso curso_ = null;
        for (Curso c : cursos) {
            if (c.getCodigo() == id_curso) {
                curso_ = c;
            }
        }
        return curso_;
    }

    public List<Curso> autocompletar_cursos(String query) {
        List<Curso> lista_resultado = new ArrayList<Curso>();
        for (Curso c : cursos) {
            if (c.getNombre().toLowerCase().contains(query.toLowerCase())) {
                lista_resultado.add(c);
            }

        }

        return lista_resultado;
    }

    public List<Alumno_Curso> detalles_Filtrados(Curso c) {
        List<Alumno_Curso> resultado_ = new LinkedList<>();
        if (c != null) {
            for (Alumno_Curso ac : detalles) {
                if (ac.getCurso().getNombre().equalsIgnoreCase(c.getNombre())) {
                    resultado_.add(ac);
                }
            }
        }

        return resultado_;
    }
}
