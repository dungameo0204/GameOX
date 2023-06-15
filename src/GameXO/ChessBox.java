package GameXO;
import javax.swing.*;
import java.awt.*;
// class này là 1 ô trong bàn cờ, gồm 1 button và vị trí của nó(xác định bởi hàng và cột)
public class ChessBox {
    public ChessBox() {
        this.button= new JButton("");
        this.button.setBackground(Color.WHITE);
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
