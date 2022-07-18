package neo.ja.creditsystem.domen.mapper;

import neo.ja.creditsystem.domen.DTO.AccountDTO;
import neo.ja.creditsystem.domen.credit.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements BaseMapper{

    public AccountDTO toDto(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(account.getId());
        accountDTO.setCode(+account.getCode());
        accountDTO.setDate(""+account.getDate());
        accountDTO.setMainLoanAccount(String.format("%,.2f", account.getMainLoanAccount()));
        accountDTO.setOverdueAccount(String.format("%,.2f", account.getOverdueAccount()));
        accountDTO.setAccrualAccount(String.format("%,.2f", account.getAccrualAccount()));
        accountDTO.setCreditedButNotPaidOnTime(String.format("%,.2f", account.getCreditedButNotPaidOnTime()));
        accountDTO.setIncomeAccountForAccrued(String.format("%,.2f", account.getIncomeAccountForAccrued()));
        accountDTO.setOffBalanceAccountClientIsObligationToTheBank(String.format("%,.2f", account.getOffBalanceAccountClientIsObligationToTheBank()));
        accountDTO.setOffBalanceSheetCounterAccountClientIsObligationToTheBank(String.format("%,.2f", account.getOffBalanceSheetCounterAccountClientIsObligationToTheBank()));
        return accountDTO;
    }


}
