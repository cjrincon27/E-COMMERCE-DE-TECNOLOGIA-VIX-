package ChallengeFinal.repository;

import ChallengeFinal.models.TicketPhone_Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketPhone_CarRepository extends JpaRepository<TicketPhone_Cart, Long> {
}
