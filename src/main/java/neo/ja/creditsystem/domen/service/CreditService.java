package neo.ja.creditsystem.domen.service;

import neo.ja.creditsystem.domen.DTO.CreditCreateDTO;
import neo.ja.creditsystem.domen.DTO.CreditDTO;
import neo.ja.creditsystem.domen.DTO.CreditUpdateDTO;
import neo.ja.creditsystem.domen.credit.Credit;
import neo.ja.creditsystem.domen.mapper.CreditMapper;
import neo.ja.creditsystem.domen.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditService extends AbstractService<
        CreditRepository,
        CreditMapper> implements GenericCRUDService<
        Credit, CreditDTO, CreditCreateDTO, CreditUpdateDTO, Integer
        > {


    protected CreditService(CreditRepository repository, CreditMapper mapper, AccountService accountService) {
        super(repository, mapper);
        this.accountService = accountService;
    }

    private final AccountService accountService;

    @Override
    public CreditDTO get(Integer id) {
        return mapper.toDto(repository.findById(id).get());
    }

    @Override
    public Credit create(CreditCreateDTO createDTO) {
        Credit credit = mapper.fromCreateDto(createDTO);
        credit.setCreatedAt(LocalDate.now());
        credit.setDebt(credit.getAmount() / (credit.getDuration() * 12));
        Credit save = repository.save(credit);
        accountService.addAccount(credit);
        return save;
    }

    @Override
    public void update(CreditUpdateDTO updateDTO) {
        Credit credit = mapper.fromUpdateDto(updateDTO);
        credit.setUpdatedAt(LocalDate.now());
        credit.setDebt(credit.getAmount()/ (credit.getDuration()*12));
        repository.save(credit);
        accountService.updateAccount(credit);
    }

    @Override
    public void delete(Integer id) {
        accountService.deleteByCode(id);
        repository.deleteById(id);

    }

    @Override
    public List<CreditDTO> getAll() {
        return mapper.toDto(repository.findAll());
    }


}
