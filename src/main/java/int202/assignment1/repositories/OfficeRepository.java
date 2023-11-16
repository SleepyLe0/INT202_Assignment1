package int202.assignment1.repositories;

import int202.assignment1.entities.Office;
import int202.assignment1.utilities.EntityManagerBuilder;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OfficeRepository {
    private EntityManager em;

    private EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = EntityManagerBuilder.getEntityManager();
        }
        return em;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    }

    public Office findByOfficeCode(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public List<Office> search(String search) {
        return getEntityManager().createNamedQuery("OFFICE.SEARCH_ALL").setParameter("search", search).getResultList();
    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = findByOfficeCode(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public void update(Office newOffice) {
        EntityManager entityManager = getEntityManager();
        Office office = findByOfficeCode(newOffice.getOfficeCode());
        try {
            entityManager.getTransaction().begin();
            office.setCity(newOffice.getCity() == null ? office.getCity() : newOffice.getCity());
            office.setPhone(newOffice.getPhone() == null ? office.getPhone() : newOffice.getPhone());
            office.setAddressLine1(newOffice.getAddressLine1() == null ? office.getAddressLine1() : newOffice.getAddressLine1());
            office.setAddressLine2(newOffice.getAddressLine2() == null ? office.getAddressLine2() : newOffice.getAddressLine2());
            office.setState(newOffice.getState() == null ? office.getState() : newOffice.getState());
            office.setCountry(newOffice.getCountry() == null ? office.getCountry() : newOffice.getCountry());
            office.setPostalCode(newOffice.getPostalCode() == null ? office.getPostalCode() : newOffice.getPostalCode());
            office.setTerritory(newOffice.getTerritory() == null ? office.getTerritory() : newOffice.getTerritory());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
