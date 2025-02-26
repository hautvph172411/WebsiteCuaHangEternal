package webbangiaydabong.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="order")
@Getter
@Setter


public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Date create_date;//ngày tạo hóa đơn 
private Double price;//tổng tiền
private String note;
private int status;//1 giaohangf thành công,2 d
@ManyToOne
@JoinColumn(name="account_id")
private Account account;
@ManyToOne
@JoinColumn(name="van_chuyen_id")
private VanChuyen vanChuyen;
@ManyToOne
@JoinColumn(name="thanh_toan_id")
private Payment thanhToan;

@OneToMany(mappedBy = "order")
private Set<OrderDetail>danhSachOrder;
@ManyToOne
@JoinColumn(name="promotion_id")
private Promotion giamgia;
}
