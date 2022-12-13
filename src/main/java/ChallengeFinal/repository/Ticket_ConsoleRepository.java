package ChallengeFinal.repository;

import ChallengeFinal.models.Ticket_Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Ticket_ConsoleRepository extends JpaRepository<Ticket_Console,Long> {
}
