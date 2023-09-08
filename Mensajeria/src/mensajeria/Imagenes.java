/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Imagenes extends JFrame implements ActionListener{
    
    JButton prev, next;
    JLabel image;
    ImageIcon icono;
    int cont = 1;
    int max;
    
    public Imagenes(int ma){
        super("Imagenes");
        max = ma;
        setLayout(null);
        
        prev = new JButton("<");
        prev.setBounds(10, 135, 60, 30);
        prev.addActionListener(this);
        
        image = new JLabel();
        icono = new ImageIcon("src/Img/1.jpg");
        image.setIcon(icono);
        image.setBounds(80, 50, 200, 200);
        
        next = new JButton(">");
        next.setBounds(290, 135, 60, 30);
        next.addActionListener(this);
        
        add(image);
        add(next);
        add(prev);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == next){
            if(cont>=max){
                cont = 1;
            }else{
                cont++;
            }
        }
        
        icono = new ImageIcon("src/Img/"+cont+".jpg");
        image.setIcon(icono);
        
    }
    
    
    
}
