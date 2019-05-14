package repository;

import model.person.Client;

import java.util.List;

public interface IPersonRepository<T>{

    void add(T obj);

    void remove(T obj);

    List<T> list();

}
