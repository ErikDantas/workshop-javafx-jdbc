package model.service;

import java.util.List;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Seller;

public class SellerService {
	SellerDao dao = DaoFactory.createSellerDao();
	
	public List<Seller> findAll(){
		return dao.findAll();
	}
}
