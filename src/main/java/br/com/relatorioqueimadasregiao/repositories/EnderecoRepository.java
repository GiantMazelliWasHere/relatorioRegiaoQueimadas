package br.com.relatorioqueimadasregiao.repositories;

import br.com.relatorioqueimadasregiao.entities.Endereco;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    @Transactional
    Endereco findByCep(long cep);
}
