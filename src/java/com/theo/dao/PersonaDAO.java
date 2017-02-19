package com.theo.dao;

import com.theo.models.Persona;
import com.theo.services.TestWebAppService;
import java.util.List;

public class PersonaDAO extends TestWebAppService<Persona> {

    @Override
    public List<Persona> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }

    @Override
    public Persona findBy(String q) throws Exception {
        return super.findBy(q);
    }

    @Override
    public List<Persona> findAll(String t) throws Exception {
        return super.findAll(t);
    }

    @Override
    public boolean Delete(Persona t) throws Exception {
        return super.Delete(t);
    }

    @Override
    public boolean Update(Persona t) throws Exception {
        return super.Update(t);
    }

    @Override
    public boolean Create(Persona t) throws Exception {
        return super.Create(t);
    }

}
