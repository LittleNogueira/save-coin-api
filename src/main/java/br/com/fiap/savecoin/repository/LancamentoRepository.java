package br.com.fiap.savecoin.repository;

import br.com.fiap.savecoin.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    @Query(value = "SELECT * FROM lancamento " +
            "WHERE recorrencia IN ('DIARIA','MENSAL','SEMANAL') AND usuario_uuid = :usuario " +
            "OR (recorrencia = 'UNICA' AND referencia = :referencia AND usuario_uuid = :usuario) ", nativeQuery = true)
    List<Lancamento> findLancamentosByReferencia(@Param("referencia") String referencia, @Param("usuario") String usuario);


}
