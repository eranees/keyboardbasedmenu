
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements KeyListener {

  private static final long serialVersionUID = 1L;
  private JLabel[] menuItems;
  private int currentItem;

  public Menu() {
    setTitle("Menu");
    setSize(400, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    addKeyListener(this);

    menuItems = new JLabel[3];
    menuItems[0] = new JLabel("Home");
    menuItems[1] = new JLabel("Contact");
    menuItems[2] = new JLabel("About");

    for (int i = 0; i < menuItems.length; i++) {
      menuItems[i].setOpaque(true);
      menuItems[i].setBackground(i == 0 ? java.awt.Color.MAGENTA : java.awt.Color.GREEN);
      menuItems[i].setForeground(java.awt.Color.WHITE);
      menuItems[i].setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLUE));
      menuItems[i].setHorizontalAlignment(JLabel.CENTER);
      add(menuItems[i]);
    }

    setVisible(true);
    currentItem = 0;
  }

  public static void main(String[] args) {
    new Menu();
  }

  private void selectItem(int item) {
    menuItems[currentItem].setBackground(java.awt.Color.GREEN);
    menuItems[currentItem].setForeground(java.awt.Color.BLACK);
    currentItem = item;
    menuItems[currentItem].setBackground(java.awt.Color.MAGENTA);
    menuItems[currentItem].setForeground(java.awt.Color.WHITE);
  }

  private void playSound() {
    try {
      javax.sound.sampled.AudioFormat format = new javax.sound.sampled.AudioFormat(44100, 8, 1, true, false);
      javax.sound.sampled.SourceDataLine line = javax.sound.sampled.AudioSystem.getSourceDataLine(format);
      line.open(format, 4410);
      line.start();
      byte[] buffer = new byte[4410];
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < buffer.length; j++) {
          double angle = i / (44100.0 / 432) * 2.0 * Math.PI;
          buffer[j] = (byte) (Math.sin(angle) * 127);
        }
        line.write(buffer, 0, buffer.length);
      }
      line.stop();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private void launchUrl(String url) {
    try {
      java.awt.Desktop.getDesktop().browse(new URI(url));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_RIGHT) {
      selectItem((currentItem + 1) % menuItems.length);
      playSound();
    } else if (keyCode == KeyEvent.VK_LEFT) {
      selectItem((currentItem + menuItems.length - 1) % menuItems.length);
      playSound();
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }
}