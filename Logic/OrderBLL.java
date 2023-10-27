/**

 This class represents the business logic layer for orders.
 */

package Logic;

import DataAccess.OrderDAO;
import Model.MOrder;

import java.util.List;
import java.util.NoSuchElementException;

public class OrderBLL {
    OrderDAO order;
    /**
     * Constructor for the OrderBLL class.
     */
    public OrderBLL() {
        order = new OrderDAO();
    }

    /**
     * Finds an order by its ID.
     * @param id the ID of the order to be found
     * @return the found order
     * @throws NoSuchElementException if the order with the specified ID was not found
     */
    public MOrder findOrderById(int id) {
        MOrder st = order.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The order with id=" + id + " was not found!");
        }
        return st;
    }

    /**
     * Finds all the orders in the database.
     * @return the list of all orders
     * @throws NoSuchElementException if the order list is empty
     */
    public List<MOrder> findAllOrders() {
        List<MOrder> st = order.findAll();
        if (st == null) {
            throw new NoSuchElementException("The order list is empty.");
        }
        return st;
    }

    /**
     * Inserts a new order into the database.
     * @param insertedOrder the order to be inserted
     * @return the ID of the inserted order, or -1 if the insertion failed
     */
    public int insertOrder(MOrder insertedOrder) {
        MOrder st = order.insert(insertedOrder);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Deletes an order from the database.
     * @param deletedOrder the order to be deleted
     * @param field the field used to delete the order (e.g. "id" or "name")
     * @return the ID of the deleted order, or -1 if the deletion failed
     */
    public int deleteOrder(MOrder deletedOrder, String field) {
        MOrder st = order.delete(deletedOrder, field);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Updates an order in the database.
     * @param updatedOrder the order to be updated
     * @param field the field used to update the order (e.g. "id" or "name")
     * @return the ID of the updated order, or -1 if the update failed
     */
    public int updateOrder(MOrder updatedOrder, String field) {
        MOrder st = order.update(updatedOrder, field);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Prints an order by its ID.
     * @param id the ID of the order to be printed
     * @throws NoSuchElementException if the order with the specified ID was not found
     */
    public void printOrderByID(int id) {
        MOrder st = order.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The order with id=" + id + " was not found!");
        }
        System.out.println(st);
    }

    /**
     * Prints all the orders in the database.
     * @throws NoSuchElementException if the order list is empty
     */
    public void printAllOrders() {
        List<MOrder> st = order.findAll();
        if (st == null) {
            throw new NoSuchElementException("The order list is empty.");
        }
        for(MOrder iterator: st) {
            System.out.println(iterator);
        }
    }
}
