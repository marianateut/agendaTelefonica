package org.fasttrackit.agendaTelefonica.service;

import org.fasttrackit.agendaTelefonica.domain.Agenda;
import org.fasttrackit.agendaTelefonica.persistance.AgendaRepository;
import org.fasttrackit.agendaTelefonica.transfer.CreateAgendaRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AgendaService {
    private AgendaRepository agendaRepository = new AgendaRepository();

    public void createAgenda(CreateAgendaRequest request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Creating to-do-item:" + request);
        agendaRepository.createAgenda(request);
    }

    public void updateAgenda(long id, String request) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Updating agenda:" + request);
        agendaRepository.updateAgenda(id, request);
    }

    public void deleteAgenda(String first_name,String last_name) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting item "+first_name );
        agendaRepository.deleteAgenda(first_name,last_name);
    }

    public void deleteMoreContacts(long[] id) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Deleting phone contacts...");
        agendaRepository.deleteMoreContacts(id);
    }

    public List<Agenda> getAgendas() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving agenda...");
        return agendaRepository.getAgendas();
    }

    public List<Agenda> getAgendasByName(String first_name, String last_name) throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Retrieving agenda...");
        return agendaRepository.getAgendasByName(first_name,last_name);
    }
}
