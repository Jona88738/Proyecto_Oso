/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.black;
import static java.awt.Color.red;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jona
 */
public class Ventana extends JFrame implements Runnable {

    JPanel pan = new JPanel();
    BufferedImage buffer;
    Graphics graPixel;
    
    
    Thread hilo;
    Dimension d ;
    Image imagen,numeros ;
 
    Image imgFondo = null,relojBuffer,caratulaReloj;
    Graphics buff;
    
    
    
    private int centerX, centerY;
    private int radius = 100;
    private int secondAngle = -95;
    
    private int minAngle = -95;
    private int contMinutos = 0;
    private int horaAngle = 0;
    
    //Hora y minutos actuales
    
    private int HoraActual = 0;
    private int minutoActual = 0;
    
    private int minute = 0; 
  
  boolean banderaCirculo = false;
    public Ventana() {
        panel();
        //buffer = new BufferedImage();
        
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
      
        graPixel = (Graphics2D) buffer.createGraphics();
        
         
        
        hilo = new Thread(this);
        hilo.start();
        
         
    }

    private void panel() {

        JLabel titulo = new JLabel();
        this.setSize(500, 700);
        this.setLayout(null);
        //this.setResizable(false);
        this.setTitle("Proyecto Reloj");
        this.getContentPane().add(pan);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        titulo.setText("");
        titulo.setBounds(200, 20, 200, 50);
        pan.add(titulo);
    }

         int aa = 10;

         int banderamin = 0;
         //                  12   1   2  3  4  5  6  7   8   9  10  11
         int AngulosNum[] = {-90,-47,-23,7,37,61,85,115,151,187,211,241};
         int minAngulos[] = {5,10,15,20,25,30,35,40,45,50,55,60};
         
         boolean manecillaMinuto = true;
         int minsuma = 5;
    public void paint(Graphics g){
        //color de oso96,83,70
        Color color = new Color(63,40,23);
        
        //super.paint(g);
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
       // g.setColor(Color.ORANGE);
        
        if(imgFondo == null){
            //fondo Principal
            imgFondo = this.createImage(this.getWidth(),this.getHeight());
             Graphics fondo = imgFondo.getGraphics();
             ImageIcon imagen = new ImageIcon("fondoCielo.jpg");
             
             
            
             
            
            fondo.drawImage(imagen.getImage(), 0, 0, pan);
            
             //fondo Reloj
             
              
             //fondoreloj.drawImage(imgFondo, 0, 0, pan);
             
             
             //ImageIcon imagen = new ImageIcon("fondoReloj.jpg");
            
            Graphics manoOso= imgFondo.getGraphics();
            
          //  System.out.println("Entro primero");
            
            // circulo Cuerpo de oso
            Graphics rectangulo = imgFondo.getGraphics();
             rectangulo.setColor(color);
             rectangulo.fillOval(50, 160, 400, 400);
             
             //cabeza del oso
             
             algoritmoCirculoPolar(250,120,80,g);
             
              manoOso.setColor(color);
             //coordenadas
             manoOso.fillOval(170, 40, 160, 160);
             //Boca del oso
             manoOso.setColor(Color.orange);
             manoOso.fillOval(210, 100, 80, 80);
             algoritmoCirculoPolar(250,140,40,g);
             
             //ojos del oso
             manoOso.setColor(Color.BLACK);
             manoOso.fillOval(210, 70, 20, 20);
             
             manoOso.setColor(Color.BLACK);
             manoOso.fillOval(270, 70, 20, 20);
             
             algoritmoCirculoPolar(220,80,8,g);
             algoritmoCirculoPolar(280,80,8,g);
             
             //Nariz del oso
              manoOso.setColor(Color.BLACK);
             manoOso.fillOval(240, 110, 20, 20);
             algoritmoCirculoPolar(250,120,8,g);
             
             //manos del oso
             elipse(60,70,420,250,g);
             elipse(60,70,90,250,g);
             
             //Graphics manoOso= imgFondo.getGraphics();
             
             manoOso.setColor(color);
             manoOso.fillOval(360, 180, 120, 140);
             
             manoOso.setColor(color);
             manoOso.fillOval(30, 180, 120, 140);
             
             algoritmoCirculoPolar(50,240,15,g);
             algoritmoCirculoPolar(85,210,15,g);
             algoritmoCirculoPolar(120,240,15,g);
             
             algoritmoCirculoPolar(380,240,15,g);
             algoritmoCirculoPolar(420,210,15,g);
             algoritmoCirculoPolar(460,240,15,g);
             
             manoOso.setColor(Color.ORANGE);
             manoOso.fillOval(35, 225, 30, 30);
             manoOso.fillOval(70, 195, 30, 30);
             manoOso.fillOval(105, 223, 30, 30);
             
             manoOso.fillOval(365, 225, 30, 30);
             manoOso.fillOval(405, 195, 30, 30);
             manoOso.fillOval(445, 223, 30, 30);
             
             //ovalo patas del oso xD  elipse(int rx,int ry, int xc, int yc)
             elipse(60,70,390,520,g);
             elipse(60,70,110,520,g);
             
             algoritmoCirculoPolar(70,500,15,g);
             algoritmoCirculoPolar(110,480,15,g);
             algoritmoCirculoPolar(145,500,15,g);
             
             
             algoritmoCirculoPolar(360,500,15,g);
             algoritmoCirculoPolar(390,480,15,g);
             algoritmoCirculoPolar(420,500,15,g);
             
             
             manoOso.setColor(color);
             manoOso.fillOval(330, 450, 120, 140);
             
             manoOso.setColor(color);
             manoOso.fillOval(50, 450, 120, 140);
             
             manoOso.setColor(Color.ORANGE);
             manoOso.fillOval(55, 485, 30, 30);
             manoOso.fillOval(95, 465, 30, 30);
             manoOso.fillOval(128, 485, 30, 30);
             
             manoOso.fillOval(345, 485, 30, 30);
             manoOso.fillOval(375, 465, 30, 30);
             manoOso.fillOval(405, 485, 30, 30);
             
            g.drawImage(imgFondo, 0, 0, pan);
            
            
            //reloj interior
            Graphics fondoreloj = imgFondo.getGraphics();
              fondoreloj.setColor(Color.PINK);
              fondoreloj.fillOval(100, 200, 300,300);
            
            
            //Funcion  
            numeroReloj(g);   
            algoritmoCirculoPolar(this.getWidth()/2,this.getHeight()/2,150,g);
            //funcion
           //  diseñoDeAfueraReloj(g);
             
             
             //rectangulo.drawRect(90, 200, 200, 300);
        g.drawImage(imgFondo, 0, 0, pan);
        }
        
        //Hora Actual
        Calendar calendar = Calendar.getInstance();
       
        
        if(calendar.get(Calendar.HOUR)-1 != HoraActual){
            HoraActual = calendar.get(Calendar.HOUR)-1;
           // System.out.println("Hora actual" +HoraActual);
            for(int j = 0; j <11; j++){
                if(HoraActual == j){
                    horaAngle = AngulosNum[j];
                }else if(HoraActual == 0){
                    horaAngle = AngulosNum[0];
                }
               // manecillaMinuto = false;
                
            }
        }
    
        
        if( manecillaMinuto == true){
            /*
            HoraActual = calendar.get(Calendar.HOUR)-1;
            System.out.println("Hora actual" +HoraActual);
            for(int j = 0; j <11; j++){
                if(HoraActual == j){
                    horaAngle = AngulosNum[j];
                }else if(HoraActual == 0){
                    horaAngle = AngulosNum[0];
                }
                manecillaMinuto = false;
                
            }
            */
            manecillaMinuto = false;
            
            minutoActual = calendar.get(Calendar.MINUTE);
           // System.out.println("Minuto Actual: "+minutoActual);
            
            int auxMinAngle = 0;
            for(int j = 0; j <11; j++){
            
                if(minutoActual <= minAngulos[j]){
                  //  System.out.println("minuto seleccionado"+ minAngulos[j]);
                    minAngle = AngulosNum[j];
                    auxMinAngle = minAngulos[j]- minutoActual+minsuma  ;
                    
                    minAngle += auxMinAngle;
                    break;
                    
                }
            }
            
            
        }
        //
        relojBuffer = this.createImage(this.getHeight(), this.getHeight());
        Graphics gbufferReloj = relojBuffer.getGraphics();
        gbufferReloj.drawImage(imgFondo, 0, 0, pan);
        
        
        
        
        
         //A qui van los centro
        double minX,minY; 
         secondAngle += 6; // Incrementa el ángulo en cada paso (6 grados por segundo, 360 grados en 60 segundos)
                           //271 360
         if (secondAngle >= 271 ) {
            secondAngle = -95;
            
            minAngle += 6;
            minutoActual++;
          // minsuma +=8;
            //Min 
             minX = centerX + radius * Math.cos(Math.toRadians(minAngle));
             minY = centerY + radius * Math.sin(Math.toRadians(minAngle));
            gbufferReloj.setColor(Color.GREEN);
           //  System.out.println("Entro el segundo");
            gbufferReloj.drawLine(centerX, centerY, (int) minX, (int) minY);
            g.drawImage(relojBuffer, 0, 0, pan);
            //aqui g
            
            
        }else if(minAngle >= 271){
            minAngle = -95;
            
        }else if(horaAngle >= 271){
            minAngle = -95;
        }
         
        // Calcular las coordenadas de la punta de la manecilla de segundos
        double secondX = centerX + radius * Math.cos(Math.toRadians(secondAngle));
        double secondY = centerY + radius * Math.sin(Math.toRadians(secondAngle));
       // System.out.println(secondX +"Y: "+ secondY+" seconAngle: "+ secondAngle);
        gbufferReloj.setColor(Color.RED);
        gbufferReloj.drawLine(centerX, centerY, (int) secondX, (int) secondY);
        //Aqui g
        g.drawImage(relojBuffer, 0, 0, pan);
        if(banderamin == 0){
            //banderamin++;
            //minAngle += 6;
            //System.out.println("Entro ");
            
             minX = centerX + radius * Math.cos(Math.toRadians(minAngle));
             minY = centerY + radius * Math.sin(Math.toRadians(minAngle));
            gbufferReloj.setColor(Color.BLACK);
            gbufferReloj.drawLine(centerX, centerY, (int) minX, (int) minY);
            //aqui g
            g.drawImage(relojBuffer, 0, 0, pan);
            
            
            double HoraX = centerX + radius * Math.cos(Math.toRadians(horaAngle));
            double HoraY = centerY + radius * Math.sin(Math.toRadians(horaAngle));
            gbufferReloj.setColor(Color.BLUE);
            gbufferReloj.drawLine(centerX, centerY, (int) HoraX, (int) HoraY);
            
            g.drawImage(relojBuffer, 0, 0, pan);
            
            
        }
        
        if(contMinutos == 60){
             horaAngle += 6;
        }
        
    
    }
    
     public void algoritmoCirculoPolar(int xcc, int ycc,int rr,Graphics g){
         
         int xAux[] = new int[300];
        int yAux[] = new int[300];
         
         
        int xc = xcc;
        int yc = ycc;
        int r = rr;
            //150
        int i = 0;
          for (double theta = 0; theta <= 2 * Math.PI; theta += 0.0001) {
            int x = (int) (xc + r * Math.cos(theta));
            int y = (int) (yc + r * Math.sin(theta));
            
         
            Graphics cara = imgFondo.getGraphics();
             buffer.setRGB(0, 0, Color.black.getRGB());
             cara.drawImage(buffer, x, y, pan);
            
        }
        
      
      
        
    }
    
    /*
    public void update(Graphics g){
        
        //super.paint(g);
    }
     */
    private void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        buff.drawImage(buffer, x, y, pan);
   
    }
   
     public void  AlgoritmoLineaBresenham(Graphics g,int xx){
         
         
        int x0 = 240;
        int y0 = 250;
        int x1 = 240+xx;
        int y1 = 150+xx;
        int x[] = new int[300];
        int y[] = new int[300];
        int dx =  x1 - x0;
        int dy  = y1 - y0;
        
        int p0 = 2*dy -dx;
        int i = 0;
        
        while(x0 != x1 && y0 != y1){
            
            if(p0 < 0 ){
                x0++;
                //y0--;
                p0 = p0 +2*dy;
                x[i] = x0;
                y[i] = y0;
                i++;
               //y0++;
            } else if(p0 > 0){
                
                x0++;
                y0++;
                p0 = p0 +2*dy + 2*dx;
                x[i] = x0;
                y[i] = y0;
                i++;
                
            }
        }
        
        
        
        for(int d = 0; d < i ; d++){
            
            putPixel(x[d],y[d],black);
        }
        g.drawImage(imagen, 0, 0, pan);
       
       
        
    }
    
      public void EcuacionRecta(int x0,int y0,int x1,int y1,int m,int ordenada,Graphics g){
          aa += 10;
        int valores = 120;
        int x = x0;
        int y = y0;
        
          Graphics cara = imgFondo.getGraphics();
        
        if(x0 == x1){
            
             for(int i = 0; i < y1 ; i++ ){
            
            x = m *100 +ordenada;

           buffer.setRGB(0, 0, Color.black.getRGB());
           
             cara.drawImage(buffer, x, y, pan);
            y++;
        }
        }else if(y0 == y1){
         
         for(int i = 0; i < x1 ; i++ ){
            
            y = m *100 +ordenada;
            //System.out.println("Y = "+y);
            //putPixel(x,y,black);
             buffer.setRGB(0, 0, Color.black.getRGB());
             cara.drawImage(buffer, x, y, pan);
            x++;
        }
     }
        
        
    g.drawImage(buffer, 0, 0, pan);  
     }
     
    @Override
    public void run() {
        
      
        while(true){
            repaint();
            
            try {
                hilo.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            
        }
    }
    
    String imagenes[] = {"miAux.png","num2.png","num3.png","num4.png","num5.png","num6.png","num7.png","num8.png","num9.png","miAux.png","num0.png","miAux.png","miAux.png","miAux.png","num2.png"};
                                                                                                  //revisar //10                11
    int posiNumeros[] = {300,230, 335,290, 345,344, 325,400, 295,450, 250,459, 190,450, 130,400, 120,330, 120,270, 140,270,  165,220, 180,220, 230,210, 250,210};
    public void numeroReloj(Graphics g){
        
           int numAux = 0;
            for(int i = 0; i < 15; i++){
                Graphics cara = imgFondo.getGraphics();
           
            ImageIcon imagen = new ImageIcon(imagenes[i]);
            
            cara.drawImage(imagen.getImage(), posiNumeros[numAux], posiNumeros[numAux+1], pan);
            numAux +=2;
           
            g.drawImage(imgFondo, 0, 0, pan);
            //i++;
            
            }
            
            
    }
    /*
    public void diseñoDeAfueraReloj( Graphics g){
        
        // EcuacionRecta(90,300,330,300,0,150,g);
         //EcuacionRecta(140,150,140,400,0,90,g);
         
         //EcuacionRecta(90,300,330,300,0,550,g);
         //EcuacionRecta(140,150,140,400,0,420,g);
    }
*/
    
    
     private void elipse(int rx,int ry, int xc, int yc, Graphics a) {
        double theta = Math.toRadians(0);
        // Punto inicial
        int x = rx;
        int y = ry;
         Graphics cara = imgFondo.getGraphics();
        // Mientras el angulo no exceda a 360 dibujar puntos
        // System.out.println("Entro");
        while (theta <= 2*Math.PI) {
           
            //putPixel(x+xc, y+yc, Color.black);
            // Incrementar el ángulo
            theta=theta+Math.toRadians(.1);
            
            // Cálcular los valores x e y de forma parámetrica
            double xd = rx * Math.cos(theta);
            x = (int) Math.round(xd);
            double yd = ry * Math.sin(theta);
            y = (int) yd;
             cara.drawImage(buffer,x+xc, y+yc, pan);
            }
        
        a.drawImage(buffer, 0, 0, pan);
    
    }
    
}
