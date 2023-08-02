
package modelo;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class punto2D extends JFrame implements MouseListener {

    private File file;
    private BufferedWriter writer;
    private JLabel coordinatesLabel;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    public punto2D() {
        super("Mouse Coordinates Logger");
        addMouseListener(this);

        coordinatesLabel = new JLabel("Coordenadas: ");
        add(coordinatesLabel);

        try {
            file = new File("COORDENADAS.txt");
            writer = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        String coordinates = "X: " + x + ", Y: " + y;

        try {
            writer.write(coordinates);
            writer.newLine();
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        coordinatesLabel.setText("Coordenadas: " + coordinates);
    }

    // Implementar los demás métodos de la interfaz MouseListener
    // aunque no se utilizan en este ejemplo

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new punto2D());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public String toString() {
        return "punto2D{" + "file=" + file + ", writer=" + writer + ", coordinatesLabel=" + coordinatesLabel + '}';
    }
    
}





