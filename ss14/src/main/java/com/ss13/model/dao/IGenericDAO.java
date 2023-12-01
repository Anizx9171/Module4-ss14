package com.ss13.model.dao;

import java.util.List;

public interface IGenericDAO<T,ID> {
    List<T> findAll();
    List<T> findPagi(ID noPage);

    void add(T t);
    void remove(ID id);
    void update(T t);
    T findById(ID id);
}
