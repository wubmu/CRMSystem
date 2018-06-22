package sample.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-06-21 11:20
 * description
 */
class CustomerDaoTest {
    CustomerDao dao  = new CustomerDao();

    @Test
    void findContactById() {
        System.out.println(dao.findContactById(1));
    }
}