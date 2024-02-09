import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Stack;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Insets;

@SuppressWarnings("serial")
public class StacksClass extends JFrame {
	public int i= 0;
	public int k= 1;
	private JPanel contentPane;
	private JTextArea txtAnime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StacksClass frame = new StacksClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static Stack<String> StackList() {
		Stack<String> anime = new Stack<String>();

		anime.add("Naruto Uzumaki");
		anime.add("Monkey D. Luffy");
		anime.add("Issei Hyoudou");
		anime.add("Eren Yeager");
		anime.add("Sasuke Uchicha");
		
		return anime;
	}
	/**
	 * Create the frame.
	 */
	public StacksClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 136, 73));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnAnime = new JButton("Character 0/" + StackList().size());
		btnAnime.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAnime.setBackground(Color.cyan);
				btnAnime.setForeground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAnime.setBackground(Color.white);
				btnAnime.setForeground(Color.black);

			}
		});

		btnAnime.setBackground(new Color(255, 255, 255));
		btnAnime.setFont(new Font("Source Code Pro", Font.PLAIN, 17));
		btnAnime.setBounds(155, 361, 175, 49);
		btnAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i < StackList().size()) {
					txtAnime.append("\n" + StackList().get(i++) + "\n");
					btnAnime.setText("Character "  + (k++) + "/" + StackList().size());
				} else {
					btnAnime.setBackground(Color.green);
					btnAnime.setForeground(Color.black);
					btnAnime.setText("Completed");
					JOptionPane.showMessageDialog(null, "Program Finished", "Notice", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAnime);

		txtAnime = new JTextArea();
		txtAnime.setFocusable(false);
		txtAnime.setEditable(false);
		txtAnime.setForeground(new Color(0, 0, 0));
		txtAnime.setMargin(new Insets(2, 125, 2, 2));
		txtAnime.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtAnime.setFont(new Font("Source Code Pro", Font.PLAIN, 17));
		txtAnime.setBounds(46, 64, 394, 245);
		contentPane.add(txtAnime);

		JLabel lblAnime = new JLabel("Anime Lists");
		lblAnime.setForeground(Color.WHITE);
		lblAnime.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnime.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		lblAnime.setBounds(46, 11, 394, 54);
		contentPane.add(lblAnime);
		
		JLabel lblNaruto = new JLabel("");
		lblNaruto.setHorizontalAlignment(SwingConstants.CENTER);
		Image img_naruto = new ImageIcon(this.getClass().getResource("/naruto.png")).getImage().getScaledInstance(210, 130, Image.SCALE_DEFAULT);
		lblNaruto.setIcon(new ImageIcon(img_naruto));
		lblNaruto.setBounds(338, 322, 138, 148);
		contentPane.add(lblNaruto);
		
		JLabel lblItachi = new JLabel("");
		lblItachi.setHorizontalAlignment(SwingConstants.CENTER);
		Image img_itachi = new ImageIcon(this.getClass().getResource("/itachi.jpg")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT);
		lblItachi.setIcon(new ImageIcon(img_itachi));
		lblItachi.setBounds(10, 333, 129, 130);
		contentPane.add(lblItachi);
	}
}