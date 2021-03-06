package br.com.letscode.dataproject.purchase.model;

import br.com.letscode.dataproject.customer.model.Customer;
import br.com.letscode.dataproject.product.model.Product;
import br.com.letscode.dataproject.purchaseproduct.model.PurchaseProduct;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Getter @Setter
@Entity(name = "purchase")
@NoArgsConstructor
@RequiredArgsConstructor
public class Purchase {
    //dados: data da compra, cpf do cliente, o valor total da compra e a lista de produtos que fazem parte da compra.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private Calendar purchaseDate;

    @NonNull
    private Float value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_customer")
    @NonNull
    private Customer customer;

    @Setter
    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseProduct> purchaseProductList = new ArrayList<>();

}
