package restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import restapi.model.Chamada;

@Repository
public interface ChamadaRepository extends CrudRepository<Chamada, Long>{

}
