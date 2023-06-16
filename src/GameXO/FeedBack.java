package GameXO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FeedBack extends JFrame {
    private int d=0;
    public FeedBack() {
        JPanel pane = new JPanel(new GridLayout(2,1));
        JLabel label = new JLabel("Do you like this game?");
        JPanel nothing = new JPanel();
        JPanel doULikeThis= new JPanel(new FlowLayout());
        doULikeThis.add(label);
        pane.add(nothing);
        pane.add(doULikeThis);
        JPanel pane2 = new JPanel(new FlowLayout());
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        JButton no2 = new JButton("No");
        JButton no3 = new JButton("No");
        no2.setVisible(false);
        no3.setVisible(false);
        JPanel Yes= new JPanel();
        JPanel No= new JPanel();
        JPanel No2= new JPanel();
        JPanel No3= new JPanel();
        Yes.add(yes);
        No.add(no);
        No2.add(no2);
        No3.add(no3);
        pane2.setLayout(new GridLayout(2,2));
        pane2.add(Yes); pane2.add(No);
        pane2.add(No2);pane2.add(No3);

        setLayout(new GridLayout(3,1));
        add(pane);
        add(pane2);
        setSize(400,270);

        setVisible(true);

        no.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (d==0) {
                    no.setVisible(false);
                    no2.setVisible(true);
                    d=1;
                }
            }
        });
        no2.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                  if (d==1){
                      no2.setVisible(false);
                      no3.setVisible(true);
                      d=2;
                  }
            }
        });
        no3.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
             if (d==2){
                 no3.setVisible(false);
                 no.setVisible(true);
                 d=0;
             }
            }
        });
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Thanks you, we love you too <3");
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        new FeedBack();
    }
}
