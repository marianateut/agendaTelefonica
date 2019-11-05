package org.fasttrackit.agendaTelefonica.transfer;

public class CreateAgendaRequest {
    private  String firstName;
    private String lastName;
    private String nrTel;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    @Override
    public String toString() {
        return "CreateAgendaRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nrTel='" + nrTel + '\'' +
                '}';
    }
}
