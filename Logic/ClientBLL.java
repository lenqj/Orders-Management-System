/**
 The ClientBLL class represents the business logic layer for the client entity.
 It interacts with the data access layer to perform CRUD (Create, Read, Update, Delete) operations.
 */
package Logic;

import DataAccess.ClientDAO;
import Model.MClient;

import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    ClientDAO client;
    /**
     * Constructs a ClientBLL object and initializes its data access object.
     */
    public ClientBLL() {
        client = new ClientDAO();
    }

    /**
     * Finds a client with the specified ID.
     * @param id the ID of the client to be found
     * @return the client with the specified ID
     * @throws NoSuchElementException if the client with the specified ID is not found
     */
    public MClient findClientById(int id) {
        MClient st = client.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id=" + id + " was not found!");
        }
        return st;
    }

    /**
     * Retrieves a list of all clients.
     * @return a list of all clients
     * @throws NoSuchElementException if the client list is empty
     */
    public List<MClient> findAllClients() {
        List<MClient> st = client.findAll();
        if (st == null) {
            throw new NoSuchElementException("The client list is empty.");
        }
        return st;
    }

    /**
     * Inserts a new client into the database.
     * @param insertedClient the client to be inserted
     * @return the ID of the inserted client
     */
    public int insertClient(MClient insertedClient) {
        MClient st = client.insert(insertedClient);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Deletes a client from the database.
     * @param deletedClient the client to be deleted
     * @param field the field to be used as a criteria for deletion
     * @return the ID of the deleted client
     */
    public int deleteClient(MClient deletedClient, String field) {
        MClient st = client.delete(deletedClient, field);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Updates a client in the database.
     * @param updatedClient the client to be updated
     * @param field the field to be used as a criteria for update
     * @return the ID of the updated client
     */
    public int updateClient(MClient updatedClient, String field) {
        MClient st = client.update(updatedClient, field);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Prints the client with the specified ID to the console.
     * @param id the ID of the client to be printed
     * @throws NoSuchElementException if the client with the specified ID is not found
     */
    public void printClientByID(int id) {
        MClient st = client.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The client with id=" + id + " was not found!");
        }
        System.out.println(st);
    }

    /**
     * Prints all clients to the console.
     * @throws NoSuchElementException if the client list is empty
     */
    public void printAllClients() {
        List<MClient> st = client.findAll();
        if (st == null) {
            throw new NoSuchElementException("The client list is empty.");
        }
        for(MClient iterator: st) {
            System.out.println(iterator);
        }
    }
}
