package ChallengeFinal.repository;

import ChallengeFinal.models.Accessory;
import ChallengeFinal.models.AccessoryImageAndColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccessoryImageAndColorRepository extends JpaRepository<AccessoryImageAndColor,Long> {
    public AccessoryImageAndColor findByAccessory(Accessory accessory);

}
