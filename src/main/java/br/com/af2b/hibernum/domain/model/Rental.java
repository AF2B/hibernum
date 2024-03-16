package br.com.af2b.hibernum.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.af2b.hibernum.domain.model.enums.PaymentMethod;
import br.com.af2b.hibernum.domain.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rental {
    private List<Product> products;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalPrice;
    private Status status;
    private Address shippingAddress;
    private PaymentMethod paymentMethod;
}
