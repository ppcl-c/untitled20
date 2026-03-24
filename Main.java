import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("STR");
        JButton button = new JButton("1");
        JButton button1 = new JButton("2");
        Random ra  =  new Random();
        final int[] hp = {10};
        JLabel hl = new JLabel(String.valueOf(hp[0]));
        JLabel label = new JLabel("敌人来了 作为将军的你有两个选项 1 跑 2 反击(50%成功)");
        frame.setSize(1290, 720);
        frame.setLayout(null);
        frame.add(label);
        frame.add(button);
        frame.add(button1);
        frame.add(hl);
        hl.setFont(new Font("宋体",Font.PLAIN, 24));
        hl.setBounds(0, 0, 1000,30);
        label.setBounds(350, 350, 1000, 30 );
        label.setFont(new Font("宋体", Font.PLAIN, 24));
        button1.setBounds(600, 450 , 100, 30);
        button.setBounds(500, 450, 100, 30);
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame,"没成功 督战队把你被抓住枪毙了");
            hp[0] -= 1;
            hl.setText(String.valueOf(hp[0]));
            if (hp[0] <= 0) {
                JOptionPane.showMessageDialog(frame,"你被枪毙了");
                System.exit(1);
            }
        });
        button1.addActionListener(e -> {
            int ram = ra.nextInt(101);
            if (ram <= 50) {
                JOptionPane.showMessageDialog(frame,"没成功 敌人把你被抓住枪毙了");
                hp[0] -= 1;
                if (hp[0] <= 0) {
                    JOptionPane.showMessageDialog(frame,"你被枪毙了");
                    System.exit(-1024);
                }
                hl.setText(String.valueOf(hp[0]));
            } else if(ram <= 100) {
                JOptionPane.showMessageDialog(frame,"你成功打跑了敌人 \n你赢了!!!!");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hl.setText(String.valueOf(hp[0]));
        hl.repaint();
        frame.setVisible(true);

    }
}