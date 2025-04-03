package com.thomazllr.ds_extratus.repository;

import com.thomazllr.ds_extratus.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
