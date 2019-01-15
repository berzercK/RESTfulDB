package com.netcracker.BatyrkinAndrew.dao;

import com.netcracker.BatyrkinAndrew.entity.Buyer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buyerDao")
public class BuyerDAOImpl implements IBuyerDAO {

    private final
    SessionFactory sessionFactory;

    @Autowired
    public BuyerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBuyer(Buyer buyer) {
        getSession().persist(buyer);
    }

    @Override
    public Buyer findBuyerById(int idBuyer) {
        return (Buyer) getSession().get(Buyer.class, idBuyer);
    }

    @Override
    public List<Buyer> findAllBuyer() {
        return getSession().createCriteria(Buyer.class).list();
    }

    @Override
    public void deleteBuyerById(int idBuyer) {
        Buyer entity = getSession().get(Buyer.class, idBuyer);
        if (entity != null)
            getSession().delete(entity);
    }

    @Override
    public void deleteAllBuyers() {
        SQLQuery sqlQuery = getSession().createSQLQuery("delete from buyers");
        sqlQuery.executeUpdate();
    }


}
