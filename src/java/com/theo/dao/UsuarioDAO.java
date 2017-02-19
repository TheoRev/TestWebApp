package com.theo.dao;

import com.theo.models.Usuario;
import com.theo.services.TestWebAppService;
import java.util.List;

public class UsuarioDAO extends TestWebAppService<Usuario>{

    @Override
    public List<Usuario> findByQuery(String q) throws Exception {
        return super.findByQuery(q);
    }
    
}
