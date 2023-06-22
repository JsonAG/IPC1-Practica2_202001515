/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

import java.io.Serializable;
import javax.swing.table.DefaultTableModel;

public class SerializableTableModel extends DefaultTableModel implements Serializable {
    public SerializableTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
}

