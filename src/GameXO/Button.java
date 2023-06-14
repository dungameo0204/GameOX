package GameXO;

import javax.swing.*;

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
