package sample.Bean;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-06-20 17:10
 * description
 */
@Entity
@Table(name = "customer", schema = "crms")
public class CustomerEntity {
    private int id;
    private String area;
    private String name;
    private String degree;
    private String satisfaction;
    private String accountManager;
    private String credit;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "degree")
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Basic
    @Column(name = "satisfaction")
    public String getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    @Basic
    @Column(name = "accountManager")
    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    @Basic
    @Column(name = "credit")
    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id &&
                Objects.equals(area, that.area) &&
                Objects.equals(name, that.name) &&
                Objects.equals(degree, that.degree) &&
                Objects.equals(satisfaction, that.satisfaction) &&
                Objects.equals(accountManager, that.accountManager) &&
                Objects.equals(credit, that.credit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, area, name, degree, satisfaction, accountManager, credit);
    }
}
