package webbangiaydabong.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="exchange")
public class Exchange {
@Id
private Long id;
private Date createDate;
@ManyToOne
@JoinColumn(name="product_id")
private Product product;

@ManyToOne
@JoinColumn(name="orderdetail_id")
private OrderDetail orderDetail;

}
