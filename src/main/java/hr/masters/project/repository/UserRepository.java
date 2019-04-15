package hr.masters.project.repository;

import hr.masters.project.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long>
{
    UserModel findById(long id);

    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);

    @Override
    List<UserModel> findAll();
}