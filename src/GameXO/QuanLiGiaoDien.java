package GameXO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLiGiaoDien extends JFrame {
// kích thước của bàn cờ
    private final int rows=23;
    private final int columns=33;
    //mảng 2 chiều, để lưu các ô đã đánh(X là 2, O là 1)
    private int A[][]= new int[rows+5][columns+5];
    private int weight=2000;
    //biến d để lưu số bước đã đánh(d chẵn thì X đánh, lẻ thì O đánh)
    private int i,j,d=0;
    //lưu lại các giá trị Button đã khởi tạo, phục vụ chức năng reset lại ván cờ
    private JButton[][] buttons= new JButton[rows+5][columns+5];
    //lưu vị trí ô vừa mới đánh, phục vụ chức năng đánh lại
    private ToaDoVuaDanh kiemtradanhlai =new ToaDoVuaDanh();
QuanLiGiaoDien(){
    JPanel mainMenu = new JPanel();
    JButton newGame= new JButton("New Game");
    JButton exit= new JButton("Exit");
    JButton danhlai= new JButton("Undo");
    JLabel luotDanh= new JLabel("X danh truoc");
    FlowLayout flowLayout= new FlowLayout();
    flowLayout.setHgap(30);
    mainMenu.add(luotDanh);
    mainMenu.add(newGame);
    mainMenu.add(danhlai);
    mainMenu.add(exit);
    mainMenu.setLayout(flowLayout);
    //mainMenu.setBackground(Color.BLUE);

    add(mainMenu,BorderLayout.NORTH);
    JPanel jp= new JPanel(new GridLayout(rows,columns));

    newGame.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i2=1;i2<=rows;i2++)
                for (int j2=1;j2<=rows;j2++){
                    buttons[i2][j2].setLabel("");
                A[i2][j2]=0;
                }
            d=0;
            luotDanh.setText("X danh truoc");
        }
    });
    //thoát chương trình
    exit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new FeedBack();
        }
    });
    //làm sạch ô vừa mới đánh
    danhlai.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (d>0) {
                buttons[kiemtradanhlai.getX()][kiemtradanhlai.getY()].setLabel("");
                A[kiemtradanhlai.getX()][kiemtradanhlai.getY()]=0;
                if (luotDanh.getText().equals("O danh")) luotDanh.setText("X danh");
                else  luotDanh.setText("O danh");
                d--;
            }
        }
    });

    //khởi tạo bàn cờ
    for (i=1;i<=rows;i++)
    for (j=1;j<=columns;j++){
        ChessBox lb= new ChessBox();
        //lưu các nút vừa khởi tạo vào mảng 2 chiều
        buttons[i][j]= lb.getButton();
        //luư vị trí của các nút
        lb.setRow(i);
        lb.setColumn(j);
       // gắn chức năng điền X, O vào bàn cờ
        lb.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lb.getButton().getLabel().equals("")) {
                    if (d % 2 == 0) {
                        //lưu nút vừa đánh
                        kiemtradanhlai.setX(lb.getRow());
                        kiemtradanhlai.setY(lb.getColumn());
                        luotDanh.setText("O danh");
                        lb.getButton().setLabel("X");
                        A[lb.getRow()][lb.getColumn()] = 2;


                        if (checks(lb.getRow(), lb.getColumn()) == true) {
                            JOptionPane.showMessageDialog(null, "X win");
                            for (int i2=1;i2<=rows;i2++)
                                for (int j2=1;j2<=rows;j2++){
                                    buttons[i2][j2].setLabel("");
                                    A[i2][j2]=0;}
                            d=-1;
                            luotDanh.setText("X danh truoc");
System.out.println(d);
                        }
                    } else {
                        kiemtradanhlai.setX(lb.getRow());
                        kiemtradanhlai.setY(lb.getColumn());
                        luotDanh.setText("X danh");
                        lb.getButton().setLabel("O");
                        A[lb.getRow()][lb.getColumn()] = 1;

                        if (checks(lb.getRow(), lb.getColumn()) == true) {
                            JOptionPane.showMessageDialog(null, "O win");
                            for (int i2=1;i2<=rows;i2++)
                                for (int j2=1;j2<=rows;j2++){
                                    buttons[i2][j2].setLabel("");
                                    A[i2][j2]=0;}
                            d=-1;
                            luotDanh.setText("X danh truoc");
                            System.out.println(d);
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

//kiem tra chien thang
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
    while ((k<=columns)&&(A[row][k]==A[row][column])){
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
    while ((i1<=rows)&&(j1<=columns)&&(A[i1][j1]==A[row][column])){
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
    while ((i1>0)&&(j1<=columns)&&(A[i1][j1]==A[row][column])){
        d2++;i1--;j1++;
    }
    if (A[i1][j1]!=0) d3++;
    if ((d1+d2>=4)&&(d3<2)) return true;

return false;
}
}
