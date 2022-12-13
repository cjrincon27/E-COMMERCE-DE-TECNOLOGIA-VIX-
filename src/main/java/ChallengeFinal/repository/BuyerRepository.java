package ChallengeFinal.repository;

import ChallengeFinal.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Buyer findByEmail(String email);
}
