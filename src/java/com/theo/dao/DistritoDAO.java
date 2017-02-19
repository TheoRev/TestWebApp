package com.theo.dao;

import com.theo.models.Distrito;
import com.theo.services.TestWebAppService;
import java.util.List;

public class DistritoDAO extends TestWebAppService<Distrito> {

    @Override
    public List<Distrito> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }

    @Override
    public Distrito findBy(String q) throws Exception {
        return super.findBy(q);
    }

    @Override
    public List<Distrito> findAll(String t) throws Exception {
        return super.findAll(t);
    }

    @Override
    public boolean Delete(Distrito t) throws Exception {
        return super.Delete(t);
    }

    @Override
    public boolean Update(Distrito t) throws Exception {
        return super.Update(t);
    }

    @Override
    public boolean Create(Distrito t) throws Exception {
        return super.Create(t);
    }

}
