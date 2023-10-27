/**
 The ProductBLL class is responsible for managing the business logic for the ProductDAO class.
 */
package Logic;

import DataAccess.ProductDAO;

import Model.MProduct;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {
    ProductDAO product;
    /**
     * Constructor for the ProductBLL class.
     * Instantiates a new ProductDAO object.
     */
    public ProductBLL() {
        product = new ProductDAO();
    }

    /**
     * Finds a product by its id.
     *
     * @param id The id of the product to be found.
     * @return The MProduct object representing the product with the specified id.
     * @throws NoSuchElementException if the product with the specified id is not found.
     */
    public MProduct findProductById(int id) {
        MProduct st = product.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id=" + id + " was not found!");
        }
        return st;
    }

    /**
     * Finds all products.
     *
     * @return The list of all MProduct objects.
     * @throws NoSuchElementException if the product list is empty.
     */
    public List<MProduct> findAllProducts() {
        List<MProduct> st = product.findAll();
        if (st == null) {
            throw new NoSuchElementException("The product list is empty.");
        }
        return st;
    }

    /**
     * Inserts a new product into the database.
     *
     * @param insertedProduct The MProduct object representing the product to be inserted.
     * @return The id of the newly inserted product.
     */
    public int insertProduct(MProduct insertedProduct) {
        MProduct st = product.insert(insertedProduct);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Deletes a product from the database.
     *
     * @param deletedProduct The MProduct object representing the product to be deleted.
     * @param field The field to be used as the deletion criteria.
     * @return The id of the deleted product.
     */
    public int deleteProduct(MProduct deletedProduct, String field) {
        MProduct st = product.delete(deletedProduct, field);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Updates a product in the database.
     *
     * @param updatedProduct The MProduct object representing the product to be updated.
     * @param field The field to be used as the update criteria.
     * @return The id of the updated product.
     */
    public int updateProduct(MProduct updatedProduct, String field) {
        MProduct st = product.update(updatedProduct, field);
        if (st == null) {
            return -1;
        }
        return st.getID();
    }

    /**
     * Prints a product by its id.
     *
     * @param id The id of the product to be printed.
     * @throws NoSuchElementException if the product with the specified id is not found.
     */
    public void printProductByID(int id) {
        MProduct st = product.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The product with id=" + id + " was not found!");
        }
        System.out.println(st);
    }

    /**
     * Prints all products.
     *
     * @throws NoSuchElementException if the product list is empty.
     */
    public void printAllProducts() {
        List<MProduct> st = product.findAll();
        if (st == null) {
            throw new NoSuchElementException("The product list is empty.");
        }
        for (MProduct iterator : st) {
            System.out.println(iterator);
        }
    }
}
