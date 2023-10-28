package com.erpai.repository;

import com.erpai.domain.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {
}
