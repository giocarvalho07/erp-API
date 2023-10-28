package com.erpai.repository;

import com.erpai.domain.TipoFornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFornecedorRepository extends JpaRepository<TipoFornecedor, Long> {
}
