package neo.ja.creditsystem.domen.mapper;

import neo.ja.creditsystem.domen.DTO.CreditCreateDTO;
import neo.ja.creditsystem.domen.DTO.CreditDTO;
import neo.ja.creditsystem.domen.DTO.CreditUpdateDTO;
import neo.ja.creditsystem.domen.credit.Credit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CreditMapper implements BaseMapper{

    public CreditDTO toDto(Credit credit){
        CreditDTO creditDTO = new CreditDTO();
        if (Objects.nonNull(credit.getId()))
            creditDTO.setId(credit.getId());
        if (Objects.nonNull(credit.getFirstname()))
            creditDTO.setFirstname(credit.getFirstname());
        if (Objects.nonNull(credit.getLastname()))
            creditDTO.setLastname(credit.getLastname());
        creditDTO.setAmount(String.format("%,.2f",credit.getAmount()));
        creditDTO.setDuration(String.valueOf(credit.getDuration()));
        creditDTO.setPercentage(String.valueOf(credit.getPercentage()));
        creditDTO.setChartDay(String.valueOf(credit.getChartDay()));
        creditDTO.setDebt(String.format("%,.2f",credit.getDebt()));

        return creditDTO;
    }

    public List<CreditDTO> toDto(List<Credit> credits){
        List<CreditDTO> creditDTOS = new ArrayList<>();
        for (Credit credit : credits) {
            creditDTOS.add(toDto(credit));
        }
        return creditDTOS;
    }

    public Credit fromCreateDto(CreditCreateDTO createDTO){
        Credit credit = new Credit();
        if (Objects.nonNull(createDTO.getFirstname()))
            credit.setFirstname(createDTO.getFirstname());
        if (Objects.nonNull(createDTO.getLastname()))
            credit.setLastname(createDTO.getLastname());
        credit.setAmount(createDTO.getAmount());
        credit.setDuration(createDTO.getDuration());
        credit.setPercentage(createDTO.getPercentage());
        credit.setChartDay(createDTO.getChartDay());
        return credit;
    }

    public Credit fromUpdateDto(CreditUpdateDTO updateDTO){
        Credit credit = new Credit();
        if (Objects.nonNull(updateDTO.getId()))
            credit.setId(updateDTO.getId());
        if (Objects.nonNull(updateDTO.getFirstname()))
            credit.setFirstname(updateDTO.getFirstname());
        if (Objects.nonNull(updateDTO.getLastname()))
            credit.setLastname(updateDTO.getLastname());
        credit.setAmount(updateDTO.getAmount());
        credit.setDuration(updateDTO.getDuration());
        credit.setPercentage(updateDTO.getPercentage());
        credit.setChartDay(updateDTO.getChartDay());
        return credit;
    }
}