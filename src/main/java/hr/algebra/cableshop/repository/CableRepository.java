package hr.algebra.cableshop.repository;

import hr.algebra.cableshop.domain.Cable;
import org.springframework.data.repository.CrudRepository;

public interface CableRepository extends CrudRepository <Cable,Long> {
}
