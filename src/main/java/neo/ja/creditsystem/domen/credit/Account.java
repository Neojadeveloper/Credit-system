package neo.ja.creditsystem.domen.credit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account", schema = "credit")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer code;

    private LocalDate date;

    private double mainLoanAccount;

    private double overdueAccount;

    private double accrualAccount;

    private double creditedButNotPaidOnTime;

    private double incomeAccountForAccrued;

    private double OffBalanceAccountClientIsObligationToTheBank;

    private double OffBalanceSheetCounterAccountClientIsObligationToTheBank;

}