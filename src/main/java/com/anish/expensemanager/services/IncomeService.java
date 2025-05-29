package com.anish.expensemanager.services;

import com.anish.expensemanager.dto.IncomeDTO;
import java.util.List;

public interface IncomeService {
    IncomeDTO createIncome(IncomeDTO incomeDTO);
    IncomeDTO getIncomeById(Long id);
    List<IncomeDTO> getAllIncomes();
    IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO);
    void deleteIncome(Long id);
}