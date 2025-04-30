package br.univille.projetofabsoftebooksjulia.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetofabsoftebooksjulia.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}