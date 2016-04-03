package fr.esiea.tetris2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



//import java.util.Scanner;

public class menu extends JFrame  {
	JLabel Point= new JLabel("Your score is "+0+"                                         "+bestScore);
	static String bestScore;

	public void menu(){

		Point.setText(String.valueOf(0));

	}

	public void quitte(){
		setVisible(false);
		dispose();
	}

	public void run(){ 

		try{
			InputStream Fichier=new FileInputStream("test.txt"); 
			InputStreamReader INFO=new InputStreamReader(Fichier);
			BufferedReader BINFO=new BufferedReader(INFO);
			String ligne;
			while ((ligne=BINFO.readLine())!=null){
				System.out.println(ligne);
				bestScore=ligne;
			}
			BINFO.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

		menu f = new menu(); 
		Panneau s = new Panneau(f); 
		JMenuBar menuBar = new JMenuBar();
		f.setJMenuBar(menuBar);



		JMenu options = new JMenu("Options");
		menuBar.add(options);

		JMenuItem nouvellePartie = new JMenuItem("Nouvelle Partie");
		JMenuItem quitter = new JMenuItem("Quitter");

		options.add(nouvellePartie);
		options.addSeparator();
		options.add(quitter);

		final menu ax = f;
		final Panneau px = s;


		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("You have clicked on the new action");
				ax.quitte();
				System.exit(0);
			}
		});
		nouvellePartie.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ax.quitte();
				menu m = new menu();
				m.run();
			}
		});
		f.add(s); 


		JLabel Point = f.Point;
		f.add(Point, BorderLayout.NORTH);

		Grille p = new Grille();
		int[][] ss = p.Gril();
		Gestion gest = new Gestion();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(390,490); 
		f.setVisible(true);


	}

}
