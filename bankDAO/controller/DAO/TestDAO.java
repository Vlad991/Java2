package ua.univer.controller.DAO;

import ua.univer.model.administrator.Administrator;
import ua.univer.model.client.Client;

public class TestDAO {

	public static void main(String[] args) throws Exception {
		ClientDAO clientDAO = new ClientDAO();
        Client vasya = clientDAO.getClientByName("Vasya");
        System.out.println(vasya);
	}

}
