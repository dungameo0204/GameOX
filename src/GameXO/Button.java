package GameXO;

import javax.swing.*;
// class này là 1 ô trong bàn cờ, gồm 1 button và vị trí của nó(xác định bởi hàng và cột)
public class Button {
    public Button() {
        this.button= new JButton("");

    }

    private int row;
    private int column;
    private JButton button;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }


}
