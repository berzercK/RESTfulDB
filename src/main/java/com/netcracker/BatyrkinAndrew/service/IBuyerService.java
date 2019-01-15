package com.netcracker.BatyrkinAndrew.service;

import com.netcracker.BatyrkinAndrew.entity.Buyer;

import java.util.List;

public interface IBuyerService {

    void addBuyer(Buyer buyer);

    Buyer findBuyerById(int idBuyer);

    List<Buyer> findAllBuyer();

    boolean deleteBuyerById(int idBuyer);

    void deleteAllBuyers();

}
