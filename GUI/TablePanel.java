package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class TablePanel<T> extends JPanel {

    JTable objectTable;
    DefaultTableModel dtm;
    public Class<T> type;
    @SuppressWarnings("unchecked")
    protected TablePanel() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        JPanel panel = new JPanel();
        dtm = new DefaultTableModel(null, getTableHeader());
        objectTable = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(objectTable);
        panel.add(scrollPane);
        add(panel);
    }
    public String[] getTableHeader(){
        String[] result = new String[type.getDeclaredFields().length];
        int i = 0;
        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            result[i] = field.getName();
            i++;
        }
        return result;
    }
    public void setJTable(List<T> obj) {
        dtm.setRowCount(0);
        for (T object : obj) {
            int k = 0;
            Object[] columnDataAsArray = new Object[type.getDeclaredFields().length];
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    columnDataAsArray[k++] = field.get(2);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            dtm.addRow(columnDataAsArray);
        }
    }
}

