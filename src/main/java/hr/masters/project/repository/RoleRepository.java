package hr.masters.project.repository;

import hr.masters.project.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long>
{
    RoleModel findByRole(String role);
}