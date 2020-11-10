package DAO;

import Model.Licencia;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

//update
public class DAOLicencia implements DAO<Licencia> {

    private SessionFactory sessionFactory;
    private static DAOLicencia daoLicencia;

    public DAOLicencia(){
        //this.sessionFactory = new Configuration().configure().buildSessionFactory();
        this.sessionFactory= HibernateUtil.getSessionFactory();
    }

    public static DAOLicencia getDaoCamion(){
        if (daoLicencia == null){
            daoLicencia = new DAOLicencia();
        }
        return daoLicencia;
    }


    @Override
    public Optional<Licencia> get(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Licencia licencia = session.load(Licencia.class, id);
        Optional<Licencia> optional = Optional.ofNullable(licencia);
        session.getTransaction().commit();
        session.close();

        return optional;
    }

    @Override
    public List<Licencia> getAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sentencia = "SELECT * FROM licencia";
        Query query = session.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;

    }

    @Override
    public void save(Licencia licencia) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(licencia);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Licencia licencia) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(licencia);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Licencia licencia) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(licencia);
        session.getTransaction().commit();
        session.close();
    }

    //TODO Implementar


    public List<Licencia> getListaLicenciaesAtributos (Licencia licencia){
        String sentencia = "SELECT * FROM licencia";

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(sentencia).addEntity(Licencia.class);
        List<Licencia> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;

    }


}
