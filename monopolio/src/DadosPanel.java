import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DadosPanel extends JPanel{
	Random random;
	Image imagensDados[];
	public int valores[];
	JButton jogarDadosButton;
	JComboBox jogador;
	int result = 0, resultDado, VJogador;
	boolean resposta = false;
	boolean numJogador = false;
	DadosPanel()
	{
		random = new Random();
		imagensDados = new Image[6];
		valores = new int[2];
		jogarDadosButton = new JButton("Jogar Dados");
		jogador = new JComboBox();
		jogador.setModel(new DefaultComboBoxModel(new String[] { "Jogador 1", "Jogador 2", "Jogador 3", "Jogador 4" }));
		jogarDadosButton.addActionListener(new jogarDadosButton_Click());
		jogador.addActionListener(new NumJogador());
		add(jogarDadosButton);
		add(jogador);

		this.setBackground(Color.white);


		for(int n = 0; n < 6; n++)
		{
			String caminho = "Dados/"+(n+1)+".png";
			try
			{
				imagensDados[n] = ImageIO.read(new File(caminho));
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(caminho);
			}
		}
	}
	
	public void JogarDados()
	{
		for(int n = 0; n < 2; n++){
			result+=valores[n];
			valores[n] = random.nextInt(6) + 1;
		}
			
		repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		//add(new Tabuleiro());
		if(resposta == true)
			{
			for(int n = 0; n < 2; n++)
				g.drawImage(imagensDados[valores[n]], 600+(150*n), 100, 100, 100, null);
			}
		
	}
	
	public class jogarDadosButton_Click implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JogarDados();
			resposta=true;
		}
	}
	public class NumJogador implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//verificar qual opção da comboBox foi selecionada e setar(setPin), pra saber qual pino ira se mover
			numJogador = true;
		}
	}
	public int getVPin(){
		return this.VJogador;
	}
	public void setVPin(int valor){
		this.VJogador=valor;
	}
	public int getResultDado(){
		return this.resultDado;
	}
	public void setResulDado(int valor){
		this.resultDado=valor;
	}
}
