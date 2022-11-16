package br.com.fiap.savecoin.repository;

import br.com.fiap.savecoin.model.Economia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EconomiaRepository extends JpaRepository<Economia, Integer> {

    Optional<Economia> findByReferenciaAndUsuarioUuid(String referencia, String usuario);

    List<Economia> findTop3ByUsuarioUuidOrderByIdDesc(String usuario);

}
