package neo.ja.creditsystem.domen.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {
    private Integer id;
    private Integer code;
    private String date;
    private String mainLoanAccount;
    private String overdueAccount;
    private String accrualAccount;
    private String creditedButNotPaidOnTime;
    private String incomeAccountForAccrued;
    private String OffBalanceAccountClientIsObligationToTheBank;
    private String OffBalanceSheetCounterAccountClientIsObligationToTheBank;

}
