package uacd.master.sir.fast_food_api.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uacd.master.sir.fast_food_api.dto.CommandefastfoodRequestDTO;
import uacd.master.sir.fast_food_api.dto.CommandefastfoodResponseDTO;
import uacd.master.sir.fast_food_api.models.Commandefastfood;
import uacd.master.sir.fast_food_api.models.CommandefastfoodPK;
import uacd.master.sir.fast_food_api.repositories.CommandefastfoodRepository;
import uacd.master.sir.fast_food_api.services.CommandefastfoodService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandefastfoodServiceImpl implements CommandefastfoodService {

    private final CommandefastfoodRepository commandefastfoodRepository;
    @Override
    public CommandefastfoodResponseDTO createCommandefastfood(CommandefastfoodRequestDTO commandefastfoodRequestDTO) {
        Commandefastfood commandefastfood = new Commandefastfood();
        commandefastfood.setIdcommande(commandefastfoodRequestDTO.getIdcommande());
        commandefastfood.setIdfastfood(commandefastfoodRequestDTO.getIdfastfood());
        Commandefastfood savedCommandefastfood = commandefastfoodRepository.save(commandefastfood);
        return mapToResponseDTO(savedCommandefastfood);
    }

    @Override
    public CommandefastfoodResponseDTO getCommandefastfoodById(int idcommande, int idfastfood) {
        Commandefastfood commandefastfood = commandefastfoodRepository.findById(new CommandefastfoodPK(idcommande, idfastfood))
                .orElseThrow(() -> new RuntimeException("Commandefastfood not found"));
        return mapToResponseDTO(commandefastfood);
    }

    @Override
    public List<CommandefastfoodResponseDTO> getAllCommandefastfoods() {
        return commandefastfoodRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public CommandefastfoodResponseDTO updateCommandefastfood(int idcommande, int idfastfood, CommandefastfoodRequestDTO commandefastfoodRequestDTO) {
        Commandefastfood commandefastfood = commandefastfoodRepository.findById(new CommandefastfoodPK(idcommande, idfastfood))
                .orElseThrow(() -> new RuntimeException("Commandefastfood not found"));
        commandefastfood.setIdcommande(commandefastfoodRequestDTO.getIdcommande());
        commandefastfood.setIdfastfood(commandefastfoodRequestDTO.getIdfastfood());
        Commandefastfood updatedCommandefastfood = commandefastfoodRepository.save(commandefastfood);
        return mapToResponseDTO(updatedCommandefastfood);
    }

    @Override
    public void deleteCommandefastfood(int idcommande, int idfastfood) {
        commandefastfoodRepository.deleteById(new CommandefastfoodPK(idcommande, idfastfood));
    }
    private CommandefastfoodResponseDTO mapToResponseDTO(Commandefastfood commandefastfood) {
        CommandefastfoodResponseDTO responseDTO = new CommandefastfoodResponseDTO();
        responseDTO.setIdcommande(commandefastfood.getIdcommande());
        responseDTO.setIdfastfood(commandefastfood.getIdfastfood());
        return responseDTO;
    }
}
