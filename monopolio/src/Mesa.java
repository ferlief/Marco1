import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Mesa extends JFrame 
{
	Random random;
	JButton jogarDado;
	public int valores[];
	int VJogador;
	boolean mostraDados = false;
	Image imagensDados[];
	Tabuleiro tab;
	DadosPanel dp;

	public Mesa(String s)
	{
		super(s);
		setLayout(null);
		setBackground(Color.white);
		Container c = getContentPane();
		c.setBackground(Color.white);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		jogarDado = new JButton("Jogar Dados");
		jogarDado.setBounds(750,50,120,30);
		jogarDado.addActionListener(new jogarDadosButton_Click());
		add(jogarDado);

		random = new Random();
		imagensDados = new Image[6];
		valores = new int[2];

		JMenuBar MenuBar = new JMenuBar();
        setJMenuBar(MenuBar);
        
		for(int n = 0; n < 6; n++)
		{
			String caminho = "img/Dice"+(n+1)+".png";
			try
			{
				imagensDados[n] = ImageIO.read(new File(caminho));
			}
			catch (IOException e)
			{
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
		if(mostraDados == true)
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
			mostraDados=true;
		}
	}
	
}