package neo.ja.creditsystem.domen.service;

import neo.ja.creditsystem.domen.DTO.AccountDTO;
import neo.ja.creditsystem.domen.credit.Account;
import neo.ja.creditsystem.domen.credit.Credit;
import neo.ja.creditsystem.domen.mapper.AccountMapper;
import neo.ja.creditsystem.domen.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public record AccountService(AccountRepository repository, AccountMapper mapper) {


    private Account addCreditFirst(Credit credit) {
        Account account = new Account();
        account.setDate(LocalDate.of(2011,11,1));
        account.setCode(credit.getId());
        account.setMainLoanAccount(credit.getAmount());
        account.setOffBalanceAccountClientIsObligationToTheBank(credit.getAmount());
        account.setOffBalanceSheetCounterAccountClientIsObligationToTheBank(credit.getAmount());
        return repository.save(account);
    }

    public void addAccount(Credit credit) {
        List<Account> accounts = new ArrayList<>();
        Account account = addCreditFirst(credit);
        for (int i =2 ; i <= 30; i++) {
            accounts.add(account);
            if (i == credit.getChartDay()) {
                account = addCreditForChartDay(account, credit);
            } else
                account = addAccount(account, credit);
        }
        accounts.add(account);

        repository.saveAll(accounts);
    }

    private Account addAccount(Account account, Credit credit) {
        Account account1 = new Account();
        account1.setCode(account.getCode());
        int day = account.getDate().getDayOfMonth();
        account1.setDate(LocalDate.of(account.getDate().getYear(), account.getDate().getMonthValue(), day + 1));
        account1.setMainLoanAccount(account.getMainLoanAccount());
        account1.setOverdueAccount(account.getOverdueAccount());
        account1.setAccrualAccount(account.getAccrualAccount() + credit.getAmount() * credit.getPercentage() / 100 / 365);
        account1.setCreditedButNotPaidOnTime(account.getCreditedButNotPaidOnTime());
        account1.setIncomeAccountForAccrued(account.getIncomeAccountForAccrued() + credit.getAmount() * credit.getPercentage() / 100 / 365);
        account1.setOffBalanceAccountClientIsObligationToTheBank(account.getOffBalanceAccountClientIsObligationToTheBank());
        account1.setOffBalanceSheetCounterAccountClientIsObligationToTheBank(account.getOffBalanceSheetCounterAccountClientIsObligationToTheBank());
        return account1;
    }

    private Account addCreditForChartDay(Account account, Credit credit) {
        Account account1 = new Account();
        account1.setCode(account.getCode());
        int day = account.getDate().getDayOfMonth();
        account1.setDate(LocalDate.of(account.getDate().getYear(), account.getDate().getMonthValue(), day + 1));
        account1.setMainLoanAccount(account.getMainLoanAccount() - credit.getDebt());
        account1.setOverdueAccount(account.getOverdueAccount() + credit.getDebt());
        account1.setCreditedButNotPaidOnTime(account.getCreditedButNotPaidOnTime() + account.getAccrualAccount() + credit.getAmount() * credit.getPercentage() / 100 / 365);
        account1.setAccrualAccount(0D);
        account1.setIncomeAccountForAccrued(account.getIncomeAccountForAccrued() + credit.getAmount() * credit.getPercentage() / 100 / 365);
        account1.setOffBalanceAccountClientIsObligationToTheBank(account.getOffBalanceAccountClientIsObligationToTheBank());
        account1.setOffBalanceSheetCounterAccountClientIsObligationToTheBank(account.getOffBalanceSheetCounterAccountClientIsObligationToTheBank());
        return account1;
    }


    public List<AccountDTO> getAll(Integer code) {
        List<AccountDTO> accounts = new ArrayList<>();
        for (Account account : repository.findAll()) {
            if (account.getCode().equals(code))
                accounts.add(mapper.toDto(account));
        }
        return accounts;
    }

    public AccountDTO getId(Integer id) {
        return mapper.toDto(repository.findById(id).get());
    }


    public void updateAccount(Credit credit) {
        repository.deleteAllByCode(credit.getId());
        addAccount(credit);
    }

    public void deleteByCode(Integer id) {
        repository.deleteAllByCode(id);
    }
}
