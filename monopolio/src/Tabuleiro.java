import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Tabuleiro extends JPanel{
	//JLabel imageTab = new JLabel();
	

	Image tab;
	Jogador[] jogadores;
	public Tabuleiro(){
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl = (screenSize.width)/2;
		int sa = (screenSize.height);
		jogadores = new Jogador[6];
		
		jogadores[0] = new Jogador(20, 30);
		jogadores[1] = new Jogador(45, 5);
		jogadores[2] = new Jogador(34, 18);
		jogadores[3] = new Jogador(56, 32);
		jogadores[4] = new Jogador(21, 15);
		jogadores[5] = new Jogador(13, 25);
		
		try
		{
			setBounds(0, 0, sl, sa);
			
			tab=ImageIO.read(new File("img/tabuleiro.png"));
			jogadores[0].img = ImageIO.read(new File("img/black_pin.png"));
			jogadores[1].img = ImageIO.read(new File("img/blue_pin.png"));
			jogadores[2].img = ImageIO.read(new File("img/red_pin.png"));
			jogadores[3].img = ImageIO.read(new File("img/orange_pin.png"));
			jogadores[4].img = ImageIO.read(new File("img/yellow_pin.png"));
			jogadores[5].img = ImageIO.read(new File("img/purple_pin.png"));
		

		}
		catch(IOException e){
		};
	}
	public void paintComponent(Graphics g)
	{ 		
		super.paintComponent(g);
		g.drawImage(tab, 0, 0, 600, 600, null);
		for(int i = 0; i < jogadores.length; i++)
		{
			if(jogadores[i]!=null && jogadores[i].img!=null)
			{
				g.drawImage(jogadores[i].img, jogadores[i]._x, jogadores[i]._y, null);
			}
		}
	} 
}