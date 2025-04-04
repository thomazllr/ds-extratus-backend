package com.thomazllr.ds_extratus.repository.specs;

import com.thomazllr.ds_extratus.model.Cliente;
import com.thomazllr.ds_extratus.model.Doenca;
import com.thomazllr.ds_extratus.model.DoencaCliente;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class ClienteSpecification {

    public static Specification<Cliente> nomeContains(String nome) {
        return (root, query, cb) -> {
            if (nome == null || nome.isBlank()) return null;
            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    public static Specification<Cliente> cpfEquals(String cpf) {
        return (root, query, cb) -> {
            if (cpf == null || cpf.isBlank()) return null;
            return cb.equal(root.get("cpf"), cpf);
        };
    }

    public static Specification<Cliente> temDoenca(String nomeDoenca) {
        return (root, query, cb) -> {
            if (nomeDoenca == null || nomeDoenca.isBlank()) return null;

            // Precisamos usar subquery já que não há relacionamento direto
            query.distinct(true);

            Subquery<Long> subquery = query.subquery(Long.class);
            Root<DoencaCliente> doencaClienteRoot = subquery.from(DoencaCliente.class);
            Join<DoencaCliente, Doenca> doencaJoin = doencaClienteRoot.join("doenca");

            subquery.select(doencaClienteRoot.get("cliente").get("id"))
                    .where(cb.like(cb.lower(doencaJoin.get("nome")), "%" + nomeDoenca.toLowerCase() + "%"));

            return root.get("id").in(subquery);
        };
    }
}
