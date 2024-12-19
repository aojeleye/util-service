package org.util.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FinancialYearDto {
    private String year;
    private List<FinancialMonthDto> months = new ArrayList<>();

    public FinancialMonthDto getMonth(String month) {
        return months.stream().filter(dto -> month.equals(dto.getMonth())).findFirst().orElse(null);
    }
}
