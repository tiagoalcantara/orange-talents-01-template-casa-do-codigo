package br.com.zup.casadocodigo.categoria.repositories;

import br.com.zup.casadocodigo.categoria.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
