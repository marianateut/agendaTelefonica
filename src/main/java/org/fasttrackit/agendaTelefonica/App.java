package org.fasttrackit.agendaTelefonica;

import org.fasttrackit.agendaTelefonica.persistance.AgendaRepository;
import org.fasttrackit.agendaTelefonica.transfer.CreateAgendaRequest;
import org.fasttrackit.domain.Agenda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, IOException, ClassNotFoundException {
        CreateAgendaRequest request = new CreateAgendaRequest();
        request.setFirstName("dafi");
        request.setLastName("ana" );
        request.setNrTel("02313323");
        AgendaRepository agendaRepository=new AgendaRepository();
//        agendaRepository.createAgenda(request);
//        agendaRepository.updateAgenda(3,"0364400751");
//        agendaRepository.deleteAgenda("dafi","ana");
        List<Agenda> agendas = agendaRepository.getAgendas();

        System.out.println(agendas);


    }
}
