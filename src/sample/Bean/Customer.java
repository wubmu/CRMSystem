package sample.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-06-20 16:36
 * description
 */
public class Customer {
    private int id;
    private String area;
    private String degree;
    private String accountManager;
    private String name;
    private String credit;

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", degree='" + degree + '\'' +
                ", accountManager='" + accountManager + '\'' +
                ", name='" + name + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }
}
