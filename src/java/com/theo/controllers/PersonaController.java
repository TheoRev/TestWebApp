package com.theo.controllers;

import com.theo.dao.PersonaDAO;
import com.theo.models.Persona;
import com.theo.services.ITestWebApp;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PersonaController {

    private List<Persona> personas;
    private Persona persona;

    @PostConstruct
    public void init() {
        persona = new Persona();
        doFindAll();
    }

    public List<Persona> doFindAll() {
        FacesMessage msg = null;
        ITestWebApp dao = new PersonaDAO();

        try {
            final String query = "Persona";
            personas = dao.findAll(query);
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "FATAL ERROR", e.getMessage());
        }

        if (msg != null) {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
