package HW12;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener // 繼承父類Jframe
{
	static int score;

	Ball ball = new Ball(this);	
	Racquet racquet = new Racquet(this);
	
	public Window() { // 建構子
		this.setTitle("不讓球掉下來!!"); // 視窗的標題
		this.setSize(600, 600); // 視窗的寬和高
		this.setVisible(true); // 顯示視窗
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 視窗的關閉按鈕、使用System exit方法退出應用程式
		this.setLocationRelativeTo(null); //讓視窗置中
		this.addKeyListener(this);

	}
		
	private void move()
	{
		ball.moveBall();
		racquet.moveRacquet();
	}
	
	//private void ;

	public void paint(Graphics g) { // 覆蓋從JFrame或者JPanel類別繼承的方法，這個方法會被系統自動呼叫。

		super.paint(g);  //呼叫從父類JFrame繼承的paint方法，這樣才不會留存之前的螢幕內容
		Graphics2D g2d = (Graphics2D) g; // 進行物件轉型,因為Graphic2D的方法比較好也比較豐富,它也繼承Graphics這個類別

		// 在視窗上設計分數
		g2d.setColor(Color.GRAY); //畫筆顏色
		g2d.setFont(new Font("Verdana", Font.BOLD, 50)); //字型
		g2d.drawString(String.valueOf(score), 500, 120);
		
		ball.paint(g2d);
		racquet.paint(g2d);

	}

	
	public static void main(String[] args) throws InterruptedException // 這個是丟擲異常用來防止執行緒異常的
	{
		Window window = new Window(); // 建立window物件
		while (true)
		{
			window.move();
			window.repaint();
			Thread.sleep(60);
		}
		
	}

	public void keyPressed (KeyEvent e)
	{
		racquet.KeyPressed(e);
	}
	
	public void keyReleased (KeyEvent e)
	{
		racquet.KeyReleased(e);
	}
	
	public void keyTyped (KeyEvent e)
	{
		
	}
}
	