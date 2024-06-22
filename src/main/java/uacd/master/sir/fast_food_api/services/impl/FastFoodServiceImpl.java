package uacd.master.sir.fast_food_api.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.FastFoodRequestDTO;
import uacd.master.sir.fast_food_api.dto.FastFoodResponseDTO;
import uacd.master.sir.fast_food_api.services.FastFoodService;
import uacd.master.sir.fast_food_api.models.Fastfood;
import uacd.master.sir.fast_food_api.repositories.FastFoodRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FastFoodServiceImpl implements FastFoodService {
    private FastFoodRepository fastFoodRepository;

    @Override
    public List<FastFoodResponseDTO> getAllFastFood() {
        return fastFoodRepository.
                findAll().
                stream().
                map(this::convertToDTO).
                collect(Collectors.
                        toList());
    }

    @Override
    public FastFoodResponseDTO getfastFoodById(int idFastFood) {

        return fastFoodRepository
                .findById(idFastFood)
                .map(this::convertToDTO).
               orElse(null);
    }

    @Override
    public FastFoodResponseDTO saveFastFood(FastFoodRequestDTO fastFoodRequestDTO) {

        Fastfood fastfood = this.convertToEntity(fastFoodRequestDTO);
        fastFoodRepository.save(fastfood);
        return convertToDTO(fastfood);
    }

    @Override
    public FastFoodResponseDTO updateFastFood(FastFoodRequestDTO fastFoodRequestDTO, int idFastFood) {

        Fastfood fastfood=fastFoodRepository.findById(idFastFood).orElse(null);

        if(fastfood!=null)
        {
            fastfood.setIdutilisateur(fastFoodRequestDTO.getIdutilisateur());
            fastfood.setNom(fastFoodRequestDTO.getNom());
            fastfood.setDescription(fastFoodRequestDTO.getDescription());
            fastfood.setLocalisation(fastFoodRequestDTO.getLocalisation());
           return this.convertToDTO(fastFoodRepository.save(fastfood));
        }
    return null;
    }

    @Override
    public boolean deleteFastFood(int idFastFood) {

        Fastfood fastfood=fastFoodRepository.findById(idFastFood).get();
        fastFoodRepository.delete(fastfood);
        return true;
    }

    @Override
    public List<FastFoodResponseDTO> getFastFoodsByName(String nom) {

      return   this.fastFoodRepository.
              findFastfoodByNomContainingIgnoreCase(nom).
                stream().
                map(this::convertToDTO).
                collect
                        (Collectors.toList());
    }


    public FastFoodResponseDTO convertToDTO(Fastfood fastfood){

       FastFoodResponseDTO dto=new FastFoodResponseDTO();
        dto.setIdfastfood(fastfood.getIdfastfood());
        dto.setIdutilisateur(fastfood.getIdutilisateur());
        dto.setNom(fastfood.getNom());
        dto.setDescription(fastfood.getDescription());
        dto.setLocalisation(fastfood.getLocalisation());
        return  dto;
    }

    public  Fastfood convertToEntity(FastFoodRequestDTO fastFoodRequestDTO){

        Fastfood fastfood=new Fastfood();
        fastfood.setIdutilisateur(fastFoodRequestDTO.getIdutilisateur());
        fastfood.setNom(fastFoodRequestDTO.getNom());
        fastfood.setDescription(fastFoodRequestDTO.getDescription());
        fastfood.setLocalisation(fastFoodRequestDTO.getLocalisation());

//        fastfood.setNom("KEUR COULY");
//        fastfood.setDescription("Keur Couly Nekha Lekké");
//        fastfood.setLocalisation("Guédiawaye");


        return fastfood;

    }

}
