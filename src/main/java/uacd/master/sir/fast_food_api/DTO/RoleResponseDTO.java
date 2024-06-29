package uacd.master.sir.fast_food_api.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDTO {

    private int id;
    private String role;
    private String description;
}
