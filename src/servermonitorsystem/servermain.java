package servermonitorsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.awt.SystemColor;
import java.awt.Window.Type;

public class servermain extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ipserver;
	private JTextField textField_portserver;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					servermain frame = new servermain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public servermain() {
		setTitle("SERVER MONITORING SYSTEM");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(40, 40, 780, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_tieude = new JLabel("SERVER MONITORING SYSTEM");
		lbl_tieude.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_tieude.setBounds(196, 11, 543, 46);
		contentPane.add(lbl_tieude);
		
		JLabel lbl_ipserver = new JLabel("IP SERVER :");
		lbl_ipserver.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ipserver.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ipserver.setBounds(194, 68, 77, 26);
		contentPane.add(lbl_ipserver);
		
		JLabel lbl_portserver = new JLabel("PORT SERVER :");
		lbl_portserver.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_portserver.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_portserver.setBounds(495, 68, 102, 26);
		contentPane.add(lbl_portserver);
		
		textField_ipserver = new JTextField();
		textField_ipserver.setEditable(false);
		textField_ipserver.setBounds(281, 72, 204, 20);
		contentPane.add(textField_ipserver);
		textField_ipserver.setColumns(10);
		
		textField_portserver = new JTextField();
		textField_portserver.setEditable(false);
		textField_portserver.setColumns(10);
		textField_portserver.setBounds(607, 72, 132, 20);
		contentPane.add(textField_portserver);
		
		JList list = new JList();
		list.setBounds(32, 156, 239, 200);
		contentPane.add(list);
		
		JButton btnStart = new JButton("START SERVER");
		btnStart.setForeground(Color.GREEN);
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 12));
				 
		btnStart.setIcon(null);
		btnStart.setBounds(32, 52, 132, 26);
		//btnStop.setOpaque(false);
		//btnStop.setContentAreaFilled(false);
		//btnStop.setBorderPainted(false);
		
		contentPane.add(btnStart);
		
		
		
		table = new JTable();
		table.setBounds(291, 157, 448, 200);
		contentPane.add(table);
		
		JButton btnStop = new JButton("STOP SERVER");
		btnStop.setForeground(Color.RED);
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStop.setBounds(32, 89, 132, 26);
		contentPane.add(btnStop);
		
		JLabel lbl_ipserver_1 = new JLabel("CLIENT LIST");
		lbl_ipserver_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ipserver_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ipserver_1.setBounds(32, 126, 132, 26);
		contentPane.add(lbl_ipserver_1);
		
		JLabel lbl_ipserver_1_1 = new JLabel("CLIENT FOLDER");
		lbl_ipserver_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ipserver_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ipserver_1_1.setBounds(291, 126, 132, 26);
		contentPane.add(lbl_ipserver_1_1);
		
		JLabel lbl_ipserver_1_2 = new JLabel("CLIENT LOG");
		lbl_ipserver_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_ipserver_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ipserver_1_2.setBounds(32, 379, 132, 26);
		contentPane.add(lbl_ipserver_1_2);
		
		table_1 = new JTable();
		table_1.setBounds(32, 416, 707, 302);
		contentPane.add(table_1);
		
		String kq="";
		try {
			InetAddress addr = InetAddress.getLocalHost();
			kq=addr.getHostAddress();					
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int portsv =9999;
		textField_ipserver.setText(kq);
		textField_portserver.setText(portsv+"");
		
		JLabel lbl_messs = new JLabel("mess : ");
		lbl_messs.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_messs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_messs.setBounds(498, 120, 241, 26);
		contentPane.add(lbl_messs);
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					ServerSocket langnghe1 = new ServerSocket(portsv);
					
					
					while(true)
					{
						Socket soc=langnghe1.accept(); //synchronous
						ObjectOutputStream obo = new ObjectOutputStream(soc.getOutputStream());
						ObjectInputStream obi = new ObjectInputStream(soc.getInputStream());
						
						int j =0;
						while(true)
						{
							
							
							String mess = "server xin chao "+j;
							obo.writeObject(mess);
							
							
							try {
								String mess_re = (String)obi.readObject();
								
								lbl_messs.setText(mess_re);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							j++;
						}
					}
					
					
				}
				catch(IOException e1)
				{
					System.out.println("There're some error");
				}
			}
		});
	}

	protected servermonitorsystem.serverprocess serverprocess() {
		// TODO Auto-generated method stub
		return null;
	}
}
