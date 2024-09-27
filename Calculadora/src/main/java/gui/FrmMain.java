
package gui;

import Utileria.Fecha;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FrmMain extends JFrame implements ActionListener, KeyListener{
    private JTextField pantalla;
    private JButton bbhSalir, btnSalir, btnCCol1, btnCECol1,btnModCol1,btnMultCol1,btn7Col2, btn8Col2,btn9Col2,btnDivCol2,btn4Col3, btn5Col3,btn6Col3,btnRestaCol3,btn1Col4, btn2Col4,btn3Col4,btnSumaCol4,btnSignoCol5, btn0Col5,btnPuntoCol5,btnIgualCol5;
    private JPanel panel;
    private String num1 = "", num2 = "", operador = "";
    private boolean estaOperando = false;
    private Timer tiempo;
    private JLabel lblHora;

    public FrmMain()
    {
         setTitle("Calculadora");
        setIconImage(new ImageIcon("src/imagenes/Calculadoraicon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(342,450);
        //quitamos que se pueda abrir en ventana completa
        setResizable(false);        
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        InitComponents(); 
    }
     private void InitComponents()
    {
         //configuramos la pantalla de la calculadora
        pantalla = new JTextField();
        pantalla.setPreferredSize(new Dimension(100,110));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(true);
        pantalla.addKeyListener(this);
        add(pantalla, BorderLayout.NORTH);
       
        //Configuraremos los botones
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        //Primera Columna
        btnCCol1= new JButton("C");
        btnCCol1.setBounds(8, 10, 74, 48);
        btnCCol1.addActionListener(this);
        panel.add(btnCCol1);
        
        btnCECol1= new JButton("CE");
        btnCECol1.setBounds(87, 10, 74, 48);
        btnCECol1.addActionListener(this);
        panel.add(btnCECol1);
        
        btnModCol1= new JButton("Mod");
        btnModCol1.setBounds(166, 10, 74, 48);
        btnModCol1.addActionListener(this);
        panel.add(btnModCol1);
        
        btnMultCol1= new JButton("*");
        btnMultCol1.setBounds(245, 10, 74, 48);
        btnMultCol1.addActionListener(this);
        panel.add(btnMultCol1);
        
        //Segunda Columna
        
        btn7Col2= new JButton("7");
        btn7Col2.setBounds(8, 64, 74, 48);
        btn7Col2.addActionListener(this);
        panel.add(btn7Col2);
        
        btn8Col2= new JButton("8");
        btn8Col2.setBounds(87, 64, 74, 48);
        btn8Col2.addActionListener(this);
        panel.add(btn8Col2);
        
        btn9Col2= new JButton("9");
        btn9Col2.setBounds(166, 64, 74, 48);
        btn9Col2.addActionListener(this);
        panel.add(btn9Col2);
        
        btnDivCol2= new JButton("/");
        btnDivCol2.setBounds(245, 64, 74, 48);
        btnDivCol2.addActionListener(this);
        panel.add(btnDivCol2);
        
        //Tercera Columna
        
        btn4Col3= new JButton("4");
        btn4Col3.setBounds(8, 118, 74, 48);
        btn4Col3.addActionListener(this);
        panel.add(btn4Col3);
        
        btn5Col3= new JButton("5");
        btn5Col3.setBounds(87, 118, 74, 48);
        btn5Col3.addActionListener(this);
        panel.add(btn5Col3);
        
        btn6Col3= new JButton("6");
        btn6Col3.setBounds(166, 118, 74, 48);
        btn6Col3.addActionListener(this);
        panel.add(btn6Col3);
        
        btnRestaCol3= new JButton("-");
        btnRestaCol3.setBounds(245, 118, 74, 48);
        btnRestaCol3.addActionListener(this);
        panel.add(btnRestaCol3);
        //Cuarta Columna
        btn1Col4= new JButton("1");
        btn1Col4.setBounds(8, 172, 74, 48);
        btn1Col4.addActionListener(this);
        panel.add(btn1Col4);
        
        btn2Col4= new JButton("2");
        btn2Col4.setBounds(87, 172, 74, 48);
        btn2Col4.addActionListener(this);
        panel.add(btn2Col4);
        
        btn3Col4= new JButton("3");
        btn3Col4.setBounds(166, 172, 74, 48);
        btn3Col4.addActionListener(this);
        panel.add(btn3Col4);
        
        btnSumaCol4= new JButton("+");
        btnSumaCol4.setBounds(245, 172, 74, 48);
        btnSumaCol4.addActionListener(this);
        panel.add(btnSumaCol4);
        //Quinta Columna
        btnSignoCol5= new JButton("+/-");
        btnSignoCol5.setBounds(8, 226, 74, 48);
        btnSignoCol5.addActionListener(this);
        panel.add(btnSignoCol5);
        
        btn0Col5= new JButton("0");
        btn0Col5.setBounds(87, 226, 74, 48);
        btn0Col5.addActionListener(this);
        panel.add(btn0Col5);
        
        btnPuntoCol5= new JButton(".");
        btnPuntoCol5.setBounds(166, 226, 74, 48);
        btnPuntoCol5.addActionListener(this);
        panel.add(btnPuntoCol5);
        
        btnIgualCol5= new JButton("=");
        btnIgualCol5.setBounds(245, 226, 74, 48);
        btnIgualCol5.addActionListener(this);
        panel.add(btnIgualCol5);
        
        lblHora=new JLabel("");
        add(lblHora, BorderLayout.SOUTH);

        tiempo=new Timer(1000, (ActionEvent arg0) -> {
            ActualizaStatusFecha();
        });
        tiempo.start();
        
    }
     
     private void ActualizaStatusFecha()
    {
        lblHora.setText(Fecha.now());
    }
     
     public void actionPerformed(ActionEvent event) 
    {
        String accion = event.getActionCommand();
        entrada(accion);
    }

    public void keyPressed(KeyEvent event) 
    {
        char keyChar = event.getKeyChar();
        if (Character.isDigit(keyChar)) 
        {
            entrada(String.valueOf(keyChar));
        } 
        else if (keyChar == '.') 
        {
            entrada(".");
        } 
        else if (keyChar == '+') 
        {
            entrada("+");
        } 
        else if (keyChar == '-') 
        {
            entrada("-");
        } 
        else if (keyChar == '*') 
        {
            entrada("*");
        } 
        else if (keyChar == '/') 
        {
            entrada("/");
        } 
        else if (keyChar == '%') 
        {
            entrada("mod");
        } 
        else if (keyChar == KeyEvent.VK_ENTER) 
        {
            entrada("=");
        } 
        else if (keyChar == KeyEvent.VK_ESCAPE) 
        {
            entrada("C");
        }
    }
    public void keyReleased(KeyEvent event)
    {

    }
    public void keyTyped(KeyEvent event) 
    {
        
    }
    private void entrada(String dato) 
    {
        //Si dato es un dígito (0 a 9) o es igual a un punto...
        if (dato.matches("\\d") || dato.equals(".")) 
        {
            if (!estaOperando) 
            {
                num1 += dato;
                pantalla.setText(num1);
            } 
            else 
            {
                num2 += dato;
                pantalla.setText(num2);
            }
        }
        //Si el dato es +, -, *, /, ó mod....
        else if (dato.matches("[\\+\\-\\*/]|mod")) 
        {
            operador = dato;
            estaOperando = true;
        }
        else if (dato.equals("+/-")) 
        {
            if (!estaOperando) 
            {
                num1 = cambiarSigno(num1);
                pantalla.setText(num1);
            } 
            else 
            {
                num2 = cambiarSigno(num2);
                pantalla.setText(num2);
            }
        }
        else if (dato.equals("=")) 
        {
            //verificacion si se divide entre 0 
            try 
            {
                double resultado = operacion();
                if (Double.isNaN(resultado)) 
                {
                    pantalla.setText("Error: No se puede dividir entre 0");
                    bloquearBotones(); // Bloquear todos los botones excepto C
                } 
                else if (Double.isInfinite(resultado)) 
                {
                    pantalla.setText("Error: No se puede dividir entre 0");
                    bloquearBotones(); // Bloquear todos los botones excepto C
                } 
                else
                {
                    pantalla.setText(String.valueOf(resultado));
                    num1 = String.valueOf(resultado);
                    num2 = "";
                    estaOperando = false;
                }
            } 
            catch (Exception ex) 
            {
                pantalla.setText("Error: No hay valores a calcular.");
            }
        }
        else if (dato.equals("C")) 
        {
            num1 = "";
            num2 = "";
            estaOperando = false;
            operador = "";
            pantalla.setText("");
            habilitarBotones(); // Volver a habilitar los botones
        }
        else if (dato.equals("CE")) 
        {
            if (!estaOperando) 
            {
                if (!num1.isEmpty()) 
                {
                    num1 = num1.substring(0, num1.length() - 1);
                    pantalla.setText(num1);
                }
            } 
            else 
            {
                if (!num2.isEmpty()) 
                {
                    num2 = num2.substring(0, num2.length() - 1);
                    pantalla.setText(num2);
                }
            }
        }
    }
    private double operacion() 
    {
        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        if (operador.equals("+")) 
        {
            return n1 + n2;
        } 
        else if (operador.equals("-")) 
        {
            return n1 - n2;
        }
        else if (operador.equals("*")) 
        {
            return n1 * n2;
        }
        else if (operador.equals("/")) 
        { 
            
            return n1 / n2;
        }
        else if (operador.equals("mod")) 
        {
            return n1 % n2;
        }
        else
        {
            return 0;
        }

    }
    private String cambiarSigno(String num) 
    {
        if (num.startsWith("-"))         
        {
            return num.substring(1);
        } 
        else 
        {
            return "-" + num;
        }
    }
    
    // Método para bloquear los botones, excepto "C"
private void bloquearBotones() 
{
    for (JButton boton : new JButton[]{btnCECol1, btnModCol1, btnMultCol1, btn7Col2, btn8Col2, btn9Col2, btnDivCol2, 
            btn4Col3, btn5Col3, btn6Col3, btnRestaCol3, btn1Col4, btn2Col4, btn3Col4, btnSumaCol4, 
            btnSignoCol5, btn0Col5, btnPuntoCol5, btnIgualCol5}) 
    {
        boton.setEnabled(false);
    }
}

// Método para habilitar todos los botones
private void habilitarBotones() 
{
    for (JButton boton : new JButton[]{btnCECol1, btnModCol1, btnMultCol1, btn7Col2, btn8Col2, btn9Col2, btnDivCol2, 
            btn4Col3, btn5Col3, btn6Col3, btnRestaCol3, btn1Col4, btn2Col4, btn3Col4, btnSumaCol4, 
            btnSignoCol5, btn0Col5, btnPuntoCol5, btnIgualCol5}) 
    {
        boton.setEnabled(true);
    }
}


    }