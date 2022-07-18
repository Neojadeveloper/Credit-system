package neo.ja.creditsystem.domen.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCreateDTO {

    private String firstname;
    private String lastname;
    private double amount;
    private int duration;
    private int percentage;
    private int chartDay;
}