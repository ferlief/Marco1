import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tabuleiro extends JPanel{
	//JLabel imageTab = new JLabel();
	

	Image tab, dado;
	Jogador[] jogadores;
	int a;
	public boolean resDado, valor;
	public Tabuleiro(){
		/*imageTab.setIcon(new ImageIcon ("Tab/tabuleiro.png"));
		imageTab.setSize(300, 300);
		add(imageTab);
		setVisible(true);*/
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl = (screenSize.width)/2;
		int sa = (screenSize.height);
		jogadores = new Jogador[6];
		
		jogadores[0] = new Jogador(20, 20);
		jogadores[1] = new Jogador(15, 25);
		
		try
		{
			setBounds(0, 0, sl, sa);
			
			tab=ImageIO.read(new File("img/tabuleiro.png"));
			jogadores[0].img = ImageIO.read(new File("img/black_pin.png"));
			jogadores[1].img = ImageIO.read(new File("img/blue_pin.png"));

			
			/*
			pblue = ImageIO.read(new File("img/blue_pin.png"));
			pblack = ImageIO.read(new File("img/black_pin.png"));
			pred = ImageIO.read(new File("img/red_pin.png"));
			porange = ImageIO.read(new File("img/orange_pin.png"));
			pyellow = ImageIO.read(new File("img/yellow_pin.png"));
			ppurple = ImageIO.read(new File("img/purple_pin.png"));
			*/
		}
		catch(IOException e){
		};
		/*DadosPanel obter = new DadosPanel();
		a=obter.getResultDado();*/
	}
	public void paintComponent(Graphics g)
	{ 		
		super.paintComponent(g);
		g.drawImage(tab, 0, 0, 600, 600, null);//carrega tabuleiro
		for(int i = 0; i < jogadores.length; i++)
		{
			if(jogadores[i]!=null && jogadores[i].img!=null)
			{
				g.drawImage(jogadores[i].img, jogadores[i]._x, jogadores[i]._y, null);
			}
		}
		
		/*
		g.drawImage(pblue, getWidth()-40, getHeight()-100, null);//carrega os pinos
		g.drawImage(pblack, getWidth()-60, getHeight()-90, null);
		g.drawImage(pred, getWidth()-80, getHeight()-90, null);
		g.drawImage(ppurple, getWidth()-40, getHeight()-60, null);
		g.drawImage(pyellow, getWidth()-60, getHeight()-60, null);
		g.drawImage(porange, getWidth()-80, getHeight()-60, null);
		*/
		//add(new DadosPanel());
		setBackground(Color.WHITE);
	} 
	class buttonDado implements ActionListener{
		public void actionPerformed(ActionEvent e){
		System.out.println(resDado);
		System.out.println("Count of listeners: " + ((JButton) e.getSource()).getActionListeners().length);
		}
		}
}