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
	int VJogador;
	boolean resposta = false;
	boolean numJogador = false;
	Image imagensDados[];
	Tabuleiro tab;
	DadosPanel dp;


	//JLabel imageTab = new JLabel();
	public Mesa(String s)
	{
		super(s);
		setLayout(null);
		Container c = getContentPane();
		c.setBackground(Color.white);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		jogarDado = new JButton("Jogar Dado");
		jogarDado.setBounds(750,50,100,30);
		jogarDado.addActionListener(new jogarDadosButton_Click());
		add(jogarDado);

		random = new Random();
		imagensDados = new Image[6];
		valores = new int[2];

		JMenuBar MenuBar1 = new JMenuBar();
        JMenu jMenu1 = new JMenu();
        JMenu jMenu2 = new JMenu();
        jMenu1.setText("Jogo");
        MenuBar1.add(jMenu1);
        jMenu2.setText("Ações");
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
		dp = new DadosPanel(tab.jogadores);
		tab.setBounds(100, 100, 600, 600);
		dp.setBounds(20, 700, 150, 100);
		add(tab);
		add(dp);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		if(resposta == true)
			{
			for(int n = 0; n < 2; n++)
				g.drawImage(imagensDados[valores[n] - 1], 800+(150*n), 200, 100, 100, null);
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
			tab.jogadores[dp.jogadorComboBox.getSelectedIndex()].move(r);
			repaint();
			System.out.printf("%d - %d -  %d\n", tab.jogadores[0]._x, tab.jogadores[0]._y, r);
			resposta=true;
		}
	}
	
}