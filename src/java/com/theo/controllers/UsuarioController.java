package com.theo.controllers;

import com.theo.dao.UsuarioDAO;
import com.theo.models.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioController {

    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public String autentificar() {
        FacesMessage message = null;
        String ruta = null;
        String query = "select u from Usuario u where u.username='" + usuario.getUsername()
                + "' and u.password='" + usuario.getPassword() + "'";
        UsuarioDAO dao = new UsuarioDAO();
        try {
            List<Usuario> lista = dao.findByQuery(query);
            if (lista.size() == 1) {
                for (Usuario u : lista) {
                    if (u.getUsername().equals(usuario.getUsername())
                            && u.getPassword().equals(usuario.getPassword())) {
                        ruta = "views/home?faces-redirect=true";
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ACCESO CONCEDIDO", "Bienvenido" + usuario.getUsername().toUpperCase());
                    } else {
                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR EN LA VALIDACION", "Usuario o Password incorrectos");
                        ruta = "index";
                    }
                }
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR EN LA VALIDACION", "Usuario o Password incorrectos");
                ruta = "index";
            }
        } catch (Exception ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN LA VALIDACION", ex.getMessage());
            ruta = "index";
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        return ruta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
