package org.fasttrackit.agendaTelefonica.persistance;

import org.fasttrackit.agendaTelefonica.transfer.CreateAgendaRequest;
import org.fasttrackit.domain.Agenda;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaRepository {
    public void createAgenda(CreateAgendaRequest request) throws SQLException, IOException, ClassNotFoundException {
        String sql = " INSERT INTO agenda(first_name,last_name,nr_tel)VALUES(?,?,?)";
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, request.getFirstName());
            preparedStatement.setString(2, request.getLastName());
            preparedStatement.setString(3, request.getNrTel());
            preparedStatement.executeUpdate();
        }
    }

    public void updateAgenda(long id, String nr_tel) throws SQLException, IOException, ClassNotFoundException {
        String sql = "UPDATE agenda SET nr_tel=? WHERE id=?";
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nr_tel);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        }
    }

    public void deleteAgenda(String first_name,String last_name) throws SQLException, IOException, ClassNotFoundException {
        String sql = "DELETE FROM agenda  WHERE first_name=? and last_name=? ";
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,first_name);
            preparedStatement.setString(2,last_name);

            preparedStatement.executeUpdate();
        }
    }
    public List<Agenda> getAgendas() throws SQLException, IOException, ClassNotFoundException {
        String sql ="SELECT id, first_name, last_name, nr_tel FROM  agenda";

        List<Agenda> agendas = new ArrayList<>();

        try(Connection connection = DatabaseConfiguration.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                Agenda agenda = new Agenda();

                agenda.setId(resultSet.getLong("id"));
                agenda.setFirstName(resultSet.getString("first_name"));
                agenda.setLastName(resultSet.getString("last_name"));
                agenda.setNrTel(resultSet.getString("nr_tel"));

                agendas.add(agenda);
            }

        }
        return agendas;
    }
}
