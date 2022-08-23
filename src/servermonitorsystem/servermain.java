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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class servermain extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ipserver;
	private JTextField textField_portserver;
	private JTable table;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_tieude = new JLabel("SERVER MONITORING SYSTEM");
		lbl_tieude.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_tieude.setBounds(196, 11, 303, 46);
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
		list.setBounds(32, 144, 132, 261);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				ServerSocket langnghe = null;
				String dataa;
				BufferedReader dongvao;
				BufferedWriter dongra;
				Socket socketOfServer = null;
				/*
				try {
					langnghe = new ServerSocket(portsv);
					
				}catch(IOException ee)
				{
					System.out.println(ee);
					System.exit(1);
				}
				
				try {
					socketOfServer = langnghe.accept();
					System.out.println("chap nhan ket noi");
					
					dongvao = new BufferedReader(new InputStreamReader(socketOfServer.getInputStream()));
					dongra = new BufferedWriter(new OutputStreamWriter(socketOfServer.getOutputStream()));
					Vector<String> ds = new Vector<String>();
					
					while(true) {
						dataa = dongvao.readLine();
						ds.add(dataa);
						list.setListData(ds);
	
						dongra.write(">>" + dataa);
						
						dongra.newLine();
						dongra.flush();
						break;
					}
				}catch(IOException eee)
				{
					 System.out.println(eee);
			         eee.printStackTrace();
					
				}
				*/
			}
		});
				 
		btnNewButton.setIcon(new ImageIcon(servermain.class.getResource("/iconserver/icon_start.png")));
		btnNewButton.setBounds(32, 39, 72, 72);
		contentPane.add(btnNewButton);
		
		
		
		table = new JTable();
		table.setBounds(196, 145, 543, 260);
		contentPane.add(table);
	}

	protected servermonitorsystem.serverprocess serverprocess() {
		// TODO Auto-generated method stub
		return null;
	}
}
