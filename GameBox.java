import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class GameBox extends JFrame {
    public double Score = 0;
    public int add = 1;
    public double SecondAdd = 0.0;
    Timer timer2 = new Timer();
    Timer timer1 = new Timer();
    Timer timer3 = new Timer();
    JLabel Score1 = new JLabel((int)Math.floor(Score) + " Cookies");
    JLabel Second = new JLabel("Per second: " + SecondAdd);
    ImageIcon img1 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Background.png");
    ImageIcon img2 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Cookie.png");
    ImageIcon img3 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Pointer.png");
    ImageIcon img4 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Grandma.png");
    ImageIcon img5 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Farm.png");
    ImageIcon img6 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Cookie2.png");
    ImageIcon img7 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Next.png");
    ImageIcon img8 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Next2.png");
    ImageIcon img9 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Mine.png");
    ImageIcon img10 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Factory.png");
    ImageIcon img11 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Bank.png");
    ImageIcon img12 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\RIF.png");
    ImageIcon img13 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\PinkCursor.png");
    ImageIcon img14 = new ImageIcon("C:\\Users\\duama\\Documents\\VS Code\\VS Java\\Cookie Clicker\\Grandma1.png");
    JButton RIF = new JButton(img12);
    JButton PinkCursor = new JButton(img13);
    JButton Grandma1 = new JButton(img14);
    public int CursorCounter = 0;
    public int GrandmaCounter = 0;
    public int FarmCounter = 0;
    public int MineCounter = 0;
    public int FactoryCounter = 0;
    public int BankCounter = 0;
    JButton Store = new JButton("Store");
    StorePanel s = new StorePanel(this);
    JButton Cursor = new JButton("Cursor");
    JButton Grandma = new JButton("Grandma");
    JButton Farm = new JButton("Farm");
    JButton Factory = new JButton("Factory");
    JButton Bank = new JButton("Bank");
    JButton Mine = new JButton("Mine");
    JButton Next = new JButton(img7);
    JButton Next2 = new JButton(img8);
    public double BaseCursorPrice = 15;
    public double BaseGrandmaPrice = 100;
    public double BaseFarmPrice = 1100;
    public double BaseMinePrice = 12000;
    public double BaseFactoryPrice = 130000;
    public double BaseBankPrice = 1400000;
    public double CursorPrice;
    public double GrandmaPrice;
    public double FarmPrice;
    public double MinePrice;
    public double FactoryPrice;
    public double BankPrice;
    JLabel CursorPriceLabel = new JLabel("🍪 " + (int)CursorPrice);
    JLabel GrandmaPriceLabel = new JLabel("🍪 " + (int)GrandmaPrice);
    JLabel FarmPriceLabel = new JLabel("🍪 " + (int)GrandmaPrice);
    JLabel MinePriceLabel = new JLabel("🍪 " + (int)MinePrice);
    JLabel FactoryPriceLabel = new JLabel("🍪 " + (int)FactoryPrice);
    JLabel BankPriceLabel = new JLabel("🍪 " + (int)BankPrice);
    JButton CookieButton = new JButton(img2);
    JLabel lab = new JLabel();
    InfoPanel I = new InfoPanel(lab);
    GameBox() {
      add(I);
      I.setVisible(false);
      RIF.setBounds(50, 160, 50, 50);
      RIF.setFocusable(false);
      RIF.addMouseListener(new java.awt.event.MouseAdapter() {
          public void mouseEntered(java.awt.event.MouseEvent evt) {
            lab.setText("<html>Reinforced Index Finger<br/>The mouse and cursors are twice as efficient</html>");
              I.setVisible(true);
              lab.repaint();
          }
          public void mouseExited(java.awt.event.MouseEvent evt) {
              I.setVisible(false);
          }
      });
      add(RIF);
      PinkCursor.setBounds(110, 160, 50, 50);
      PinkCursor.setFocusable(false);
      add(PinkCursor);
      Grandma1.setBounds(170, 160, 50, 50);
      Grandma1.setFocusable(false);
      add(Grandma1);
      RIF.setVisible(false);
      PinkCursor.setVisible(false);
      Grandma1.setVisible(false);
      add(s);
      add(Score1);
      add(Second);
      getContentPane().add(new MyCanvas());
      setSize(400, 700);
      repaint();
      setTitle("Cookie Clicker");
      setResizable(false);
      setVisible(true);
      setLayout(null);
      JLabel Imgl = new JLabel(img1);
      Imgl.setBounds(0, 0, 400, 700);
      getContentPane().add(new MyCanvas());
        Score1.setFont(new Font("Merriweather", Font.BOLD, 20));
        Score1.setForeground(Color.WHITE);
        Second.setFont(new Font("Merriweather", Font.BOLD, 15));
        Second.setForeground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(false);
        Store.setFont(new Font("Merriweather", Font.BOLD, 15));
        Store.setFocusable(false);
        Store.setBounds(10, 10, 100, 30);
        Store.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            if(s.isVisible()) {
            s.setVisible(false);
            StoreButtonsOff();
            }
            else {
            s.setVisible(true);
            StoreButtonsOn();
            }
              }
              });
        add(Store);
        CookieButton.setOpaque(false);
        CookieButton.setContentAreaFilled(false);
        CookieButton.setBorderPainted(false);
        CookieButton.setFocusable(false);
        CookieButton.setBounds(100, 250, 200, 200);
        CookieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Score += add;
                Score1.setText((int)Math.floor(Score) + " Cookies");
                timer3.cancel();
                timer3 = new Timer();
                TimerTask task3 = new TimerTask() {
                  @Override
                  public void run() {
                  CookieButton.setIcon(img2);
                  timer3.cancel();
                  }
                };
                CookieButton.setIcon(img6);
                timer3.scheduleAtFixedRate(task3, 70, 70);
                }
                });
                repaint();
        add(CookieButton);
        CursorPriceLabel.setFont(new Font("Merriweather", Font.BOLD, 15));
    CursorPriceLabel.setForeground(Color.WHITE);
    CursorPriceLabel.setBounds(10, 540, 100, 30);
    add(CursorPriceLabel);
    GrandmaPriceLabel.setFont(new Font("Merriweather", Font.BOLD, 15));
    GrandmaPriceLabel.setForeground(Color.WHITE);
    GrandmaPriceLabel.setBounds(120, 540, 100, 30);
    add(GrandmaPriceLabel);
    FarmPriceLabel.setFont(new Font("Merriweather", Font.BOLD, 15));
    FarmPriceLabel.setForeground(Color.WHITE);
    FarmPriceLabel.setBounds(230, 540, 100, 30);
    add(FarmPriceLabel);
    Next.setFocusable(false);
    Next.setBounds(340, 570, 30, 70);
    Next.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
            ButtonSet2();
          }
          });
    add(Next);
    Score1.setBounds(150, 50, 200, 30);
    Second.setBounds(140, 80, 200, 30);
    Cursor.setBounds(10, 570, 100, 70);
    Cursor.setIcon(img3);
    Cursor.setFocusable(false);
    Cursor.setVerticalTextPosition(JButton.BOTTOM);
    Cursor.setHorizontalTextPosition(JButton.CENTER);
    Cursor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          Score -= CursorPrice;
          CursorCounter++;
          SecondAdd += 0.1;
          Second.setText("Per second: " + (double)Math.round(SecondAdd * 10) /10);
          Secondly();
          }
          });
    add(Cursor);
    Farm.setBounds(230, 570, 100, 70);
    Farm.setIcon(img5);
    Farm.setFocusable(false);
    Farm.setVerticalTextPosition(JButton.BOTTOM);
    Farm.setHorizontalTextPosition(JButton.CENTER);
    Farm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          Score -= FarmPrice;
          FarmCounter++;
          SecondAdd += 8;
          Second.setText("Per second: " + (double)Math.round(SecondAdd * 10) /10);
          Secondly();
          }
          });
    add(Farm);
    Grandma.setBounds(120, 570, 100, 70);
    Grandma.setIcon(img4);
    Grandma.setFocusable(false);
    Grandma.setVerticalTextPosition(JButton.BOTTOM);
    Grandma.setHorizontalTextPosition(JButton.CENTER);
    Grandma.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          Score -= GrandmaPrice;
          GrandmaCounter++;
          SecondAdd += 1;
          Second.setText("Per second: " + (double)Math.round(SecondAdd * 10) /10);
          Secondly();
          }
          });
    add(Grandma);
    CursorPriceLabel.setVisible(false);
    GrandmaPriceLabel.setVisible(false);
    FarmPriceLabel.setVisible(false);
    Next.setVisible(false);
    Cursor.setVisible(false);
    Grandma.setVisible(false);
    Farm.setVisible(false);
    Next2.setFocusable(false);
    repaint();
    Next2.setBounds(10, 570, 30, 70);
    Next2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
            ButtonSet1();
          }
          });
    add(Next2);
    MinePriceLabel.setFont(new Font("Merriweather", Font.BOLD, 15));
    MinePriceLabel.setForeground(Color.WHITE);
    MinePriceLabel.setBounds(50, 540, 100, 30);
    add(MinePriceLabel);
    FactoryPriceLabel.setFont(new Font("Merriweather", Font.BOLD, 15));
    FactoryPriceLabel.setForeground(Color.WHITE);
    FactoryPriceLabel.setBounds(160, 540, 100, 30);
    add(FactoryPriceLabel);
    BankPriceLabel.setFont(new Font("Merriweather", Font.BOLD, 15));
    BankPriceLabel.setForeground(Color.WHITE);
    BankPriceLabel.setBounds(270, 540, 100, 30);
    add(BankPriceLabel);
    Mine.setBounds(50, 570, 100, 70);
    Mine.setIcon(img9);
    Mine.setFocusable(false);
    Mine.setVerticalTextPosition(JButton.BOTTOM);
    Mine.setHorizontalTextPosition(JButton.CENTER);
    Mine.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          Score -= MinePrice;
          MineCounter++;
          SecondAdd += 47;
          Second.setText("Per second: " + (double)Math.round(SecondAdd * 10) /10);
          Secondly();
          }
          });
    add(Mine);
    Factory.setBounds(160, 570, 100, 70);
    Factory.setIcon(img10);
    Factory.setFocusable(false);
    Factory.setVerticalTextPosition(JButton.BOTTOM);
    Factory.setHorizontalTextPosition(JButton.CENTER);
    Factory.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          Score -= FactoryPrice;
          FactoryCounter++;
          SecondAdd += 260;
          Second.setText("Per second: " + (double)Math.round(SecondAdd * 10) /10);
          Secondly();
          }
          });
    add(Factory);
    Bank.setBounds(270, 570, 100, 70);
    Bank.setIcon(img11);
    Bank.setFocusable(false);
    Bank.setVerticalTextPosition(JButton.BOTTOM);
    Bank.setHorizontalTextPosition(JButton.CENTER);
    Bank.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          Score -= BankPrice;
          BankCounter++;
          SecondAdd += 1400;
          Second.setText("Per second: " + (double)Math.round(SecondAdd * 10) /10);
          Secondly();
          }
          });
    add(Bank);
    MinePriceLabel.setVisible(false);
    BankPriceLabel.setVisible(false);
    FactoryPriceLabel.setVisible(false);
    Factory.setVisible(false);
    Mine.setVisible(false);
    Next2.setVisible(false);
        ButtonSet1();
        add(Imgl);
        SetClickable();
    }
    public void Secondly() {
    timer2.cancel();
    timer2 = new Timer();
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        Score += 1;
        Score1.setText((int)Math.floor(Score) + " Cookies");
        SetClickable();
      }
    };
    timer2.scheduleAtFixedRate(task, 0, (int)Math.floor(1000 / SecondAdd));
    }
    public void SetClickable() {
    timer1.cancel();
    timer1 = new Timer();
    TimerTask task1 = new TimerTask() {
      @Override
      public void run() {
        if (RIF.isVisible()) 
          CookieButton.setEnabled(false);
        else
        CookieButton.setEnabled(true);
        if (Score < GrandmaPrice)
        Grandma.setEnabled(false);
        else
        Grandma.setEnabled(true);
        if (Score < CursorPrice)
        Cursor.setEnabled(false);
        else
        Cursor.setEnabled(true);
        if (Score < FarmPrice)
        Farm.setEnabled(false);
        else
        Farm.setEnabled(true);
        if (Score < MinePrice)
        Mine.setEnabled(false);
        else
        Mine.setEnabled(true);
        if (Score < FactoryPrice)
        Factory.setEnabled(false);
        else
        Factory.setEnabled(true);
        if (Score < BankPrice)
        Bank.setEnabled(false);
        else
        Bank.setEnabled(true);
        PriceTag();
        CursorPriceLabel.setText("🍪 " + (int)CursorPrice);
        GrandmaPriceLabel.setText("🍪 " + (int)GrandmaPrice);
        FarmPriceLabel.setText("🍪 " + (int)FarmPrice);
        MinePriceLabel.setText("🍪 " + (int)MinePrice);
        FactoryPriceLabel.setText("🍪 " + (int)FactoryPrice);
        BankPriceLabel.setText("🍪 " + (int)BankPrice);
        Score1.setText((int)Math.floor(Score) + " Cookies");
      }
    };
    timer1.scheduleAtFixedRate(task1, 0, 1);
  }
  public void ButtonSet1() {
    CursorPriceLabel.setVisible(true);
    GrandmaPriceLabel.setVisible(true);
    FarmPriceLabel.setVisible(true);
    Next.setVisible(true);
    Cursor.setVisible(true);
    Grandma.setVisible(true);
    Farm.setVisible(true);
    Next2.setVisible(false);
    Mine.setVisible(false);
    Factory.setVisible(false);
    Bank.setVisible(false);
    MinePriceLabel.setVisible(false);
    FactoryPriceLabel.setVisible(false);
    BankPriceLabel.setVisible(false);
  }
  public void ButtonSet2() {
    CursorPriceLabel.setVisible(false);
    GrandmaPriceLabel.setVisible(false);
    FarmPriceLabel.setVisible(false);
    Next.setVisible(false);
    Cursor.setVisible(false);
    Grandma.setVisible(false);
    Farm.setVisible(false);
    MinePriceLabel.setVisible(true);
    FactoryPriceLabel.setVisible(true);
    BankPriceLabel.setVisible(true);
    Next2.setVisible(true);
    Mine.setVisible(true);
    Factory.setVisible(true);
    Bank.setVisible(true);
  }
  public void PriceTag() {
    CursorPrice = BaseCursorPrice * Math.pow(1.15, CursorCounter);
    GrandmaPrice = BaseGrandmaPrice * Math.pow(1.15, GrandmaCounter);
    FarmPrice = BaseFarmPrice * Math.pow(1.15, FarmCounter);
    MinePrice = BaseMinePrice * Math.pow(1.15, MineCounter);
    FactoryPrice = BaseFactoryPrice * Math.pow(1.15, FactoryCounter);
    BankPrice = BaseBankPrice * Math.pow(1.15, BankCounter);
  }
  public void StoreButtonsOn() {
    RIF.setVisible(true);
    PinkCursor.setVisible(true);
    Grandma1.setVisible(true);
  }
  public void StoreButtonsOff() {
    RIF.setVisible(false);
    PinkCursor.setVisible(false);
    Grandma1.setVisible(false);
  }
}