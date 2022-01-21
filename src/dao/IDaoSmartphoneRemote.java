package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Smartphone;
import entities.User;


@Local
public interface IDaoSmartphoneRemote {
	boolean create(Smartphone u);
	boolean delete (Smartphone u);
	boolean update (Smartphone u);
	Smartphone getById(int id);
	List<Smartphone> getByImei(String imei);
	List<Smartphone> getAll();

}
