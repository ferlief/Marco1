import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Mesa extends JFrame 
{
	Random random;
	JButton jogarDado;
	public int valores[];
	int result = 0, resultDado, VJogador;
	boolean resposta = false;
	boolean numJogador = false;
	Image imagensDados[];
	Tabuleiro tab;


	//JLabel imageTab = new JLabel();
	public Mesa(String s)
	{
		super(s);
		setLayout(null);
		Container c=getContentPane();
		c.setBackground(Color.white);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		jogarDado = new JButton("Jogar Dado");
		jogarDado.setBounds(750,50,100,30);
		jogarDado.addActionListener(new jogarDadosButton_Click());
		c.add(jogarDado);

		random = new Random();
		imagensDados = new Image[6];
		valores = new int[2];

		JMenuBar MenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenu jMenu2 = new JMenu();
        jMenu1.setText("Jogo");
        MenuBar1.add(jMenu1);
        jMenu2.setText("A��es");
        MenuBar1.add(jMenu2);
        setJMenuBar(MenuBar1);
        
		for(int n = 0; n < 6; n++)
		{
			String caminho = "img/Dice"+(n+1)+".png";
			try
			{
				imagensDados[n] = ImageIO.read(new File(caminho));
				System.out.println(caminho);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(caminho);
			}
		}

		tab = new Tabuleiro();
		c.add(tab);
		//add(new DadosPanel());
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		//add(new Tabuleiro());
		if(resposta == true)
			{
			for(int n = 0; n < 2; n++)
				g.drawImage(imagensDados[valores[n] - 1], 700+(150*n), 200, 100, 100, null);
			}
		
	}
	
	public int JogarDados()
	{
		int r = 0;
		for(int n = 0; n < 2; n++){
			valores[n] = random.nextInt(6) + 1;
			r+=valores[n];
			System.out.println(valores[n]);
		}

		return r;
	}
	
	public class jogarDadosButton_Click implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int r = JogarDados();
			tab.p1.move(r);
			repaint();
			System.out.printf("%d - %d -  %d\n", tab.p1._x, tab.p1._y, r);
			resposta=true;
		}
	}
	
}