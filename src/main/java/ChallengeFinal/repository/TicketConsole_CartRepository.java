package ChallengeFinal.repository;

import ChallengeFinal.models.TicketConsole_Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketConsole_CartRepository extends JpaRepository<TicketConsole_Cart, Long> {
}
