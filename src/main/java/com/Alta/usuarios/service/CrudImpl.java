package com.Alta.usuarios.service;

import com.Alta.usuarios.repository.ICrud;
import com.Alta.usuarios.repository.IGenericRepo;

import java.util.List;

public abstract class CrudImpl <T, ID> implements ICrud<T, ID> {
    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save (T t) throws Exception{
        return getRepo().save(t);
    }
    @Override
    public T update (T t, ID id) throws Exception{
        getRepo().findById(id).orElseThrow(() -> new Exception("No existe cuenta con id: " + id));
        return getRepo().save(t);
    }
    @Override
    public List<T> readAll() throws Exception{
        return getRepo().findAll();
    }
    @Override
    public T readById(ID id) throws Exception{
        return getRepo().findById(id).orElse(null);
    }
    @Override
    public void delete (ID id) throws Exception{
        getRepo().deleteById(id);
    }
}