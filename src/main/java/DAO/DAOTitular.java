package DAO;

import Model.Titular;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

//update
public class DAOTitular implements DAO<Titular> {

    private SessionFactory sessionFactory;
    private static DAOTitular daoTitular;

    public DAOTitular(){
        //this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.sessionFactory= HibernateUtil.getSessionFactory();
    }

    public static DAOTitular getDaoTitular(){
        if (daoTitular == null){
            daoTitular = new DAOTitular();
        }
        return daoTitular;
    }


    @Override
    public Optional<Titular> get(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Titular titular = session.load(Titular.class, id);
        Optional<Titular> optional = Optional.ofNullable(titular);
        session.getTransaction().commit();
        session.close();

        return optional;
    }

    @Override
    public List<Titular> getAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sentencia = "SELECT * FROM titular";
        Query query = session.createSQLQuery(sentencia).addEntity(Titular.class);
        List<Titular> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;

    }

    @Override
    public void save(Titular titular) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(titular);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Titular titular) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(titular);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Titular titular) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(titular);
        session.getTransaction().commit();
        session.close();
    }

    //TODO Implementar


    public List<Titular> getListaTitularesAtributos (Titular titular){
        String sentencia = "SELECT * FROM titular";

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(sentencia).addEntity(Titular.class);
        List<Titular> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;

    }


}
