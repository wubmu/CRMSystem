package sample.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.Bean.Contact;
import sample.Bean.Customer;
import sample.Bean.CustomerEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-06-20 17:06
 * description
 */
public class CustomerDao {
    /**
     * 根据Customer的Id查找该公司的所有联系人
     * @param id
     * @return
     */
    public List<Contact> findContactById(int id){
        Session s =hibernateFactory.getSession();
        String sql = "from Contact as c where c.customerId=?";
        Query query = s.createQuery(sql);
        query.setParameter(0,id);
        List<Contact> c = query.getResultList();

        hibernateFactory.closeSession();
        return c;
    }

    public void deleteContantById(int id){
        Session s = hibernateFactory.getSession();
        Contact c= new Contact();
        c.setId(id);
        s.beginTransaction();
        s.delete(c);
        s.getTransaction().commit();
        hibernateFactory.closeSession();

    }
    public void  updata(CustomerEntity customer){
        Session s = hibernateFactory.getSession();
        s.update(customer);
        s.beginTransaction().commit();
        hibernateFactory.closeSession();
    }
}
