package org.util.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.util.constants.Constants.*;

@Data
public class FinancialMonthDto {
    private String month;
    private String year;
    private BigDecimal monthlyBalance = BigDecimal.ZERO;
    private List<FinancialExpenseDto> expenses = new ArrayList<>();
    @JsonIgnore
    private Map<String, BigDecimal> buckets = initBuckets();

    private Map<String, BigDecimal> initBuckets() {
        Map<String, BigDecimal> buckets = new HashMap<>();
        buckets.put(INCOME, BigDecimal.ZERO);
        buckets.put(GROCERIES, BigDecimal.ZERO);
        buckets.put(DINING_OUT, BigDecimal.ZERO);
        buckets.put(BILLS, BigDecimal.ZERO);
        buckets.put(GAS_STATION, BigDecimal.ZERO);
        buckets.put(HOME_REPAIR, BigDecimal.ZERO);
        buckets.put(CAR_REPAIR, BigDecimal.ZERO);
        buckets.put(ENTERTAINMENT, BigDecimal.ZERO);
        buckets.put(PET, BigDecimal.ZERO);
        buckets.put(MISC, BigDecimal.ZERO);
        buckets.put(CLOTHES, BigDecimal.ZERO);
        buckets.put(TRAVEL, BigDecimal.ZERO);
        buckets.put(HEALTHCARE, BigDecimal.ZERO);
        buckets.put(TAX, BigDecimal.ZERO);
        return buckets;
    }

    public void emptyBucket() {
        for (var bucket : buckets.entrySet()) {
            FinancialExpenseDto expenseDto = new FinancialExpenseDto();
            expenseDto.setName(bucket.getKey());
            expenseDto.setTotalCost(bucket.getValue());
            expenses.add(expenseDto);
        }
    }

    public void calcBal() {
        for (BigDecimal amount : expenses.stream().map(FinancialExpenseDto::getTotalCost).collect(Collectors.toList())) {
            monthlyBalance = monthlyBalance.add(amount);
        }
    }
}
