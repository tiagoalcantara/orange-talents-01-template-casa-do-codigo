package br.com.zup.casadocodigo.autor.repositories;

import br.com.zup.casadocodigo.autor.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
