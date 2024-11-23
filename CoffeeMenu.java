import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
// ���۸�
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
	Color gold = new Color(255,204,51); // gold ���� 
	Color ly = new Color(255,255,153); // light yellow ���� 
	Color lg = new Color(204,204,204); // light gray ����  
	int total = 0; // �ֹ� �� �ݾ�
	int count; // �޴� ����
	int col =0;
	int row = 0;
	String contents = "";
	int i,j,k;
	

	public CoffeeMenu(){
		setTitle("Ŀ�� �޴� �ֹ� ȭ��");
		
		// ���� ���� Panel
		NorthPanel = new JPanel();
		NorthPanel.setBackground(ly); // light yellow �������� ���� ���� title ���� 
		NorthPanel.setLayout(new FlowLayout());
		topbar = new JLabel("<Ŀ���ֹ� Ű����ũ>");
		NorthPanel.add(topbar);

		// Center Panel --> �޴��� �����ֱ� 
		CenterPanel = new JPanel();
		CenterPanel.setLayout(null);
		CenterPanel.setBackground(lg);

		// menu ������ ���� 
		String items[] = {"����������","�Ƹ޸�ī��", "ī���","ī���ī","īǪġ��","���� ������", "���� ������", "�ٳ���������"};
		String itname[] = { // ������ �޴� ������ �̸� 
			"����������","�Ƹ޸�ī��", "ī���","ī���ī","īǪġ��","���� ������", "���� ������", "�ٳ���������"
		};		

		// �޴� �����۵��� ���� ���� 
		int price[] = {2500, 3000,3500,4000,3500,4500,4200,4100};

		// ��� �ֹ����� �� �����۸��� ����
		JButton menubt[] = new JButton[items.length];
		JTextField num[] = new JTextField[items.length];
		Button minus[] = new Button[items.length];
		Button plus[] = new Button[items.length];
		JButton ok[] = new JButton[items.length];
		JLabel won[] = new JLabel[items.length];
		JLabel name[] = new JLabel[items.length];
		
		// ǥ���� menu�� - 8����
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
			name[i].setBounds(menubt[i].getX()+10, menubt[i].getY() - 20, 115, 20); // �޴��̸��� layout����
			num[i] = new JTextField("0"); //0���� �ʱ�ȭ
			num[i].setBackground(Color.white);
			num[i].setBounds(menubt[i].getX() + 30, menubt[i].getY() + 130, 40, 25);
			
			// ���� ����
			minus[i] = new Button("-");
			minus[i].setFont(new Font("Arial", Font.BOLD, 7));
            minus[i].setBounds(menubt[i].getX(), num[i].getY(), 25, 25);
			minus[i].setEnabled(true); // ��ư�� �켱 Ȱ��ȭ��Ű�� �Ʒ��� �̺�Ʈ ����� ��Ȱ��ȭ�ϰԲ� �켱 Ȱ��ȭ
            
			// ���� ���ϱ�
            plus[i] = new Button("+");
            plus[i].setBounds(menubt[i].getX() + (100 - 25), num[i].getY(), 25, 25);
			plus[i].setEnabled(true); // ��ư�� �켱 Ȱ��ȭ��Ű�� �Ʒ��� �̺�Ʈ ����� ��Ȱ��ȭ�ϰԲ� �켱 Ȱ��ȭ
            
			// �ݾ� ǥ��
            won[i] = new JLabel(price[i] + "��");
            won[i].setBounds(menubt[i].getX() + 30, num[i].getY() - 25, 100, 20);
            
			// Ȯ�� ǥ�� 
            ok[i] = new JButton("Ȯ��");
            ok[i].setBounds(menubt[i].getX(), num[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false); // ��ư�� �켱 Ȱ��ȭ��Ű�� �Ʒ��� �̺�Ʈ ����� ��Ȱ��ȭ�ϰԲ� �켱 Ȱ��ȭ

			CenterPanel.add(name[i]);
            CenterPanel.add(menubt[i]);
            CenterPanel.add(num[i]);
            CenterPanel.add(minus[i]);
            CenterPanel.add(plus[i]);
            CenterPanel.add(won[i]);
            CenterPanel.add(ok[i]);
		}
		
		// menu item�� background ���� 
		for (j=0;j<8 ; j++)
		{
			menubt[j].setBackground(gold);
		}
		
		// SouthPanel
		SouthPanel = new JPanel(new BorderLayout());
		txt = new JTextArea("");

		String[][] data = new String[0][0];
		String[] titles = {"��ǰ��", "����", "����", "���� �հ�", "�� �ݾ�"};
		// ���۸��Ͽ� DefaultTableModel
		DefaultTableModel model = new DefaultTableModel(data, titles);
		table1 = new JTable(model);
		sc1 = new JScrollPane(table1);
		sc1.setPreferredSize(new Dimension(1150,120));
		SouthPanel.add(sc1, BorderLayout.CENTER);
		
		SelectPanel = new JPanel();
		SelectPanel.setLayout(new GridLayout(3,1,50,0));

		// order�� ���� �迭
		JButton order[] = new JButton[3];
		order[0] = new JButton(new ImageIcon("Projectimg/reset.png")); // �ٽ� ���� ��ư 
		order[1] = new JButton(new ImageIcon("Projectimg/pay.png")); // �����ϱ� ��ư
		order[2] = new JButton(new ImageIcon("Projectimg/selected.jpg")); //������ ��ǰ �´��� Ȯ�� 
		
		for (k=0;k<3 ;k++ )
		{
			order[k].setBackground(Color.WHITE);
			SelectPanel.add(order[k]);
		}
		
		// reset �ٽ� ���� ��ư �̺�Ʈ ����
		order[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			model.setNumRows(0); // �ֹ� ������ �ʱ�ȭ�ϱ�
			txt.setText("");
			total = 0;
		}
		});

		// �����ϱ� ��ư
		order[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int answer = JOptionPane.showConfirmDialog(null, "�ֹ��Ͻðڽ��ϱ�?", "Order",JOptionPane.YES_NO_OPTION);
            	if(answer == JOptionPane.YES_OPTION)
            	{
            		if(total==0)
            		{
            			JOptionPane.showMessageDialog(null, "�������� �ʴ� �׸��Դϴ�");
            		}

                	else { // �����Ѱ� �ϳ��̻��ΰ�� 
                		for(int i=0; i<table1.getRowCount(); i++) {
                			txt.append(table1.getValueAt(i, 0)+" "+table1.getValueAt(i, 1)+" X "+table1.getValueAt(i, 2)+"��\n");
                		}
                		
                		contents = txt.toString();
                		JOptionPane.showMessageDialog(null, txt.getText()+"�� �ݾ� : "+total+"��\n"+"�ֹ� �Ϸ��Դϴ�. \n �����մϴ�.");
                		total=0; 
						txt.setText("");
						model.setNumRows(0);
                	}
            	}
            	else // no�� ������ ��� -> �����ϱ� ���ܰ��(�޴� �ٽü��� ��)
            		JOptionPane.showMessageDialog(null, "�޴� ���� �ܰ�� �̵��մϴ�.\n");
				
				// �ٽ� �� �ܰ�� ���ư��� ó������ �ٽ� �����ϰԲ� 
                for (int i = 0; i < items.length; i++) { // �ٽ� �ʱ�ȭ
                    num[i].setText("0");
                }
            }
        });

		// ������ ��ǰ �´��� Ȯ�� --> ��Ȯ�� ��������, ���߿� �ֹ��ϸ� �޴��� ������ �� ���Բ� �氢�� �ֱ� ���� 
		order[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new OrderCall();
			}
		});

		
		// �ٸ� ��ư�� 
		for (int i=0;i<items.length ;i++ )
		{
			int b = i; 
			// menu��ư �켱 count0���� 
			menubt[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					count = 0;
				}
			});
			
			// minus ��ư ������ ������ �ϳ� �������� 
			minus[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (count>0)
					{
						count-=1;
						num[b].setText(count+ "");
						ok[b].setEnabled(true);
					}else{// ������ 0�����Ϸ� �۾����� ���� minus�� �ϸ� �ȵǹǷ� ��ư ��Ȱ��ȭ
						minus[b].setEnabled(false);
					}
				}
			});

			// plus ��ư ������ ������ �ϳ� �þ��
			plus[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					count+=1;
					num[b].setText(count+ "");
					ok[b].setEnabled(true);
					if (count>0)
					{
						minus[b].setEnabled(true); // ���� �̺�Ʈ �ۼ��� minus ��ư�� ��Ȱ��ȭ�������Ƿ� �ٽ� plus������ �� Ȱ��ȭ�� �� �ְ� 
					}
				}
			});
			
			// ok��ư ������ �� �ݾ��� ������ 
			ok[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					num[b].setText("0");
					total = price[b]*count + total;
					// ������ ��Ÿ���� ����(�ݾ�, ��ǰ)
					String info[] = new String[5];
					info[0] = itname[b];
					info[1] = price[b]+"�� ";
					info[2] = ""+count;
					info[3] = price[b] * count+"��";
					info[4] = total+"��";
					model.addRow(info);

					count = 0;
					ok[b].setEnabled(false); // ok��ư�� ��� �������Ƿ� ���� ��Ȱ��ȭ 
				}
			});
		}

		// Thread�� �̿��� Timer �߰�
		ThreadTimerex timerex = new ThreadTimerex();
		SouthPanel.add(timerex, BorderLayout.SOUTH);

		// ���������� JFrame�� �߰�����+ ������ 
		add(NorthPanel, BorderLayout.NORTH);
		add(CenterPanel, BorderLayout.CENTER);
		add(SouthPanel, BorderLayout.SOUTH);
		add(SelectPanel, BorderLayout.EAST);

		setSize(1490,680);
		setVisible(true);
	}
}
