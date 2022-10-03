package webbangiaydabong.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "custommerinfo")
public class CustommerInfo {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String Sdt;
private String name;
private String Address;
@ManyToOne
@JoinColumn(name="account_id")
private Account account;
@OneToMany(mappedBy = "diaChi")
private Set<Order>danhSachOrder;

}
