package ChallengeFinal.repository;

import ChallengeFinal.models.TicketAccessory_Cart;
import ChallengeFinal.models.TicketConsole_Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketAccessory_CartRepository extends JpaRepository<TicketAccessory_Cart, Long> {
}
