package cardGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Interface extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	
		private static final long serialVersionUID = 1L;
		private JButton quitButton = new JButton("Quit");
		private JButton toggle = new JButton("Layer");
		private JButton tool = new JButton("Tool Box");
		private JButton load = new JButton("Load");
		private JButton save = new JButton("Save");
		
		private JButton one = new JButton("A");
		private JButton two = new JButton("B");
		private JButton three = new JButton("C");
		private JButton four = new JButton("D");
		private JButton five = new JButton("1");
		private JButton six = new JButton("2");
		private JButton seven = new JButton("3");
		private JButton eight = new JButton("4");
		
		private javax.swing.Timer timer = new javax.swing.Timer(10,this);
		
		int xPos;
		int yPos;
	    private int height = 0;
	    private int width = 0;
	    private String name = "";
	    
	    private JLabel welcome = new JLabel("WELCOME!");
	    private JLabel heightSpace = new JLabel(" ");
	    private JLabel widthSpace = new JLabel(" ");
	    private JLabel coordsXY = new JLabel("X:  Y:  ");
	    private JLabel nameStrip = new JLabel("Starter Model");
	    
	    
	    
		public Interface(int x, int y, String s){
			setHeight(y);
			setWidth(x);
			setName(s);
			welcome.setText(s);
			heightSpace.setText(Integer.toString(y));
			widthSpace.setText(Integer.toString(x));
			coordsXY.setText("X: " + Integer.toString(x) + " Y: " + Integer.toString(y));
			nameStrip.setText(s);
			initialize();
			
		}//GUI constructor
		 public void update(int xPos,int yPos){
			 
			 String upH = "Y: " + Integer.toString(yPos);
			 String upW = "X: " + Integer.toString(xPos);
			 heightSpace.setText(upH);
			 widthSpace.setText(upW);
			 
			 coordsXY.setText("X: " + Integer.toString(xPos) + " Y: " + Integer.toString(yPos));
		 }//update infoz
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		private void initialize(){
			
			//initialize containers
	        JPanel contentPane = new JPanel();
	        JPanel header = new JPanel();
	        JPanel canvas = new JPanel();
	        JPanel footer = new JPanel();
	        JPanel toolBar = new JPanel();
	        
	        Font f = new Font(name,12,16);
	        
	        Canvas squib = new Canvas();
	        
	        //button font for header
	        one.setFont(f);
	        two.setFont(f);
	        three.setFont(f);
	        four.setFont(f);
	        five.setFont(f);
	        six.setFont(f);
	        seven.setFont(f);
	        eight.setFont(f);
	        
	        
	        //set size of containers
	        contentPane.setPreferredSize(new Dimension(550,350));
	        squib.setPreferredSize(new Dimension(550,150));
	        //header.setPreferredSize(new Dimension(250,250));
	        canvas.setPreferredSize(new Dimension(50,50));
	        footer.setPreferredSize(new Dimension(20,50));
	        toolBar.setPreferredSize(new Dimension(100,250));
	        this.setMinimumSize(new Dimension(2500,2500));
	        
	        //set button sizes
	        //tool bar
	        tool.setPreferredSize(new Dimension(100,35));
	        toggle.setPreferredSize(new Dimension(100,35));
	        load.setPreferredSize(new Dimension(100,35));
	        save.setPreferredSize(new Dimension(100,35));
	        quitButton.setMaximumSize(new Dimension(25,15));
	        
	        //set color of toolBar buttons
	        tool.setBackground(Color.white);
	        toggle.setBackground(Color.white);
	        load.setBackground(Color.white);
	        save.setBackground(Color.white);
	        quitButton.setBackground(Color.white);
	        
	        //set header background color
	        canvas.setBackground(Color.blue);
	        squib.setBackground(Color.green);
	        one.setBackground(Color.white);
	        two.setBackground(Color.white);
	        three.setBackground(Color.white);
	        four.setBackground(Color.white);
	        five.setBackground(Color.white);
	        six.setBackground(Color.white);
	        seven.setBackground(Color.white);
	        eight.setBackground(Color.white);
	        
	        //header size settings
	        one.setPreferredSize(new Dimension(65,65));
	        two.setPreferredSize(new Dimension(65,65));
	        three.setPreferredSize(new Dimension(65,65));
	        four.setPreferredSize(new Dimension(65,65));
	        five.setPreferredSize(new Dimension(65,65));
	        six.setPreferredSize(new Dimension(65,65));
	        seven.setPreferredSize(new Dimension(65,65));
	        eight.setPreferredSize(new Dimension(65,65));
	        
	        
	        //set layout for containers
	        this.setLayout(new BorderLayout());
	        contentPane.setLayout(new BorderLayout());
	        canvas.setLayout(new BorderLayout());
	        footer.setLayout(new BorderLayout());

	        //add containers to frame
	        this.add(header,BorderLayout.NORTH);
	        this.add(toolBar,BorderLayout.WEST);
	        this.add(contentPane,BorderLayout.EAST);
	        this.add(footer,BorderLayout.SOUTH);
	        contentPane.add(canvas, BorderLayout.CENTER);
	        
	        //initialize text of labels
	        welcome.setText("SANDBOX CITY");
	        heightSpace.setText("Y: " + this.getHeight());
	        widthSpace.setText("X: " + this.getWidth());
	        nameStrip.setText("" + this.getName());
	        contentPane.add(coordsXY, BorderLayout.SOUTH);
	        canvas.add(nameStrip, BorderLayout.NORTH);
	       
	        //populate header with square settings button array 
	        header.add(welcome);
	        header.add(one);
	        header.add(two);
	        header.add(three);
	        header.add(four);
	        header.add(five);
	        header.add(six);
	        header.add(seven);
	        header.add(eight);
	        
	       
	        //attach canvas area to middle right
	        canvas.add(squib, BorderLayout.EAST);
	        
	        //populate toolBar with buttons
	        toolBar.add(toggle,BorderLayout.NORTH);
	        toolBar.add(tool,BorderLayout.WEST);
	        toolBar.add(load,BorderLayout.EAST);
	        toolBar.add(save,BorderLayout.SOUTH);
	        toolBar.add(quitButton,BorderLayout.SOUTH);
	 
	        
	        //set font for toolBar buttons
	        tool.setFont(f);
	        toggle.setFont(f);
	        load.setFont(f);
	        save.setFont(f);
	        quitButton.setFont(f);
	        
	        //set text colors
	        welcome.setForeground(Color.white);
	        
	        //set background colors
	        this.setBackground(Color.black);
	        header.setBackground(Color.black);
	        toolBar.setBackground(Color.black);
	        contentPane.setBackground(Color.white);
	        footer.setBackground(Color.black);
	        
	        //add listeners to components
	        this.addMouseListener(this);
	        canvas.addMouseMotionListener(this);
	        squib.addMouseMotionListener(this);
	        contentPane.setBorder(BorderFactory.createLineBorder(Color.black));
	        toggle.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		    

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        tool.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   
	    		} // actionPerformed
	    	    }); // actionListener
	        
	        
	        save.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        load.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        
	        quitButton.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		    System.exit(1);

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        one.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    			

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        two.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        three.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        four.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        five.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        six.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        seven.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        eight.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {

	    		   

	    		} // actionPerformed
	    	    }); // actionListener
	        
	        
	       
		}//initialize
		
		public void addComponent(Container container,
		         Component c, int x, int y, int w, int h)
		 {
		     c.setBounds(x,y,w,h);
		     container.add(c);
		 }
		
		public int getHeight(){
			return height;
		}//getHeight
		
		public void setHeight(int H){
			height = H;
		}//getHeight
		
		public int getWidth(){
			return width;
		}//getWidth
		
		public void setWidth(int W){
			width = W;
		}//setWidth
		
		public String getName(){
			return name;
		}//getName
		
		public void setName(String S){
			name = S;
		}//setName
	    

		
	public static void createAndShowGUI() {
		JFrame gframe = new JFrame("SandBox");
		gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Interface sandy = new Interface(3500,3500,"Starter Model");
		gframe.add(sandy);
		gframe.getContentPane().setBackground(Color.black);
		gframe.pack();
		gframe.setVisible(true);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
		/*	
	    final CustomCursor mouseLabel = new CustomCursor();

	    // add my component to the DRAG_LAYER of the layered pane (JLayeredPane)
	    JLayeredPane layeredPane = gframe.getRootPane().getLayeredPane();
	    layeredPane.add(mouseLabel, JLayeredPane.DRAG_LAYER);
	    mouseLabel.setBounds(0, 0, gframe.getWidth(), gframe.getHeight());
		*/
	}//createAndShowGUI



	/*
	// add a mouse motion listener, and update my custom mouse cursor with the x/y
	// coordinates as the user moves the mouse
	this.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
	  public void mouseMoved(MouseEvent me)
	  {
	    mouseLabel.x = me.getX();
	    mouseLabel.y = me.getY();
	    mouseLabel.repaint();
	  }
	});
	*/

	@Override
	public void mouseDragged(MouseEvent e) {
		 timer.start();
		 JInternalFrame iframe = new JInternalFrame();
	     Rectangle r = new Rectangle(iframe.getBounds());
	     
	     xPos = (int) (r.getX());
	     yPos = (int) (r.getY());
	    /* 
		 JInternalFrame iframe2 = new JInternalFrame();
				 Container c = iframe2.getContentPane();
				 Rectangle r2 = c.getBounds();
				 r2 = SwingUtilities.convertRectangle(c.getParent(), r2, iframe2.getParent());
		 update(xPos,yPos); */
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
}//Interface Class
