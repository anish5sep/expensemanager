package com.anish.expensemanager.service.interfaces;

import com.anish.expensemanager.dto.IncomeDTO;
import java.util.List;


public interface IncomeService {
    List<IncomeDTO> getAllIncomes(String username);
    IncomeDTO addIncome(String username, IncomeDTO incomeDTO);
}
