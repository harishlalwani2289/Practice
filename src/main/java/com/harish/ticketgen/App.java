package com.harish.ticketgen;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class App extends JFrame implements ActionListener{
 private JPanel pnlBoard, pnlButton;
 private JButton btnNext, btnReset;
 private JLabel lbl[] = new JLabel[90];
 private JLabel lblNumber;
 private int[] random_number = new int[90];
 private int pos = 0;
 private List<Integer> calledNumbers = new ArrayList<>();
 private List<Prize> prizeList = new ArrayList<Prize>();
 List<Ticket> ticketsWon;
 
 public App(String title){
  super(title);
  setVisible(true);
  setSize(700,700);
  setLayout(new BorderLayout());
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  addElements();

  // Keep the prize list populated to check
  //prizeList = PrizeExcel.getAllPrizes();
  //pack();
 }
 
 public void addElements(){
  
  lblNumber = new JLabel("Lockdown Tambola");
  lblNumber.setHorizontalAlignment(0);
  lblNumber.setFont(new Font("Cambria",Font.BOLD,28));
  lblNumber.setForeground(Color.BLUE);
  add(lblNumber,BorderLayout.NORTH);
  
  pnlBoard = new JPanel();
  pnlBoard.setLayout(new GridLayout(9,11));
  add(pnlBoard,BorderLayout.CENTER);
  
  for(int i = 0 ; i < random_number.length ; i++){   
   lbl[i] = new JLabel(""+(i+1));
   lbl[i].setHorizontalAlignment(0);
   pnlBoard.add(lbl[i]);
   lbl[i].setOpaque(true);
   lbl[i].setBackground(Color.WHITE);
   lbl[i].setFont(new Font("Cambria",Font.BOLD,28));
   random_number[i] = i;
  } 
   
  Random rnd = new Random();
     for (int i = random_number.length - 1 ; i > 0 ; i--){
         int index = rnd.nextInt(i + 1);
         int a = random_number[index];
         random_number[index] = random_number[i];
         random_number[i] = a;
      System.out.println(random_number[i] + 1);
     } 
      
     pnlButton = new JPanel();
     add(pnlButton,BorderLayout.SOUTH);
     pnlButton.setLayout(new GridLayout(2,2));
   
  btnNext = new JButton("Next");  
  pnlButton.add(btnNext);
  btnNext.addActionListener(this);
  
  /*btnReset = new JButton("Reset");
  btnReset.addActionListener(this);
  pnlButton.add(btnReset);*/
  
  lblNumber = new JLabel("Chosen Number: " +(random_number[pos] + 1));
  lblNumber.setForeground(Color.RED);
  lbl[random_number[pos]].setBackground(Color.BLACK);
  lbl[random_number[pos]].setForeground(Color.WHITE);
  ExcelNumberHighlight.highlightThePickedNumber(random_number[pos]+1);
  pnlButton.add(lblNumber);
 }

 public void actionPerformed(ActionEvent e){
  String command = e.getActionCommand();
  
  if(command == "Next"){
   if(pos > 1) {
    lbl[random_number[pos-2]].setBackground(Color.BLACK);
    lbl[random_number[pos-2]].setForeground(Color.WHITE);
    lbl[random_number[pos - 1]].setBackground(Color.RED);
    lbl[random_number[pos - 1]].setForeground(Color.BLACK);
   }
   ExcelNumberHighlight.highlightThePickedNumber(random_number[pos]+1);
   //printtheTheTicketsWhichHasWon(calledNumbers, prizeList);
   calledNumbers.add(random_number[pos] + 1);
   lbl[random_number[pos]].setBackground(Color.YELLOW);
   lbl[random_number[pos]].setForeground(Color.BLACK);
   lblNumber.setText("Chosen Number: " +(random_number[pos]+1));
   lblNumber.setFont(new Font("Cambria",Font.BOLD,38));
   lblNumber.setForeground(Color.RED);
   pos++;
  }
  
  else{
   pos = 0;
   for(int i = 0; i < lbl.length ; i++){
    lbl[i].setBackground(Color.WHITE); 
    lbl[i].setForeground(Color.BLACK); 
   }
  }
 }

 private void printtheTheTicketsWhichHasWon(List<Integer> calledNumbers, List<Prize> prizeList) {
  ticketsWon = GameWinner.getWinningTickets(calledNumbers, prizeList);
  if(ticketsWon.size() > 0) {

   for(Ticket ticket : ticketsWon) {
    System.out.println("Ticket number " + ticket.getTicketNumber()  + "won");
   }
  }

 }

 public static void main (String[] args) {
  new App("Tambola");
 }
}
