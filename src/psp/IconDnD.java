
package psp;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

/**
 *
 * @author merce
 */
public class IconDnD {
  public static void main(String[] args) {
    JFrame f = new JFrame("Icon Drag & Drop");
    ImageIcon icon1 = new ImageIcon("src/psp/assets/pokeball.png");
    ImageIcon icon2 = new ImageIcon("src/psp/assets/front_duskull.png");
    ImageIcon icon3 = new ImageIcon("src/psp/assets/pokeball.jpg");

    JButton button1 = new JButton(icon2);
    JButton button2 = new JButton(icon1);
    JButton button3 = new JButton(icon3);

    

    MouseListener listener = new DragMouseAdapter();
    button1.addMouseListener(listener);
    button2.addMouseListener(listener);
    button3.addMouseListener(listener);

    button1.setTransferHandler(new TransferHandler("icon"));
    button2.setTransferHandler(new TransferHandler("icon"));
    button3.setTransferHandler(new TransferHandler("icon"));

    f.setLayout(new FlowLayout());
    f.add(button3);
    f.add(button1);
    f.add(button2);
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.setVisible(true);
  }
}
