package sample.util;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-06-20 16:27
 * description
 */
class JdbcUtilTest {

    @org.junit.jupiter.api.Test
    void getConnection() {
        System.out.println(JdbcUtil.getConnection());
    }
}