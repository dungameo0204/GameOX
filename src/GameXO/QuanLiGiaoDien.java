package GameXO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLiGiaoDien extends JFrame {

    private static final int rows=30;
    private int A[][]= new int[rows+10][rows+10];
    private int weight=1500;
    private int i,j,d=0;

QuanLiGiaoDien(){
    JPanel jp= new JPanel(new GridLayout(rows,rows));
    for (i=1;i<=rows;i++)
    for (j=1;j<=rows;j++){
        Button lb= new Button();

        lb.setRow(i);
        lb.setColumn(j);
        lb.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lb.getButton().getText().equals("")) {
                    if (d % 2 == 0) {
                        lb.getButton().setText("X");
                        A[lb.getRow()][lb.getColumn()] = 2;
                        if (checks(lb.getRow(), lb.getColumn()) == true) {
                            JOptionPane.showMessageDialog(null, "X win");
                            System.exit(0);
                        }
                    } else {
                        lb.getButton().setText("O");
                        A[lb.getRow()][lb.getColumn()] = 1;

                        if (checks(lb.getRow(), lb.getColumn()) == true) {
                            JOptionPane.showMessageDialog(null, "O win");
                            System.exit(0);
                        }
                    }
                    ;
                    d++;
                }

            }
        });

        jp.add(lb.getButton());

    }
    add(jp);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(weight,weight);

}
    int k,d1,d2,i1,j1,d3;
public boolean checks(int row,int column){
//kt chieu doc
 k=row-1;d1=0;d2=0;d3=0;
while ((k>0)&&(A[k][column]==A[row][column])){
    d1++;k--;
    }
    if(A[k][column]!=0 )d3++;
    k=row+1;
while ((k<=rows)&&(A[k][column]==A[row][column])){
        d2++;k++;
    }
    if(A[k][column]!=0) d3++;
if ((d1+d2>=4)&&(d3<2))return true;
//kt chieu ngang
    k=column-1;d1=0;d2=0;d3=0;
    while ((k>0)&&(A[row][k]==A[row][column])){
        d1++;k--;
    }
    if (A[row][k]!=0) d3++;
    k=column+1;
    while ((k<=rows)&&(A[row][k]==A[row][column])){
        d2++;k++;
    }
    if (A[row][k]!=0) d3++;
    if ((d1+d2>=4)&&(d3<2))return true;
    //kt cheo 45 do
    i1=row-1;j1=column-1;d1=0;d2=0;d3=0;
    while ((i1>0)&&(j1>0)&&(A[i1][j1]==A[row][column])){
        d1++;i1--;j1--;
    }
    if (A[i1][j1]!=0) d3++;
    i1=row+1;j1=column+1;
    while ((i1<=rows)&&(j1<=rows)&&(A[i1][j1]==A[row][column])){
        d2++;i1++;j1++;
    }
    if (A[i1][j1]!=0) d3++;
    if ((d1+d2>=4)&&(d3<2)) return true;
    //kt cheo 135 do
    i1=row+1;j1=column-1;d1=0;d2=0;d3=0;
    while ((i1<=rows)&&(j1>0)&&(A[i1][j1]==A[row][column])){
        d1++;i1++;j1--;
    }
    if (A[i1][j1]!=0) d3++;
    i1=row-1;j1=column+1;
    while ((i1>0)&&(j1<=rows)&&(A[i1][j1]==A[row][column])){
        d2++;i1--;j1++;
    }
    if (A[i1][j1]!=0) d3++;
    if ((d1+d2>=4)&&(d3<2)) return true;

return false;

}



}
