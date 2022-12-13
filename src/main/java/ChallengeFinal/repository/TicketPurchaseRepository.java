package ChallengeFinal.repository;

import ChallengeFinal.models.TicketPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketPurchaseRepository extends JpaRepository<TicketPurchase, Long> {
}
