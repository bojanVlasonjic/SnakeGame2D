package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import io.TopFiveHighScores;
import model.HighScore;

@SuppressWarnings("serial")
public class HighScoreScreen extends JFrame {
	
	private SimpleDateFormat sdf;
	private TopFiveHighScores scores;
	private JPanel scorePanel;
	
	
	public HighScoreScreen() {
		
		this.sdf = new SimpleDateFormat("dd.MM.yyyy. hh:mm a");
		this.scores = TopFiveHighScores.getInstance();
		
		this.setTitle("High scores");
		this.setSize(600, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.scorePanel = new JPanel(new BorderLayout());
		this.scorePanel.setBackground(GameScreen.backgroundColor);
		initTable();
		this.add(scorePanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}
	
	private void initTable() {
		
		JTable scoreTable = new JTable();
		scoreTable.setEnabled(false);
		
		// styling table
		scoreTable.setBackground(GameScreen.backgroundColor);
		scoreTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scoreTable.setForeground(Color.WHITE);
		
		DefaultTableModel model = new DefaultTableModel(0, 0);
		String[] columns = new String[]{"Name", "Score", "Date", "Difficulty"};
		model.setColumnIdentifiers(columns);
		
		for(HighScore hs: this.scores.getHighScores()) {
			model.addRow(new Object[] {
					hs.getUserName(), hs.getScore(), sdf.format(hs.getDate()), hs.getDifficulty()
			});
		}
		
		scoreTable.setModel(model);
		
		// styling and inserting table header
		scoreTable.getTableHeader().setBackground(GameScreen.backgroundColor);
		scoreTable.getTableHeader().setForeground(Color.WHITE);
		this.scorePanel.add(scoreTable.getTableHeader(), BorderLayout.NORTH);
		
		this.scorePanel.add(scoreTable);
	}

}
