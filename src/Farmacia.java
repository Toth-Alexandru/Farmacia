import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Farmacia {

	private JFrame frame;
	private JTextField txtNume,txtLuna,txtAn,txtMedicament,txtOras;
	private JButton btnAfiseaza, btnInapoi;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farmacia window = new Farmacia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Farmacia window = new Farmacia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Farmacia() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(243,241,170));
		frame.setBounds(200, 100, 1500, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAfisareFarmacii = new JButton("Farmacii din oras");
		btnAfisareFarmacii.setFocusable(false);
		btnAfisareFarmacii.setForeground(new Color(0, 0, 0));
		btnAfisareFarmacii.setBackground(new Color(255, 255, 255));
		btnAfisareFarmacii.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAfisareFarmacii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				
				JLabel lblOras = new JLabel("Oras");
				lblOras.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblOras.setBounds(12, 50, 253, 35);
				frame.getContentPane().add(lblOras);
				
				txtNume = new JTextField();
				txtNume.setBackground(new Color(255, 255, 255));
				txtNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtNume.setBounds(12, 100, 253, 35);
				frame.getContentPane().add(txtNume);
				txtNume.setColumns(10);
				
				btnAfiseaza = new JButton("Afiseaza");
				btnAfiseaza.setBackground(new Color(255, 255, 255));
				btnAfiseaza.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String oras = txtNume.getText();
							  
						frame.getContentPane().removeAll();
							
						JLabel lblAfisare = new JLabel(afisareOras(oras));
						lblAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblAfisare.setBounds(12, 50, 1500, 35);
						frame.getContentPane().add(lblAfisare);
						
						btnInapoi = new JButton("OK");
						btnInapoi.setBackground(new Color(255, 255, 255));
						btnInapoi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Farmacia farmacia = new Farmacia();
								farmacia.NewScreen();
								frame.dispose();
							}
						});
						btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnInapoi.setBounds(12, 100, 253, 35);
						frame.getContentPane().add(btnInapoi);
							
						frame.repaint();
					}
				});
				btnAfiseaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnAfiseaza.setBounds(12, 150, 110, 25);
				frame.getContentPane().add(btnAfiseaza);
				
				btnInapoi = new JButton("Inapoi");
				btnInapoi.setBackground(new Color(255, 255, 255));
				btnInapoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Farmacia farmacia = new Farmacia();
						farmacia.NewScreen();
						frame.dispose();
					}
				});
				btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnInapoi.setBounds(150, 150, 97, 25);
				frame.getContentPane().add(btnInapoi);
				
				frame.repaint();
			}
		});
		btnAfisareFarmacii.setBounds(570, 30, 300, 50);
		frame.getContentPane().add(btnAfisareFarmacii);
		
		JButton btnComenziFarmacie = new JButton("Comenzi si sume");
		btnComenziFarmacie.setFocusable(false);
		btnComenziFarmacie.setForeground(new Color(0, 0, 0));
		btnComenziFarmacie.setBackground(new Color(255, 255, 255));
		btnComenziFarmacie.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnComenziFarmacie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				
				JLabel lblNume = new JLabel("Farmacie");
				lblNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNume.setBounds(12, 50, 253, 35);
				frame.getContentPane().add(lblNume);
				
				txtNume = new JTextField();
				txtNume.setBackground(new Color(255, 255, 255));
				txtNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtNume.setBounds(12, 100, 253, 35);
				frame.getContentPane().add(txtNume);
				txtNume.setColumns(10);
				
				JLabel lblLuna = new JLabel("Luna");
				lblLuna.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblLuna.setBounds(12, 150, 253, 35);
				frame.getContentPane().add(lblLuna);
				
				txtLuna = new JTextField();
				txtLuna.setBackground(new Color(255, 255, 255));
				txtLuna.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtLuna.setBounds(12, 200, 253, 35);
				frame.getContentPane().add(txtLuna);
				txtLuna.setColumns(10);
				
				btnAfiseaza = new JButton("Afiseaza");
				btnAfiseaza.setBackground(new Color(255, 255, 255));
				btnAfiseaza.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nume = txtNume.getText();
						String luna = txtLuna.getText();
							  
						frame.getContentPane().removeAll();
							
						JLabel lblAfisare = new JLabel(comenziFarmacie(nume, luna));
						lblAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblAfisare.setBounds(12, 50, 1500, 500);
						frame.getContentPane().add(lblAfisare);
						
						btnInapoi = new JButton("OK");
						btnInapoi.setBackground(new Color(255, 255, 255));
						btnInapoi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Farmacia farmacia = new Farmacia();
								farmacia.NewScreen();
								frame.dispose();
							}
						});
						btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnInapoi.setBounds(12, 530, 253, 35);
						frame.getContentPane().add(btnInapoi);
							
						frame.repaint();
					}
				});
				btnAfiseaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnAfiseaza.setBounds(12, 250, 110, 25);
				frame.getContentPane().add(btnAfiseaza);
				
				btnInapoi = new JButton("Inapoi");
				btnInapoi.setBackground(new Color(255, 255, 255));
				btnInapoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Farmacia farmacia = new Farmacia();
						farmacia.NewScreen();
						frame.dispose();
					}
				});
				btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnInapoi.setBounds(150, 250, 97, 25);
				frame.getContentPane().add(btnInapoi);
				
				frame.repaint();
			}
		});
		btnComenziFarmacie.setBounds(570, 130, 300, 50);
		frame.getContentPane().add(btnComenziFarmacie);
		
		JButton btnComenziAntibiotice = new JButton("Comenzi de antibiotice");
		btnComenziAntibiotice.setFocusable(false);
		btnComenziAntibiotice.setForeground(new Color(0, 0, 0));
		btnComenziAntibiotice.setBackground(new Color(255, 255, 255));
		btnComenziAntibiotice.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnComenziAntibiotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				
				JLabel lblNume = new JLabel("Farmacie");
				lblNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNume.setBounds(12, 50, 253, 35);
				frame.getContentPane().add(lblNume);
				
				txtNume = new JTextField();
				txtNume.setBackground(new Color(255, 255, 255));
				txtNume.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtNume.setBounds(12, 100, 253, 35);
				frame.getContentPane().add(txtNume);
				txtNume.setColumns(10);
				
				JLabel lblAn = new JLabel("An");
				lblAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblAn.setBounds(12, 150, 253, 35);
				frame.getContentPane().add(lblAn);
				
				txtAn = new JTextField();
				txtAn.setBackground(new Color(255, 255, 255));
				txtAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtAn.setBounds(12, 200, 253, 35);
				frame.getContentPane().add(txtAn);
				txtAn.setColumns(10);
				
				btnAfiseaza = new JButton("Afiseaza");
				btnAfiseaza.setBackground(new Color(255, 255, 255));
				btnAfiseaza.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nume = txtNume.getText();
						int an = Integer.valueOf(txtAn.getText());
							  
						frame.getContentPane().removeAll();
							
						JLabel lblAfisare = new JLabel(comenziAntibiotice(nume, an));
						lblAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblAfisare.setBounds(12, 50, 1500, 35);
						frame.getContentPane().add(lblAfisare);
						
						btnInapoi = new JButton("OK");
						btnInapoi.setBackground(new Color(255, 255, 255));
						btnInapoi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Farmacia farmacia = new Farmacia();
								farmacia.NewScreen();
								frame.dispose();
							}
						});
						btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnInapoi.setBounds(12, 100, 253, 35);
						frame.getContentPane().add(btnInapoi);
							
						frame.repaint();
					}
				});
				btnAfiseaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnAfiseaza.setBounds(12, 250, 110, 25);
				frame.getContentPane().add(btnAfiseaza);
				
				btnInapoi = new JButton("Inapoi");
				btnInapoi.setBackground(new Color(255, 255, 255));
				btnInapoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Farmacia farmacia = new Farmacia();
						farmacia.NewScreen();
						frame.dispose();
					}
				});
				btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnInapoi.setBounds(150, 250, 97, 25);
				frame.getContentPane().add(btnInapoi);
				
				frame.repaint();
			}
		});
		btnComenziAntibiotice.setBounds(570, 230, 300, 50);
		frame.getContentPane().add(btnComenziAntibiotice);
		
		JButton btnPrimaAn = new JButton("Prima la comenzi");
		btnPrimaAn.setFocusable(false);
		btnPrimaAn.setForeground(new Color(0, 0, 0));
		btnPrimaAn.setBackground(new Color(255, 255, 255));
		btnPrimaAn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnPrimaAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				
				JLabel lblAn = new JLabel("An");
				lblAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblAn.setBounds(12, 50, 253, 35);
				frame.getContentPane().add(lblAn);
				
				txtAn = new JTextField();
				txtAn.setBackground(new Color(255, 255, 255));
				txtAn.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtAn.setBounds(12, 100, 253, 35);
				frame.getContentPane().add(txtAn);
				txtAn.setColumns(10);
				
				btnAfiseaza = new JButton("Afiseaza");
				btnAfiseaza.setBackground(new Color(255, 255, 255));
				btnAfiseaza.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int an = Integer.valueOf(txtAn.getText());
							  
						frame.getContentPane().removeAll();
							
						JLabel lblAfisare = new JLabel(primaAn(an));
						lblAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblAfisare.setBounds(12, 50, 1500, 35);
						frame.getContentPane().add(lblAfisare);
						
						btnInapoi = new JButton("OK");
						btnInapoi.setBackground(new Color(255, 255, 255));
						btnInapoi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Farmacia farmacia = new Farmacia();
								farmacia.NewScreen();
								frame.dispose();
							}
						});
						btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnInapoi.setBounds(12, 100, 253, 35);
						frame.getContentPane().add(btnInapoi);
							
						frame.repaint();
					}
				});
				btnAfiseaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnAfiseaza.setBounds(12, 150, 110, 25);
				frame.getContentPane().add(btnAfiseaza);
				
				btnInapoi = new JButton("Inapoi");
				btnInapoi.setBackground(new Color(255, 255, 255));
				btnInapoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Farmacia farmacia = new Farmacia();
						farmacia.NewScreen();
						frame.dispose();
					}
				});
				btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnInapoi.setBounds(150, 150, 97, 25);
				frame.getContentPane().add(btnInapoi);
				
				frame.repaint();
			}
		});
		btnPrimaAn.setBounds(570, 330, 300, 50);
		frame.getContentPane().add(btnPrimaAn);
		
		JButton btnDisponibilitateMedicament = new JButton("Disponibilitate");
		btnDisponibilitateMedicament.setFocusable(false);
		btnDisponibilitateMedicament.setForeground(new Color(0, 0, 0));
		btnDisponibilitateMedicament.setBackground(new Color(255, 255, 255));
		btnDisponibilitateMedicament.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDisponibilitateMedicament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				
				JLabel lblMedicament = new JLabel("Medicament");
				lblMedicament.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblMedicament.setBounds(12, 50, 253, 35);
				frame.getContentPane().add(lblMedicament);
				
				txtMedicament = new JTextField();
				txtMedicament.setBackground(new Color(255, 255, 255));
				txtMedicament.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtMedicament.setBounds(12, 100, 253, 35);
				frame.getContentPane().add(txtMedicament);
				txtMedicament.setColumns(10);
				
				btnAfiseaza = new JButton("Afiseaza");
				btnAfiseaza.setBackground(new Color(255, 255, 255));
				btnAfiseaza.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String medicament = txtMedicament.getText();
							  
						frame.getContentPane().removeAll();
							
						JLabel lblAfisare = new JLabel(stocFarmacii(medicament));
						lblAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblAfisare.setBounds(12, 50, 1500, 35);
						frame.getContentPane().add(lblAfisare);
						
						btnInapoi = new JButton("OK");
						btnInapoi.setBackground(new Color(255, 255, 255));
						btnInapoi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Farmacia farmacia = new Farmacia();
								farmacia.NewScreen();
								frame.dispose();
							}
						});
						btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnInapoi.setBounds(12, 100, 253, 35);
						frame.getContentPane().add(btnInapoi);
							
						frame.repaint();
					}
				});
				btnAfiseaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnAfiseaza.setBounds(12, 150, 110, 25);
				frame.getContentPane().add(btnAfiseaza);
				
				btnInapoi = new JButton("Inapoi");
				btnInapoi.setBackground(new Color(255, 255, 255));
				btnInapoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Farmacia farmacia = new Farmacia();
						farmacia.NewScreen();
						frame.dispose();
					}
				});
				btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnInapoi.setBounds(150, 150, 97, 25);
				frame.getContentPane().add(btnInapoi);
				
				frame.repaint();
			}
		});
		btnDisponibilitateMedicament.setBounds(570, 430, 300, 50);
		frame.getContentPane().add(btnDisponibilitateMedicament);
		
		JButton btnCantitateMedicament = new JButton("Cantitate totala");
		btnCantitateMedicament.setFocusable(false);
		btnCantitateMedicament.setForeground(new Color(0, 0, 0));
		btnCantitateMedicament.setBackground(new Color(255, 255, 255));
		btnCantitateMedicament.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCantitateMedicament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				
				JLabel lblMedicament = new JLabel("Medicament");
				lblMedicament.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblMedicament.setBounds(12, 50, 253, 35);
				frame.getContentPane().add(lblMedicament);
				
				txtMedicament = new JTextField();
				txtMedicament.setBackground(new Color(255, 255, 255));
				txtMedicament.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtMedicament.setBounds(12, 100, 253, 35);
				frame.getContentPane().add(txtMedicament);
				txtMedicament.setColumns(10);
				
				JLabel lblOras = new JLabel("Oras");
				lblOras.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblOras.setBounds(12, 150, 253, 35);
				frame.getContentPane().add(lblOras);
				
				txtOras = new JTextField();
				txtOras.setBackground(new Color(255, 255, 255));
				txtOras.setFont(new Font("Tahoma", Font.PLAIN, 20));
				txtOras.setBounds(12, 200, 253, 35);
				frame.getContentPane().add(txtOras);
				txtOras.setColumns(10);
				
				btnAfiseaza = new JButton("Afiseaza");
				btnAfiseaza.setBackground(new Color(255, 255, 255));
				btnAfiseaza.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String medicament = txtMedicament.getText();
						String oras = txtOras.getText();
							  
						frame.getContentPane().removeAll();
							
						JLabel lblAfisare = new JLabel(medicamentTotal(medicament, oras));
						lblAfisare.setFont(new Font("Tahoma", Font.PLAIN, 20));
						lblAfisare.setBounds(12, 50, 1500, 35);
						frame.getContentPane().add(lblAfisare);
						
						btnInapoi = new JButton("OK");
						btnInapoi.setBackground(new Color(255, 255, 255));
						btnInapoi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Farmacia farmacia = new Farmacia();
								farmacia.NewScreen();
								frame.dispose();
							}
						});
						btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
						btnInapoi.setBounds(12, 100, 253, 35);
						frame.getContentPane().add(btnInapoi);
							
						frame.repaint();
					}
				});
				btnAfiseaza.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnAfiseaza.setBounds(12, 250, 110, 25);
				frame.getContentPane().add(btnAfiseaza);
				
				btnInapoi = new JButton("Inapoi");
				btnInapoi.setBackground(new Color(255, 255, 255));
				btnInapoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Farmacia farmacia = new Farmacia();
						farmacia.NewScreen();
						frame.dispose();
					}
				});
				btnInapoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnInapoi.setBounds(150, 250, 97, 25);
				frame.getContentPane().add(btnInapoi);
				
				frame.repaint();
			}
		});
		btnCantitateMedicament.setBounds(570, 530, 300, 50);
		frame.getContentPane().add(btnCantitateMedicament);
	}
	static String afisareOras(String oras) {
		String s = "";
		try {
			boolean b=true;
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","");
			Statement stmt = con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select * from farmacie where oras='"+oras+"'");
			//System.out.print(oras+":");
			s+=oras+":";
			while(rs.next())
			{
				if (b) {
				//System.out.print(" "+rs.getString(2));
				s+=" "+rs.getString(2);
				b=false;
				}
				else {
					//System.out.print(", "+rs.getString(2));
					s+=", "+rs.getString(2);
				}
			}

			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	static String comenziFarmacie(String nume,String luna) {
		String s = "<html>";
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","");
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			//Statement stmt3 = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from farmacie where nume='"+nume+"'");
			ResultSet rs2;
			rs.next();
			int idFarmacie = rs.getInt(1);
			rs=stmt.executeQuery("select * from comanda where idFarmacie='"+idFarmacie+"' and MONTHNAME(data)='"+luna+"'");
			int sumaTotala = 0, sumaMedie, cantitate, pret, comenzi = 0,k;
			//System.out.println(nume+" a avut in luna "+luna+"");
			s+=nume+" a avut in luna "+luna+"<br/>";
			while(rs.next())
			{
				comenzi++;
				sumaMedie = 0;
				//rs2=stmt2.executeQuery("select * from serie where idComanda="+rs.getInt(1));
				rs2=stmt2.executeQuery("select a.cantitate, b.cost from serie a, medicament b where a.idComanda="+rs.getInt(1)+" and a.idMedicament=b.id");
				k =0;
				while(rs2.next()) {
				k++;
				cantitate = 0;
				//cantitate = rs2.getInt(3);
				cantitate = rs2.getInt(1);
				pret = 0;
				//rs3=stmt3.executeQuery("select * from medicament where id="+rs2.getInt(2));
				//rs3.next();
				//pret = rs3.getInt(3);
				pret = rs2.getInt(2);
				sumaMedie+=pret*cantitate;
				sumaTotala+=pret*cantitate;
				}
				//System.out.println("Suma medie pe comanda "+rs.getInt(1)+", "+(float)sumaMedie/k+" lei");
				s+="Suma medie pe comanda "+rs.getInt(1)+", "+(float)sumaMedie/k+" lei<br/>";
			}
			//System.out.println("Suma totala de "+sumaTotala+" lei prin intermediul a "+comenzi+" comenzi");
			s+="Suma totala de "+sumaTotala+" lei prin intermediul a "+comenzi+" comenzi</html>";
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	static String comenziAntibiotice(String nume,int an) {
		String s = "";
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","");
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			//Statement stmt3 = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from farmacie where nume='"+nume+"'");
			ResultSet rs2;
			rs.next();
			int idFarmacie = rs.getInt(1);
			rs=stmt.executeQuery("select * from comanda where idFarmacie='"+idFarmacie+"' and YEAR(data)='"+an+"'");
			int comenzi = 0;
			//System.out.print(nume+" a avut in anul "+an+"");
			s+=nume+" a avut in anul "+an+"";
			while(rs.next())
			{
				rs2=stmt2.executeQuery("select * from serie a, categorie b where a.idComanda="+rs.getInt(1)+" and b.nume='Antibiotic' and a.idMedicament=b.idMedicament");
				/*rs2=stmt2.executeQuery("select * from serie where idComanda="+rs.getInt(1));
				while(rs2.next()) {
				rs3=stmt3.executeQuery("select * from categorie where idMedicament="+rs2.getInt(2)+" and nume='Antibiotic'");
				if(rs3.next())
				}*/
				if(rs2.next())
					comenzi++;
			}
			//System.out.println(" "+comenzi+" comenzi de antibiotice");
			s+=" "+comenzi+" comenzi de antibiotice";
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	static String primaAn(int an) {
		String s = "";
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","");
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			Statement stmt3 = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from farmacie");
			ResultSet rs2,rs3;
			int maxVal = 0;
			String numeFarmacie = "";
			while(rs.next()) {
			rs2=stmt2.executeQuery("select * from comanda where idFarmacie="+rs.getInt(1)+" and YEAR(data)='"+an+"'");
			int sumaTotala = 0, cantitate, pret;
			while(rs2.next())
			{
				rs3=stmt3.executeQuery("select a.cantitate, b.cost from serie a, medicament b where a.idComanda="+rs2.getInt(1)+" and a.idMedicament=b.id");
				while(rs3.next()) {
				cantitate = 0;
				cantitate = rs3.getInt(1);
				pret = 0;
				pret = rs3.getInt(2);
				sumaTotala+=pret*cantitate;
				}
			}
			if (sumaTotala > maxVal) {
				maxVal = sumaTotala;
				numeFarmacie = rs.getString(2);
			}
			}
			//System.out.println("Farmacia care a comandat cel mai mult in anul "+an+" este "+numeFarmacie);
			s+="Farmacia care a comandat cel mai mult in anul "+an+" este "+numeFarmacie;
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	static String stocFarmacii(String medicament) {
		String s = "";
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","");
			boolean b=true;
			Statement stmt = con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select a.nume, a.oras from farmacie a, stoc b, medicament c where a.id=b.idFarmacie and b.cantitate>0 and b.idMedicament=c.id and c.nume='"+medicament+"'");
			//System.out.print(medicament+":");
			s+=medicament+":";
			while(rs.next())
			{
				if (b) {
				//System.out.print(" "+rs.getString(1)+" "+rs.getString(2));
					s+=" "+rs.getString(1)+" "+rs.getString(2);
				b=false;
				}
				else {
					//System.out.print(", "+rs.getString(1)+" "+rs.getString(2));
					s+=", "+rs.getString(1)+" "+rs.getString(2);
				}
			}

			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return s;
	}
	static String medicamentTotal(String medicament,String oras) {
		String s = "";
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/farmacia","root","");
			Statement stmt = con.createStatement(); 
			ResultSet rs=stmt.executeQuery("select b.cantitate from farmacie a, stoc b, medicament c where a.id=b.idFarmacie and a.oras='"+oras+"' and b.idMedicament=c.id and c.nume='"+medicament+"'");
			//System.out.print(medicament+" "+oras+": ");
			s+=medicament+" "+oras+": ";
			int cantitate = 0;
			while(rs.next())
			{
				cantitate+=rs.getInt(1);
			}

			//System.out.println(cantitate+" bucati");
			s+=cantitate+" bucati";
			return s;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return s;
	}
}
