package uacd.master.sir.fast_food_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CommandeRequestDTO {

    private int idutilisateur;
    private Date date;
    private String status;
}
