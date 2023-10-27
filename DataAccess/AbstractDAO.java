package DataAccess;

import Connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AbstractDAO<T> {
    public Class<T> type;
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    private String createSelectQuery(String field) {
        return "SELECT " +
                "*" +
                " FROM " +
                type.getSimpleName() +
                " WHERE " +
                field +
                "=?";
    }
    private String createSelectAllQuery() {
        return "SELECT " +
                "*" +
                " FROM " +
                type.getSimpleName();
    }

    private String createInsertQuery() {
        StringBuilder res = new StringBuilder();
        res.append("INSERT INTO ");
        res.append(type.getSimpleName());
        res.append(" VALUES (");
        for(Field aux : type.getDeclaredFields()){
            res.append("?, ");
        }
        res.setLength(res.length() - 2);
        res.append(")");
        return res.toString();
    }

    private String createDeleteQuery(String field) {
        return "DELETE FROM " +
                type.getSimpleName() +
                " WHERE " +
                field +
                "=?";
    }

    private String createUpdateQuery(String field) {
        StringBuilder res = new StringBuilder();
        res.append("UPDATE ");
        res.append(type.getSimpleName());
        res.append(" SET ");
        for(Field aux : type.getDeclaredFields()){
            res.append(aux.getName() + "=?, ");
        }
        res.setLength(res.length() - 2);
        res.append(" WHERE ");
        res.append(field);
        res.append("=?");
        return res.toString();
    }

    public T findById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("ID");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException ignored) {
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    public List<T> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return createObjects(resultSet);
        } catch (SQLException ignored) {
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T insert(T obj){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(obj);
                    statement.setObject(i, value);
                    i++;
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            statement.executeUpdate();
            return obj;
        } catch (SQLException ignored) {
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T delete(T obj, String deleteField){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(deleteField);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                if(field.getName().equals(deleteField)) {
                    Object value;
                    try {
                        value = field.get(obj);
                        statement.setObject(i, value);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            statement.execute();
            return obj;
        } catch (SQLException ignored) {
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public T update(T obj, String updateField){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery(updateField);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int i = 1;
            int fieldValue = -1;
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    if(field.getName().equals(updateField)){
                        fieldValue = (int) field.get(obj);
                    }
                    value = field.get(obj);
                    statement.setObject(i, value);
                    i++;
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            statement.setObject(i, fieldValue);
            statement.executeUpdate();
            return obj;
        } catch (SQLException ignored) {
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (Constructor constructor : ctors) {
            ctor = constructor;
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                Objects.requireNonNull(ctor).setAccessible(true);
                T instance;
                instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

}
