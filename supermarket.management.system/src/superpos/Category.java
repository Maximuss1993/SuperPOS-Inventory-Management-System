package superpos;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Category extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCat;
	private JTable categoryTable;
	
	Connection connection;
	PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category frame = new Category();
					frame.setVisible(true);
															
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public void table_update(){	//Method for updating table.
		int c;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/superpos", "eclipseSQL", "admin");
			
			pst = connection.prepareStatement("SELECT * FROM category");
			ResultSet rs = pst.executeQuery();
			
			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();
			
			DefaultTableModel d = (DefaultTableModel) categoryTable.getModel();
			
			d.setRowCount(0);
			
			while( rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("id"));
					v2.add(rs.getString("category"));
					v2.add(rs.getString("status"));
				}
				
				d.addRow(v2);
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}
	
	@SuppressWarnings("serial")
	public Category() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 667);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(100, 30));
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 623, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 180, SpringLayout.WEST, contentPane);
		panel.setAlignmentX(20.0f);
		panel.setBackground(SystemColor.textHighlight);
		panel.setMaximumSize(new Dimension(180, 32767));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel categoryField = new JLabel("Category");
		sl_panel.putConstraint(SpringLayout.NORTH, categoryField, 48, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, categoryField, 35, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, categoryField, -530, SpringLayout.SOUTH, panel);
		categoryField.setBounds(new Rectangle(10, 10, 10, 10));
		categoryField.setAlignmentY(Component.TOP_ALIGNMENT);
		categoryField.setFont(new Font("Tahoma", Font.BOLD, 18));
		categoryField.setPreferredSize(new Dimension(100, 30));
		categoryField.setMaximumSize(new Dimension(90, 40));
		categoryField.setMinimumSize(new Dimension(90, 30));
		categoryField.setForeground(SystemColor.text);
		panel.add(categoryField);
		
		JLabel brandField = new JLabel("Brand");
		sl_panel.putConstraint(SpringLayout.NORTH, brandField, 48, SpringLayout.SOUTH, categoryField);
		sl_panel.putConstraint(SpringLayout.WEST, brandField, 35, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, brandField, 176, SpringLayout.NORTH, panel);
		brandField.setBounds(new Rectangle(10, 10, 10, 10));
		brandField.setAlignmentY(Component.TOP_ALIGNMENT);
		brandField.setPreferredSize(new Dimension(100, 30));
		brandField.setMinimumSize(new Dimension(90, 30));
		brandField.setMaximumSize(new Dimension(90, 40));
		brandField.setForeground(SystemColor.text);
		brandField.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(brandField);
		
		JLabel Product = new JLabel("Product");
		sl_panel.putConstraint(SpringLayout.NORTH, Product, 48, SpringLayout.SOUTH, brandField);
		sl_panel.putConstraint(SpringLayout.WEST, Product, 35, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Product, 264, SpringLayout.NORTH, panel);
		Product.setBounds(new Rectangle(10, 10, 10, 10));
		Product.setAlignmentY(Component.TOP_ALIGNMENT);
		Product.setPreferredSize(new Dimension(100, 30));
		Product.setMinimumSize(new Dimension(90, 30));
		Product.setMaximumSize(new Dimension(90, 40));
		Product.setForeground(SystemColor.text);
		Product.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(Product);
		
		JLabel posField = new JLabel("Pos");
		sl_panel.putConstraint(SpringLayout.NORTH, posField, 48, SpringLayout.SOUTH, Product);
		sl_panel.putConstraint(SpringLayout.WEST, posField, 35, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, posField, -254, SpringLayout.SOUTH, panel);
		posField.setBounds(new Rectangle(10, 10, 10, 10));
		posField.setAlignmentY(Component.TOP_ALIGNMENT);
		posField.setPreferredSize(new Dimension(100, 30));
		posField.setMinimumSize(new Dimension(90, 30));
		posField.setMaximumSize(new Dimension(90, 40));
		posField.setForeground(SystemColor.text);
		posField.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(posField);
		
		JLabel exitField = new JLabel("Exit");
		sl_panel.putConstraint(SpringLayout.NORTH, exitField, 48, SpringLayout.SOUTH, posField);
		sl_panel.putConstraint(SpringLayout.WEST, exitField, 35, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, exitField, -154, SpringLayout.SOUTH, panel);
		exitField.setBounds(new Rectangle(10, 10, 10, 10));
		exitField.setAlignmentY(Component.TOP_ALIGNMENT);
		exitField.setPreferredSize(new Dimension(100, 30));
		exitField.setMinimumSize(new Dimension(90, 30));
		exitField.setMaximumSize(new Dimension(90, 40));
		exitField.setForeground(SystemColor.text);
		exitField.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(exitField);
		
		JLabel cashierField = new JLabel("Cashier");
		sl_panel.putConstraint(SpringLayout.NORTH, cashierField, 48, SpringLayout.SOUTH, exitField);
		sl_panel.putConstraint(SpringLayout.WEST, cashierField, 35, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, cashierField, 100, SpringLayout.SOUTH, exitField);
		cashierField.setBounds(new Rectangle(10, 10, 10, 10));
		cashierField.setAlignmentY(Component.TOP_ALIGNMENT);
		cashierField.setPreferredSize(new Dimension(100, 30));
		cashierField.setMinimumSize(new Dimension(90, 30));
		cashierField.setMaximumSize(new Dimension(90, 40));
		cashierField.setForeground(SystemColor.text);
		cashierField.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(cashierField);
		
		JLabel categoryLabel = new JLabel("Category");
		sl_contentPane.putConstraint(SpringLayout.NORTH, categoryLabel, 61, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, categoryLabel, 29, SpringLayout.EAST, panel);
		categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(categoryLabel);
		
		JLabel lblNewLabel = new JLabel("Super POS");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 244, SpringLayout.EAST, panel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 16, SpringLayout.SOUTH, categoryLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 13, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 318, SpringLayout.SOUTH, categoryLabel);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Category", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 42, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 4, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 87, SpringLayout.NORTH, panel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 20, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_2);
		
		txtCat = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtCat, 49, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, txtCat);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtCat, 94, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtCat, -28, SpringLayout.EAST, panel_1);
		panel_1.add(txtCat);
		txtCat.setColumns(10);
		
		JComboBox txtStatus = new JComboBox();
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtStatus, 114, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtCat, -34, SpringLayout.NORTH, txtStatus);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_2, -38, SpringLayout.WEST, txtStatus);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtStatus, 94, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtStatus, -28, SpringLayout.EAST, panel_1);
		txtStatus.setModel(new DefaultComboBoxModel(new String[] {"Active", "Deactive"}));
		panel_1.add(txtStatus);
		
		JButton btnAdd = new JButton("Add");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtStatus, -70, SpringLayout.NORTH, btnAdd);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -56, SpringLayout.NORTH, btnAdd);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnAdd, 215, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnAdd, 14, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnAdd, -35, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnAdd, -206, SpringLayout.EAST, panel_1);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String category = txtCat.getText();
				String status = txtStatus.getSelectedItem().toString();
			
				// connecting to database
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost/superpos", "eclipseSQL", "admin");
					pst = connection.prepareStatement("INSERT INTO category (category, status) VALUES (?, ?)");
					pst.setString(1, category);
					pst.setString(2, status);
					pst.executeUpdate();
					table_update();
					JOptionPane.showMessageDialog(null, "Category added!");
					txtCat.setText("");
					txtStatus.setSelectedIndex(-1);
					txtCat.requestFocus();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(btnAdd);
		
		JButton btnEdit = new JButton("Update");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnEdit, 215, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnEdit, 14, SpringLayout.EAST, btnAdd);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnEdit, -35, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnEdit, -111, SpringLayout.EAST, panel_1);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel d1 = (DefaultTableModel) categoryTable.getModel();
				int selectIndex = categoryTable.getSelectedRow();
				
				//getting id from selected row
				int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());  
				
				//getting category and status from selected row in table
				String category = txtCat.getText();
				String status = txtStatus.getSelectedItem().toString();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost/superpos", "eclipseSQL", "admin");
					pst = connection.prepareStatement("UPDATE category SET category=?, status=? WHERE id=?");
					pst.setString(1, category);
					pst.setString(2, status);
					pst.setInt(3, id);
					pst.executeUpdate();
					table_update();
					JOptionPane.showMessageDialog(null, "Category updated!");
					txtCat.setText("");
					txtStatus.setSelectedIndex(-1);
					txtCat.requestFocus();
				
								
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		
		});
		panel_1.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnDelete, 215, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnDelete, 14, SpringLayout.EAST, btnEdit);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnDelete, -35, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnDelete, -16, SpringLayout.EAST, panel_1);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(btnDelete);
		
		categoryTable = new JTable();
		categoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel d1 = (DefaultTableModel) categoryTable.getModel();
				int selectIndex = categoryTable.getSelectedRow();
				
				txtCat.setText(d1.getValueAt(selectIndex, 1).toString());
				txtStatus.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -24, SpringLayout.WEST, categoryTable);
		sl_contentPane.putConstraint(SpringLayout.NORTH, categoryTable, -1, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, categoryTable, 530, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, categoryTable, -94, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, categoryTable, -10, SpringLayout.EAST, contentPane);
		categoryTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		categoryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Category", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		categoryTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		categoryTable.getColumnModel().getColumn(1).setPreferredWidth(223);
		categoryTable.getColumnModel().getColumn(2).setPreferredWidth(180);
		categoryTable.setCellSelectionEnabled(true);
		categoryTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(categoryTable);
		
		table_update();
	}
}

