package uacd.master.sir.fast_food_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommandeResponseDTO {

    private int idcommande;
    private int idutilisateur;
    private Date date;
    private String status;
    private List<Integer> fastfoods;
    private List<Integer> produits;
}
