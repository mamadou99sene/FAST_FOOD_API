package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uacd.master.sir.fast_food_api.dto.RoleUtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.dto.UtilisateurRequestDTO;
import uacd.master.sir.fast_food_api.dto.UtilisateurResponseDTO;
import uacd.master.sir.fast_food_api.enums.RoleEnum;
import uacd.master.sir.fast_food_api.models.Roleutilisateur;
import uacd.master.sir.fast_food_api.models.Utilisateur;
import uacd.master.sir.fast_food_api.models.UtilisateurConfirmation;
import uacd.master.sir.fast_food_api.repositories.RoleRepository;
import uacd.master.sir.fast_food_api.repositories.RoleUtilisateurRepository;
import uacd.master.sir.fast_food_api.repositories.UtilisateurConfirmationRepository;
import uacd.master.sir.fast_food_api.repositories.UtilisateurRepository;
import uacd.master.sir.fast_food_api.services.EmailService;
import uacd.master.sir.fast_food_api.services.RoleUtilisateurService;
import uacd.master.sir.fast_food_api.services.UtilisateurService;
import uacd.master.sir.fast_food_api.utils.Mapper;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleUtilisateurRepository roleUtilisateurRepository;
    private final RoleUtilisateurService roleUtilisateurService;
    private final RoleRepository roleRepository;
    private final UtilisateurConfirmationRepository confirmationRepository;
    private final EmailService emailService;


    @Override
    public UtilisateurResponseDTO create(UtilisateurRequestDTO requestDTO) {

        //mettre cette partie sous forme de transactions plus tard
        UtilisateurResponseDTO responseDTO = new UtilisateurResponseDTO();
        Utilisateur utilisateur = new Utilisateur();


        utilisateur.setEnabled(false);
        utilisateur = utilisateurRepository.save(Mapper.mapToEntityUtilisateur(utilisateur, requestDTO));

        UtilisateurConfirmation utilisateurConfirmation = new UtilisateurConfirmation(utilisateur);

        RoleUtilisateurRequestDTO role = new RoleUtilisateurRequestDTO();
        role.setUtilisateur(utilisateur);

        String userType = requestDTO.getType();

        if (userType != null){
            if (userType.equalsIgnoreCase("client"))
                role.setRole(roleRepository.findRoleByIdrole(RoleEnum.CLIENT.ordinal()+1));
        }else{
            role.setRole(roleRepository.findRoleByIdrole(RoleEnum.MANAGER.ordinal()+1));
        }



        roleUtilisateurRepository.save(Mapper.mapToEntityRoleutilisateur(new Roleutilisateur(), role));
        confirmationRepository.save(utilisateurConfirmation);

        emailService.sendSimpleMessage(utilisateur.getPrenom(), utilisateur.getEmail(), utilisateurConfirmation.getToken());

        return Mapper.mapToUtilisateurResponse(utilisateur, responseDTO);
    }

    @Override
    public Boolean verifyToken(String token) {

        UtilisateurConfirmation confirmation = confirmationRepository.findByToken(token);

        Utilisateur user = utilisateurRepository.findByEmailIgnoreCase(confirmation.getUtilisateur().getEmail());
        user.setEnabled(true);
        utilisateurRepository.save(user);
        return Boolean.TRUE;
    }

    @Override
    public String delete(int id) {

        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByIdutilisateur(id);

        roleUtilisateurService.deleteByUtilisateur(utilisateur);

        utilisateurRepository.delete(utilisateur);

        return "User is deleted with success !";
    }

    @Override
    public UtilisateurResponseDTO update(int id, UtilisateurRequestDTO requestDTO) {

        UtilisateurResponseDTO responseDTO = new UtilisateurResponseDTO();
        Utilisateur utilisateur = utilisateurRepository.findUtilisateurByIdutilisateur(id);
        Mapper.mapToEntityUtilisateur(utilisateur, requestDTO);

        return Mapper.mapToUtilisateurResponse(utilisateurRepository.save(utilisateur), responseDTO);
    }

    @Override
    public List<UtilisateurResponseDTO> readAll() {
        List<Utilisateur> responseDTOS = utilisateurRepository.findAll(Sort.by("idutilisateur"));
        return responseDTOS.stream()
                .map(responseDTO -> Mapper.mapToUtilisateurResponse(responseDTO, new UtilisateurResponseDTO()))
                .toList();
    }

    @Override
    public UtilisateurResponseDTO readById(int id) {
        UtilisateurResponseDTO responseDTO = new UtilisateurResponseDTO();
        return Mapper.mapToUtilisateurResponse(utilisateurRepository.findUtilisateurByIdutilisateur(id), responseDTO);
    }


}
