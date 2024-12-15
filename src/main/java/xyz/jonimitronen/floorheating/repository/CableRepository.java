// CableRepository.java
// Tämä luokka on tietokannan pääsyrajapinta. 
// Se sisältää metodeja, jotka mahdollistavat tietokannan CRUD-toiminnot (luominen, lukeminen, päivittäminen ja poistaminen) kaapeli-entiteeteille.
// Repository-rajapinta käyttää Spring Data JPA, ja se voi sisältää hakukyselyitä, kuten etsiä mm. kaapeleita id:n mukaan.
package xyz.jonimitronen.floorheating.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import xyz.jonimitronen.floorheating.entity.CableEntity;
import java.util.List;

public interface CableRepository extends CrudRepository<CableEntity, Integer> {

    Optional<CableEntity> findById(int id);

    @Query("SELECT d FROM CableEntity d ORDER BY d.pituus DESC")
    List<CableEntity> findAllByPituusInDescOrder();

}
