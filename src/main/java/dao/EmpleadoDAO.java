package dao;

import entities.Departamento;
import entities.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmpleadoDAO {
    private final SessionFactory sessionFactory;

    public EmpleadoDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveEmpleado(Empleado empleado){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(empleado);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Empleado getEmpleadoById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Empleado.class, id);
        }finally {
            session.close();
        }
    }

    public List<Empleado> getAllEmpleados() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Empleado", Empleado.class).list();
        } finally {
            session.close();
        }
    }

    public void updateEmpleado(Empleado empleado) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(empleado);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    public void deleteEmpleado(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Empleado empleado = session.get(Empleado.class, id);
            if (empleado != null) {
                session.delete(empleado);
                transaction.commit();
            }
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }
}
