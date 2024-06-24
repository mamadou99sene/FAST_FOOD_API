package uacd.master.sir.fast_food_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class CommandeResponseDTO {

    private int idcommande;
    private int idutilisateur;
    private Date date;
    private String status;
}
