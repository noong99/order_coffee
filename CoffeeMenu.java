import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
// 구글링
import javax.swing.table.DefaultTableModel;

class  CoffeeMenu extends JFrame
{
	JTable table1;
	JScrollPane sc1;
	// JScrollPane sc2;
	
	JPanel NorthPanel;
	JPanel CenterPanel;
	JPanel SouthPanel;
	JTextArea txt;
	JLabel topbar;
	JButton menubt[];
	JTextField num[];
	Button minus[];
    Button plus[];
    JButton ok[];
    JLabel won[];
    JLabel name[];
	JPanel SelectPanel;
	JButton order[];
	Color gold = new Color(255,204,51); // gold 색상 
	Color ly = new Color(255,255,153); // light yellow 색상 
	Color lg = new Color(204,204,204); // light gray 색상  
	int total = 0; // 주문 총 금액
	int count; // 메뉴 개수
	int col =0;
	int row = 0;
	String contents = "";
	int i,j,k;
	

	public CoffeeMenu(){
		setTitle("커피 메뉴 주문 화면");
		
		// 제일 위의 Panel
		NorthPanel = new JPanel();
		NorthPanel.setBackground(ly); // light yellow 색상으로 제일 위의 title 지정 
		NorthPanel.setLayout(new FlowLayout());
		topbar = new JLabel("<커피주문 키오스크>");
		NorthPanel.add(topbar);

		// Center Panel --> 메뉴들 보여주기 
		CenterPanel = new JPanel();
		CenterPanel.setLayout(null);
		CenterPanel.setBackground(lg);

		// menu 아이템 지정 
		String items[] = {"에스프레소","아메리카노", "카페라떼","카페모카","카푸치노","딸기 스무디", "초코 스무디", "바나나스무디"};
		String itname[] = { // 각각의 메뉴 아이템 이름 
			"에스프레소","아메리카노", "카페라떼","카페모카","카푸치노","딸기 스무디", "초코 스무디", "바나나스무디"
		};		

		// 메뉴 아이템들의 가격 지정 
		int price[] = {2500, 3000,3500,4000,3500,4500,4200,4100};

		// 몇개나 주문할지 각 아이템마다 설정
		JButton menubt[] = new JButton[items.length];
		JTextField num[] = new JTextField[items.length];
		Button minus[] = new Button[items.length];
		Button plus[] = new Button[items.length];
		JButton ok[] = new JButton[items.length];
		JLabel won[] = new JLabel[items.length];
		JLabel name[] = new JLabel[items.length];
		
		// 표시할 menu들 - 8가지
		menubt[0] = new JButton(new ImageIcon("Projectimg/espresso.jpg"));
		menubt[1] = new JButton(new ImageIcon("Projectimg/americano.jpg"));
		menubt[2] = new JButton(new ImageIcon("Projectimg/cafelatte.jpg"));
		menubt[3] = new JButton(new ImageIcon("Projectimg/mocha.jpg"));
		menubt[4] = new JButton(new ImageIcon("Projectimg/cappuccino.jpg"));
		menubt[5] = new JButton(new ImageIcon("Projectimg/strawsm.jpg"));
		menubt[6] = new JButton(new ImageIcon("Projectimg/chocosm.jpg"));	
		menubt[7] = new JButton(new ImageIcon("Projectimg/bananasm.jpg"));

		for (int i = 0; i < items.length; i++) {
        	if(i<4) {
        		menubt[i].setBounds(25 + i * 300, 40, 100, 100);
        	}
        	else {
        		menubt[i].setBounds(25 + (i - 4) * 300, 250, 100, 100);
        	}

			name[i] = new JLabel(itname[i]);
			name[i].setBounds(menubt[i].getX()+10, menubt[i].getY() - 20, 115, 20); // 메뉴이름의 layout설정
			num[i] = new JTextField("0"); //0개로 초기화
			num[i].setBackground(Color.white);
			num[i].setBounds(menubt[i].getX() + 30, menubt[i].getY() + 130, 40, 25);
			
			// 수량 빼기
			minus[i] = new Button("-");
			minus[i].setFont(new Font("Arial", Font.BOLD, 7));
            minus[i].setBounds(menubt[i].getX(), num[i].getY(), 25, 25);
			minus[i].setEnabled(true); // 버튼을 우선 활성화시키고 아래의 이벤트 적용시 비활성화하게끔 우선 활성화
            
			// 수량 더하기
            plus[i] = new Button("+");
            plus[i].setBounds(menubt[i].getX() + (100 - 25), num[i].getY(), 25, 25);
			plus[i].setEnabled(true); // 버튼을 우선 활성화시키고 아래의 이벤트 적용시 비활성화하게끔 우선 활성화
            
			// 금액 표시
            won[i] = new JLabel(price[i] + "원");
            won[i].setBounds(menubt[i].getX() + 30, num[i].getY() - 25, 100, 20);
            
			// 확인 표시 
            ok[i] = new JButton("확인");
            ok[i].setBounds(menubt[i].getX(), num[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false); // 버튼을 우선 활성화시키고 아래의 이벤트 적용시 비활성화하게끔 우선 활성화

			CenterPanel.add(name[i]);
            CenterPanel.add(menubt[i]);
            CenterPanel.add(num[i]);
            CenterPanel.add(minus[i]);
            CenterPanel.add(plus[i]);
            CenterPanel.add(won[i]);
            CenterPanel.add(ok[i]);
		}
		
		// menu item들 background 지정 
		for (j=0;j<8 ; j++)
		{
			menubt[j].setBackground(gold);
		}
		
		// SouthPanel
		SouthPanel = new JPanel(new BorderLayout());
		txt = new JTextArea("");

		String[][] data = new String[0][0];
		String[] titles = {"상품명", "가격", "수량", "개수 합계", "총 금액"};
		// 구글링하여 DefaultTableModel
		DefaultTableModel model = new DefaultTableModel(data, titles);
		table1 = new JTable(model);
		sc1 = new JScrollPane(table1);
		sc1.setPreferredSize(new Dimension(1150,120));
		SouthPanel.add(sc1, BorderLayout.CENTER);
		
		SelectPanel = new JPanel();
		SelectPanel.setLayout(new GridLayout(3,1,50,0));

		// order한 것을 배열
		JButton order[] = new JButton[3];
		order[0] = new JButton(new ImageIcon("Projectimg/reset.png")); // 다시 선택 버튼 
		order[1] = new JButton(new ImageIcon("Projectimg/pay.png")); // 결제하기 버튼
		order[2] = new JButton(new ImageIcon("Projectimg/selected.jpg")); //선택한 상품 맞는지 확인 
		
		for (k=0;k<3 ;k++ )
		{
			order[k].setBackground(Color.WHITE);
			SelectPanel.add(order[k]);
		}
		
		// reset 다시 선택 버튼 이벤트 지정
		order[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			model.setNumRows(0); // 주문 내역들 초기화하기
			txt.setText("");
			total = 0;
		}
		});

		// 결제하기 버튼
		order[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int answer = JOptionPane.showConfirmDialog(null, "주문하시겠습니까?", "Order",JOptionPane.YES_NO_OPTION);
            	if(answer == JOptionPane.YES_OPTION)
            	{
            		if(total==0)
            		{
            			JOptionPane.showMessageDialog(null, "존재하지 않는 항목입니다");
            		}

                	else { // 선택한게 하나이상인경우 
                		for(int i=0; i<table1.getRowCount(); i++) {
                			txt.append(table1.getValueAt(i, 0)+" "+table1.getValueAt(i, 1)+" X "+table1.getValueAt(i, 2)+"개\n");
                		}
                		
                		contents = txt.toString();
                		JOptionPane.showMessageDialog(null, txt.getText()+"총 금액 : "+total+"원\n"+"주문 완료입니다. \n 감사합니다.");
                		total=0; 
						txt.setText("");
						model.setNumRows(0);
                	}
            	}
            	else // no를 선택한 경우 -> 결제하기 전단계로(메뉴 다시선택 등)
            		JOptionPane.showMessageDialog(null, "메뉴 선택 단계로 이동합니다.\n");
				
				// 다시 전 단계로 돌아가면 처음부터 다시 선택하게끔 
                for (int i = 0; i < items.length; i++) { // 다시 초기화
                    num[i].setText("0");
                }
            }
        });

		// 선택한 상품 맞는지 확인 --> 재확인 과정으로, 나중에 주문하면 메뉴를 변경할 수 없게끔 경각심 주기 위해 
		order[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new OrderCall();
			}
		});

		
		// 다른 버튼들 
		for (int i=0;i<items.length ;i++ )
		{
			int b = i; 
			// menu버튼 우선 count0으로 
			menubt[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					count = 0;
				}
			});
			
			// minus 버튼 누르면 수량이 하나 적어지게 
			minus[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (count>0)
					{
						count-=1;
						num[b].setText(count+ "");
						ok[b].setEnabled(true);
					}else{// 수량이 0개이하로 작아지는 경우는 minus를 하면 안되므로 버튼 비활성화
						minus[b].setEnabled(false);
					}
				}
			});

			// plus 버튼 누르면 수량이 하나 늘어나게
			plus[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					count+=1;
					num[b].setText(count+ "");
					ok[b].setEnabled(true);
					if (count>0)
					{
						minus[b].setEnabled(true); // 위의 이벤트 작성시 minus 버튼을 비활성화시켰으므로 다시 plus해줬을 때 활성화될 수 있게 
					}
				}
			});
			
			// ok버튼 누르면 총 금액이 나오게 
			ok[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					num[b].setText("0");
					total = price[b]*count + total;
					// 정보를 나타내기 위해(금액, 상품)
					String info[] = new String[5];
					info[0] = itname[b];
					info[1] = price[b]+"원 ";
					info[2] = ""+count;
					info[3] = price[b] * count+"원";
					info[4] = total+"원";
					model.addRow(info);

					count = 0;
					ok[b].setEnabled(false); // ok버튼의 기능 다했으므로 이제 비활성화 
				}
			});
		}

		// Thread를 이용한 Timer 추가
		ThreadTimerex timerex = new ThreadTimerex();
		SouthPanel.add(timerex, BorderLayout.SOUTH);

		// 마지막으로 JFrame에 추가해줌+ 설정들 
		add(NorthPanel, BorderLayout.NORTH);
		add(CenterPanel, BorderLayout.CENTER);
		add(SouthPanel, BorderLayout.SOUTH);
		add(SelectPanel, BorderLayout.EAST);

		setSize(1490,680);
		setVisible(true);
	}
}
