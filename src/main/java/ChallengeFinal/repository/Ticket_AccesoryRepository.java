package ChallengeFinal.repository;

import ChallengeFinal.models.Ticket_Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Ticket_AccesoryRepository extends JpaRepository<Ticket_Accessory, Long> {
}
