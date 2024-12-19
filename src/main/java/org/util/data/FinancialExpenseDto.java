package org.util.data;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FinancialExpenseDto {
    private String name;
    private BigDecimal totalCost;
}
