/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converters;

/**
 *
 * @author root
 */
import beans.ManagedBeanDatos;
import clases.Curso;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import javax.el.ValueExpression;

@FacesConverter("cursoConverter")
public class CursoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (context == null) {
            throw new NullPointerException("context");
        }
        if (component == null) {
            throw new NullPointerException("component");
        }
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(), "#{managedBeanDatos}", ManagedBeanDatos.class);
        ManagedBeanDatos bean = (ManagedBeanDatos) vex.getValue(ctx.getELContext());
        Curso curso_;
        try {
            curso_ = bean.obtenerCurso_codigo(new Integer(value));
        } catch (NumberFormatException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Error en Codigo");
            throw new ConverterException(message);
        }
        if (curso_ == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor Desconocido", "Error en Objeto");
            throw new ConverterException(message);
        }
        return curso_;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (context == null) {
            throw new NullPointerException("context");
        }
        if (component == null) {
            throw new NullPointerException("component");
        }
        return String.valueOf(((Curso) value).getCodigo());
    }

}
