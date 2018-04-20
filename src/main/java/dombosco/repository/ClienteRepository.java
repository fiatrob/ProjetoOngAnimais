package dombosco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dombosco.dominio.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
