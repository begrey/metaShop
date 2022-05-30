package com.merit.metaShop.order.domain;

import com.merit.metaShop.coupon.domain.Coupon;
import com.merit.metaShop.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    private String status;

    @Column(name="total_price")
    private LocalDateTime totalPrice;

    private String address;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    // 한 주문에는 쿠폰 하나만 사용하도록, 쿠폰 : 주문이 N:1이면 coupon에서 ManyToOne으로 연관관계 주인 매핑해야함, Order들의 리스트까지 가져가야하나..?
    // 그러면 쿠폰에 order가 들어가야 하는데, 쿠폰이 생길때 바로 주문에 적용하는게 아니므로 처음엔 쿠폰에있는 order가 null이된다.
//    @OneToMany(mappedBy = "order", fetch=FetchType.LAZY)
//    @OneToOne
//    @JoinColumn(name="coupon_id") -> private Coupon coupon;
//    private final List<Coupon> couponList = new ArrayList<>();

//    @OneToOne
//    @JoinColumn(name="pay_id")
//    private Pay pay;
}
