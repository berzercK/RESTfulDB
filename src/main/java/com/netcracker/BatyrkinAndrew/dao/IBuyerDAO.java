package com.netcracker.BatyrkinAndrew.dao;

import com.netcracker.BatyrkinAndrew.entity.Buyer;

import java.util.List;

public interface IBuyerDAO {

    void addBuyer(Buyer buyer);

    Buyer findBuyerById(int idBuyer);

    List findAllBuyer();

    void deleteBuyerById(int idBuyer);

    void deleteAllBuyers();

}