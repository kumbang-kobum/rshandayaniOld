package fungsi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class WarnaTableKasirRalan extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row % 2 == 1) {
            component.setBackground(new Color(255, 244, 244));
        } else {
            component.setBackground(new Color(255, 255, 255));
        }

        component.setForeground(new Color(50, 50, 50)); // Foreground color for all rows

        Object valueAtColumn10 = table.getValueAt(row, 10);
        Object valueAtColumn15 = table.getValueAt(row, 15);
        Object valueAtColumn20 = table.getValueAt(row, 20);

        if (valueAtColumn10 != null) {
            String status = valueAtColumn10.toString();

            if (status.equals("Sudah")) {
                component.setBackground(new Color(200, 0, 0));
                component.setForeground(new Color(255, 230, 230));
            } else if (status.equals("Batal")) {
                component.setBackground(new Color(255, 243, 109));
                component.setForeground(new Color(120, 110, 50));
            } else if (status.equals("Dirujuk") || status.equals("Meninggal") || status.equals("Pulang Paksa")) {
                component.setBackground(new Color(152, 152, 156));
                component.setForeground(new Color(245, 245, 255));
            } else if (status.equals("Dirawat")) {
                component.setBackground(new Color(119, 221, 119));
                component.setForeground(new Color(245, 255, 245));
            }
        }

        if (valueAtColumn20 != null) {
            String value20 = valueAtColumn20.toString();

            if (value20.startsWith("0103R003")) {
                component.setBackground(new Color(0, 0, 255)); // Blue color
                component.setForeground(new Color(255, 255, 255));
            }
        }

        if(table.getValueAt(row,15).toString().equals("Sudah Bayar")){
            component.setBackground(new Color(50,50,50));
            component.setForeground(new Color(255,255,255));    
        }
        
        return component;
    }
}
