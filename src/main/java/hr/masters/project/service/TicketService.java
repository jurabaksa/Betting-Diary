package hr.masters.project.service;

import hr.masters.project.model.TicketModel;
import hr.masters.project.model.UserModel;

import java.util.List;

public interface TicketService
{
    List<TicketModel> getTicketsByUser(final UserModel userModel);
}
