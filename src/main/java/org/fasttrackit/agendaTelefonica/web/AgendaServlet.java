package org.fasttrackit.agendaTelefonica.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.fasttrackit.agendaTelefonica.config.ObjectMapperConfiguration;
import org.fasttrackit.agendaTelefonica.domain.Agenda;
import org.fasttrackit.agendaTelefonica.service.AgendaService;
import org.fasttrackit.agendaTelefonica.transfer.CreateAgendaRequest;
import org.fasttrackit.agendaTelefonica.transfer.UpdateAgendaRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/agendas")

public class AgendaServlet extends HttpServlet {
    private AgendaService agendaService = new AgendaService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateAgendaRequest request = objectMapper.readValue(req.getReader(), CreateAgendaRequest.class);
        try {
            agendaService.createAgenda(request);
        } catch (SQLException | ClassNotFoundException e) {
           resp.sendError(500,"Internal Serve Error:"+e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");

        try {
            agendaService.deleteAgenda(first_name,last_name);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error:" + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
      // String nr_Tel= req.getParameter("nr_Tel");

        UpdateAgendaRequest request = ObjectMapperConfiguration.getObjectMapper().readValue(req.getReader(),
                UpdateAgendaRequest.class);

        try {
            agendaService.updateAgenda(Long.parseLong(id), String.valueOf(request));
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error:" + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Agenda> agendas = agendaService.getAgendas();

            String response = ObjectMapperConfiguration.getObjectMapper().writeValueAsString(agendas);

            resp.getWriter().print(response);

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(500, "Internal Server Error:" + e.getMessage());
        }
    }
}
