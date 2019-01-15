package com.netcracker.BatyrkinAndrew.service;

import com.netcracker.BatyrkinAndrew.dao.IBuyerDAO;
import com.netcracker.BatyrkinAndrew.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buyerService")
public class BuyerServiceImpl implements IBuyerService {
    private final IBuyerDAO iBuyerDAO;

    @Autowired
    public BuyerServiceImpl(IBuyerDAO iBuyerDAO) {
        this.iBuyerDAO = iBuyerDAO;
    }

    public void addBuyer(Buyer buyer) {
        iBuyerDAO.addBuyer(buyer);
    }

    public Buyer findBuyerById(int idBuyer) {
        return iBuyerDAO.findBuyerById(idBuyer);
    }

    public List<Buyer> findAllBuyer() {
        return iBuyerDAO.findAllBuyer();
    }

    public boolean deleteBuyerById(int idBuyer) {
        if (iBuyerDAO.findBuyerById(idBuyer) == null) {
            return false;
        }
        iBuyerDAO.deleteBuyerById(idBuyer);
        return true;
    }

    public void deleteAllBuyers() {
        iBuyerDAO.deleteAllBuyers();
    }

}
