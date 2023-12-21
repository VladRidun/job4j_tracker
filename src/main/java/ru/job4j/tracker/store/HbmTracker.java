package ru.job4j.tracker.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private static final String HQL_DELETE = "DELETE Item where id = ?";
    private static final String HQL_UPDATE = "UPDATE Item set name = :fName, created = :fCreated where id = :fId";
    private static final String HQL_FIND_ALL = "FROM Item";
    private static final String HQL_FIND_BY_NAME = "FROM Item where name like ?";
    private static final String HQL_FIND_BY_ID = "FROM Item where id = :fId";

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(HQL_UPDATE);
            result = query.setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", item.getId())
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
           Query query = session.createQuery(HQL_DELETE);
            result = query.setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> itemsList = new ArrayList<>();
        try {
            session.beginTransaction();
            itemsList = session.createQuery(HQL_FIND_ALL, Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemsList;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> itemsList = new ArrayList<>();
        try {
            session.beginTransaction();
            itemsList = session.createQuery(HQL_FIND_BY_NAME, Item.class)
                    .setParameter("fName", key).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return itemsList;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item resultItem = new Item();
        try {
            session.beginTransaction();
            resultItem = session.createQuery(
                            HQL_FIND_BY_ID, Item.class)
                    .setParameter("fId", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return resultItem;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
