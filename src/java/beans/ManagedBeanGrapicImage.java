/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.StreamedContent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author root
 */
@ManagedBean
@SessionScoped
public class ManagedBeanGrapicImage implements Serializable {

    private List<String> lista_imagenes;

    public ManagedBeanGrapicImage() {
        lista_imagenes = new LinkedList<>();
        lista_imagenes.add("luna.jpg");
        lista_imagenes.add("sol.png");
    }

    public List<String> getLista_imagenes() {
        return lista_imagenes;
    }

    public void setLista_imagenes(List<String> lista_imagenes) {
        this.lista_imagenes = lista_imagenes;
    }

    

    public StreamedContent getImagenDinamica() {
       
        FacesContext context = FacesContext.getCurrentInstance();
        
        String nombre_imagen;
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            nombre_imagen = context.getExternalContext().getRequestParameterMap().get("nombre_imagen");

            try {
                return mostrarImagen(nombre_imagen);
            } catch (Exception e) {
                return null;
            }

        }

    }
public StreamedContent mostrarImagen(String nombreArchivo) throws IOException {
        ByteArrayOutputStream out = null;
        if (nombreArchivo == null) {
            out = traerArchivo("/opt/piensa_en_java/", "default.png");
            InputStream myInputStream2 = new ByteArrayInputStream(out.toByteArray());
            return new DefaultStreamedContent(myInputStream2);
        }
        if (nombreArchivo.length() > 0) {
            out = traerArchivo("/opt/piensa_en_java/", nombreArchivo);
            InputStream myInputStream2 = new ByteArrayInputStream(out.toByteArray());
            return new DefaultStreamedContent(myInputStream2);

        } else {
            out = traerArchivo("/opt/piensa_en_java/", "default.png");
            InputStream myInputStream2 = new ByteArrayInputStream(out.toByteArray());
            return new DefaultStreamedContent(myInputStream2);
        }
    }

    public ByteArrayOutputStream traerArchivo(String ruta, String nombre_archivo) {

        ByteArrayOutputStream out = null;
        String path = ruta + nombre_archivo;
        InputStream in = null;

        try {
            File remoteFile = new File(path);
            in = new BufferedInputStream(new FileInputStream(remoteFile));
            out = new ByteArrayOutputStream((int) remoteFile.length());
            byte[] buffer = new byte[4096];
            int len = 0; //Read length
            while ((len = in.read(buffer, 0, buffer.length)) != - 1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        } catch (Exception e) {
            String msg = "ERROR DESCARGANDO ARCHIVO " + e.getMessage();
            System.out.println(msg);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
            }
        }

        return out;
    }
}
