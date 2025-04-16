package br.univille.projetofabsoftebooksjulia.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projetofabsoftebooksjulia.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
