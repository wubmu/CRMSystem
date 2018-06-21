package sample.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sample.Bean.Customer;
import sample.Bean.CustomerEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-06-20 17:45
 * description
 */
public class HibernateTest {
    public static void main(String[] args) {
        try {
            SessionFactory sf =
                    new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            CustomerEntity customer = new CustomerEntity();
            customer.setArea("12323");
            session.save(customer);


            tx.commit();
            session.close();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
