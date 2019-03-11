package chuanqi;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cq
{
	//TODO:变量“声明”在下面
	int x;
	int y;
	int bian;
	int bian2;
	MyWindow	ck	= null;//窗口
	MyTimer	ds1	= null;//定时器
	cq()
	{
		//TODO:程序初始化在下面
		x=200;
		y=200;
		bian=0;
		bian2=0;
		ck = new MyWindow();
		//窗口 宽+2*立体边, 高+2*立体边+标题栏
		ck.setSize(5 * 2 + 600, 600 + 2 * 5 + 25);
		//设定窗口可见性setVisible  true/false
		ck.setVisible(true);
		//延时的毫秒
		ds1 = new MyTimer(50);
	}

	class MyWindow extends JFrame
	{
		MyMenu		cd		= null;//菜单
		MyMb		mb		= null;//面板
		MyWindowListen	exit	= null;//窗口监听器
		MyKeyListen	jp		= null;//键盘监听器

		MyWindow()
		{
			jp = new MyKeyListen();
			this.addKeyListener(jp);

			mb = new MyMb();
			this.add(mb);

			exit = new MyWindowListen();
			this.addWindowListener(exit);

			this.repaint();
		}

		class MyMenu extends JMenuBar
		{
			JMenu		dan;	//菜单
			JMenuItem	xiang1; //菜单项

			MyMenuListen		cdjtq;

			MyMenu()
			{
				dan = new JMenu("游戏"); //菜单
				xiang1 = new JMenuItem("开局"); //菜单项

				this.add(dan);
				dan.add(xiang1);

				cdjtq = new MyMenuListen();
				xiang1.addActionListener(cdjtq);
			}

			class MyMenuListen implements ActionListener
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					//TODO:菜单事件处理
					if (e.getSource() == xiang1)
					{

					}
				}
			}
		}

		class MyWindowListen extends WindowAdapter
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				ds1.xc.stop();
				System.exit(0);
			}
		}

		class MyKeyListen implements KeyListener
		{
			//TODO:键盘按下，可加入KeyEvent.VK_XXX
			@Override
			public void keyPressed(KeyEvent e)
			{
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_LEFT://左键
						bian=3;
						bian2=0;
						break;
					case KeyEvent.VK_RIGHT://右键
						bian=1;
						bian2=0;
						break;
					case KeyEvent.VK_UP://上键
						bian=0;
						bian2=0;
						break;
					case KeyEvent.VK_DOWN://下键
						bian=2;
						bian2=0;
						break;
					case KeyEvent.VK_1://大键盘数字1

						break;
					case KeyEvent.VK_W://W键盘

						break;
				}
				ck.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				//TODO:键盘释放，可加入KeyEvent.VK_XXX
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_LEFT://左键

						break;
					case KeyEvent.VK_RIGHT://右键

						break;
					case KeyEvent.VK_UP://上键

						break;
					case KeyEvent.VK_DOWN://下键

						break;
					case KeyEvent.VK_1://大键盘数字1

						break;
					case KeyEvent.VK_W://W键盘

						break;
				}
				ck.repaint();
			}

			@Override
			public void keyTyped(KeyEvent e)
			{
			}
		}

		class MyMb extends JPanel
		{
			MyMouseListen	sb	= null;

			MyMb()
			{
				sb = new MyMouseListen();
				this.addMouseListener(sb);
				this.addMouseMotionListener(sb);
			}

			class MyMouseListen extends MouseAdapter implements MouseMotionListener
			{
				@Override
				public void mousePressed(MouseEvent e)
				{
					//mx my鼠标的位置
					int mx = e.getX();
					int my = e.getY();
					//TODO :鼠标按下 在下面

					ck.repaint();
				}

				@Override
				public void mouseDragged(MouseEvent e)
				{
					//mx my鼠标的位置
					int mx = e.getX();
					int my = e.getY();
					//TODO :鼠标拖拽 在下面

					ck.repaint();
				}

				@Override
				public void mouseMoved(MouseEvent e)
				{
					//mx my鼠标的位置
					int mx = e.getX();
					int my = e.getY();
					//TODO :鼠标移动 在下面

					ck.repaint();
				}

				@Override
				public void mouseReleased(MouseEvent e)
				{
					//mx my鼠标的位置
					int mx = e.getX();
					int my = e.getY();
					//TODO :鼠标释放 在下面

					ck.repaint();
				}

				@Override
				public void mouseClicked(MouseEvent e)//鼠标单击
				{

				}
			}

			@Override
			public void paint(Graphics g)
			{
				//g.setColor(Color.BLUE);	//设定颜色：RED GREEN  BLUE  ORANGE
				//TODO:绘图在下面
				//背景
				Image tu = (new ImageIcon("热血传奇/传奇地图.png")).getImage();
				g.drawImage(tu, 0, 0, null);//绘制图片API
				//人物
				Image ren = (new ImageIcon("热血传奇/"+bian+"-"+bian2+".png")).getImage();
				g.drawImage(ren, x, y, null);//绘制图片API
			}
		}
	}

	class MyTimer implements Runnable//实现Runnable接口
	{
		Thread	xc	= null;
		long	jianGe;

		MyTimer(long jianGe)
		{
			this.jianGe = jianGe;
			xc = new Thread(this);
			xc.start();
		}

		@Override
		public void run()
		{
			while (true)
			{
				try
				{
					Thread.sleep(jianGe);

					if (this == ds1)
					{
						//TODO:定时处理 在下面
						if (  bian==1  )
						{
							x=x+10;
						}
						if (    bian==0     )
						{
							y=y-10;
						}
						if (    bian==2     )
						{
							y=y+10;
						}
						if (    bian==3     )
						{
							x=x-10;
						}
						//动作
						if (  bian2==5  )
						{
							bian2=0;
						}
						else
						{
							bian2++;
						}
						ck.repaint();
					}
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	//main主方法 ，主类的“入口方法”
	public static void main(String[] args)
	{
		new cq();
	}
}
