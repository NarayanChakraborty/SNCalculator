import javax.swing.JFrame;
import javax.swing.UIManager;
public class MainClass {

	public static void main(String args[])
	{
		try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());                

            } catch (Exception e) {
              System.err.println("Look and feel not set.");
            }
		Myclass apu=new Myclass();
		apu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		apu.setSize(255,270);
		apu.setResizable(false);
		apu.setVisible(true);
	}
}
