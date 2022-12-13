package ChallengeFinal.repository;

import ChallengeFinal.models.Ticket_Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Ticket_PhoneRepository extends JpaRepository<Ticket_Phone, Long> {
}
