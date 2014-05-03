import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogador {

	public Image img;
	
	private int pos;
	
	public int _x, _y;
	
	private int xi, yi;
	
	public Jogador() {
		pos = 0;
		_x = 0;
		_y = 0;
		xi = 0;
		yi = 0;
		this.move(0);
	}
	
	public Jogador(int x, int y) {
		pos = 0;
		_x = x;
		_y = y;
		xi = x;
		yi = y;
		this.move(0);
	}
	
	
	public void move(int steps) {
		pos+=steps;
		
		if(pos > 39) {
			pos -= 40;
		}
		
		if(pos < 10) {
			_x = xi + 500;
			_y = yi + 50 * pos;
		} else if( pos < 20) {
			_x = xi + 500 - (50 * (pos - 10));
			_y = yi + 500;
		} else if( pos < 30) {
			_x = xi;
			_y = yi + 500 - (50 * (pos - 20));
		} else {
			_x = xi + 50 * (pos - 30);
			_y = yi;
		}
	}
}