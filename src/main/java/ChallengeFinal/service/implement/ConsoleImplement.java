package ChallengeFinal.service.implement;

import ChallengeFinal.dtos.ConsoleDTO;
import ChallengeFinal.models.Console;
import ChallengeFinal.repository.ConsoleRepository;
import ChallengeFinal.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsoleImplement implements ConsoleService {
    @Autowired
    ConsoleRepository consoleRepository;

    @Override
    public List<ConsoleDTO> consolesDTO() {
        return consoleRepository.findAll().stream().filter(console -> console.isEnable()).map(console -> new ConsoleDTO(console)).collect(Collectors.toList());
    }

    @Override
    public Console findById(long id) {
        return consoleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Console> findAll() {
        return consoleRepository.findAll();
    }

    @Override
    public void saveConsole(Console console) {
        consoleRepository.save(console);
    }

    @Override
    public void deleteConsole(Console console) {
        consoleRepository.delete(console);
    }
}
