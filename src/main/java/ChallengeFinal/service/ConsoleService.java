package ChallengeFinal.service;

import ChallengeFinal.dtos.ConsoleDTO;
import ChallengeFinal.models.Console;

import java.util.List;

public interface ConsoleService {
    public List<ConsoleDTO> consolesDTO();
    public Console findById(long id);
    public List<Console> findAll();
    public void saveConsole(Console console);
    public void deleteConsole(Console console);
}
