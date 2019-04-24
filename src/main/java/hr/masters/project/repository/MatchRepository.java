package hr.masters.project.repository;

import hr.masters.project.model.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<MatchModel, Long>
{
    List<MatchModel> findByTicket_Ticket(String ticket);
}
