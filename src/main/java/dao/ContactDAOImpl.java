package dao;

import dao.entities.Contact;
import dao.interfaces.ContactDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO {
    private final static Log LOG = LogFactory.getLog(ContactDAOImpl.class);
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @PostConstruct
    public void init(){
        if(sessionFactory == null){
            throw new BeanCreationException("SessionFactory is null");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return getSessionFactory().getCurrentSession()
                .getNamedQuery("Contact.findAll").list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAllWithDetails() {
        return getSessionFactory().getCurrentSession()
                .getNamedQuery("Contact.findAllWithDetails").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return (Contact) getSessionFactory().getCurrentSession()
                .getNamedQuery("findById").setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public Contact save(Contact contact) {
        getSessionFactory().getCurrentSession().saveOrUpdate(contact);
        LOG.info("Contact save with ID - " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        getSessionFactory().getCurrentSession().delete(contact);
        LOG.info("Delete contact with ID - " + contact.getId());
    }
}
