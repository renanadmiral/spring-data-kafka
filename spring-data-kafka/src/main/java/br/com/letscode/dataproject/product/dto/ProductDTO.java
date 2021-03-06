package br.com.letscode.dataproject.product.dto;

import java.math.BigDecimal;

import br.com.letscode.dataproject.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String codeNumber;
    private Float price;
    private Integer quantity;

    public static ProductDTO convert(Product product) {
        return new ProductDTO(
            product.getCodeNumber(), 
            product.getPrice(),
            product.getQuantity()
        );
    }
}
