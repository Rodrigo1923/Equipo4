/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Imagenes extends JFrame implements ActionListener{
    
    JButton prev, next;
    JLabel image;
    ImageIcon icono;
    int cont = 1;
    
    public Imagenes(){
        super("Imagenes");
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
        long num = num();
        if(ae.getSource() == next){
            if(cont>=num){
                cont = 1;
            }else{
                cont++;
            }
        }
        
        if(ae.getSource() == prev){
            if(cont<=1){
                cont = (int)num;
            }else{
                cont--;
            }
        }
        
        icono = new ImageIcon("src/Img/"+cont+".jpg");
        image.setIcon(icono);
        
    }
    
    public long num(){
        Path carpeta = Paths.get("src/Img");
        long cantidadArchivos = -1;
        if (Files.isDirectory(carpeta)) {
            try {
                 cantidadArchivos = Files.walk(carpeta, 1)
                    .filter(p -> !p.equals(carpeta))
                    .count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cantidadArchivos;
        } else {
            return -1;
        }
    }
    
}
