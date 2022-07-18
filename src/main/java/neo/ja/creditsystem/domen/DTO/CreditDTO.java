package neo.ja.creditsystem.domen.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private String amount;
    private String duration;
    private String percentage;
    private String chartDay;
    private String debt;
}