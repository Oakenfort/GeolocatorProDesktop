package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Smartphone;


@Local
public interface IDaoLocal<T> {
	boolean create(T u);
	boolean delete (T u);
	boolean update (T u);
	T getById(int id);
	List<T> getByImei(String imei);
	List<T> getAll();

}
