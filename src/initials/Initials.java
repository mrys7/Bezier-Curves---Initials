package initials;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Curve {
    public int x0;
    public int x1;
    public int x2;
    public int x3;
    public int y0;
    public int y1;
    public int y2;
    public int y3;
    public Curve(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3){
        this.x0=x0;
        this.y0=y0;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
    }
}

class Surface extends JPanel {
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        
        

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
               RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        
        g2d.setPaint(new Color(0,0, 0));

        double Px=0, Py=0;
        LinkedList<Curve> Curves = new LinkedList<Curve>();
        //M
        Curves.add(new Curve(77,358,121,348,97,179,104,182));
        Curves.add(new Curve(104,182,112,187,163,220,165,248));
        Curves.add(new Curve(165,248,165,263,205,184,210,185));
        Curves.add(new Curve(210,185,221,187,219,342,247,348));
        Curves.add(new Curve(247,348,252,349,206,345,206,343));
        Curves.add(new Curve(206,343,201,317,199,255,194,253));
        Curves.add(new Curve(194,253,189,251,167,298,166,296));
        Curves.add(new Curve(166,296,159,283,129,255,128,240));
        Curves.add(new Curve(128,240,127,255,134,331,133,340));
        Curves.add(new Curve(133,340,131,355,91,366,77,360));
        //R
        Curves.add(new Curve(322,356,322,371,296,164,300,150));
        Curves.add(new Curve(300,150,303,140,384,107,402,210));
        Curves.add(new Curve(402,210,410,255,393,267,378,268));
        Curves.add(new Curve(378,268,363,269,423,351,444,330));
        Curves.add(new Curve(444,330,446,328,443,356,442,356));
        Curves.add(new Curve(442,356,376,360,337,262,339,261));
        Curves.add(new Curve(339,261,346,258,380,262,380,222));
        Curves.add(new Curve(380,222,380,205,369,160,329,171));
        Curves.add(new Curve(329,171,315,175,351,335,351,350));
        Curves.add(new Curve(351,350,351,352,343,362,323,358));
        for(int i=0;i<Curves.size();i++){
        for(double t=0.0; t<=1.0; t=t+0.001)
        {
            Px = Math.pow(1-t,3)*Curves.get(i).x0 + 3*Math.pow(1-t,2)*t*Curves.get(i).x1+3*(1-t)*t*t*Curves.get(i).x2+t*t*t*Curves.get(i).x3;
            Py = Math.pow(1-t,3)*Curves.get(i).y0 + 3*Math.pow(1-t,2)*t*Curves.get(i).y1+3*(1-t)*t*t*Curves.get(i).y2+t*t*t*Curves.get(i).y3;
            
           g2d.drawLine((int)Math.round(Px), (int)Math.round(Py), (int)Math.round(Px), (int)Math.round(Py));
        }
        }
   } 
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        doDrawing(g);
    }    
}

public class Initials extends JFrame {

    public Initials() {

        initUI();
    }
    
    private void initUI() {
        
        add(new Surface());
        
        setTitle("Basic shapes");
        setSize(600, 600);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
        
            @Override
            public void run() {
                Initials ex = new Initials();
                ex.setVisible(true);
            }
        });
    }
}