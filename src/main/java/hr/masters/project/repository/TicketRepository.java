package hr.masters.project.repository;

import hr.masters.project.model.TicketModel;
import hr.masters.project.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketModel, Long>
{
    List<TicketModel> findByUser(UserModel userModel);
}
