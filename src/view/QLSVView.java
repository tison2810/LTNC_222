package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.Faculty;
import model.QLSVSystem;
import model.Student;
import controller.QLSVController;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVSystem system;
	public JTable table;
	public JTextField textField;
	public JTextField textField_Name;
	public JTextField textField_Birth;
	public JTextField textField_MSSV;
	public JTextField textField_TCTL;
	public JTextField textField_GPA4;
	public JTextField textField_GPA10;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_Khoa_info;
	public JRadioButton RadioButton_Nam;
	public JRadioButton RadioButton_Nu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.system = new QLSVSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 699);
		
		Action action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuFile.add(menuOpen);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuFile.add(menuClose);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuAbout);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About Me");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuAbout.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(415, 11, 210, 38);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"H\u1ECD v\u00E0 t\u00EAn", "Khoa", "MSSV", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "T\u00EDn ch\u1EC9 t\u00EDch l\u0169y", "GPA(h\u1EC7 4)", "GPA (h\u1EC7 10)"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(47, 53, 935, 187);
		contentPane.add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 251, 952, 21);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("KHOA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 265, 94, 28);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_Khoa_find = new JComboBox();
		comboBox_Khoa_find.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ArrayList<Faculty> facultyList = Faculty.getFacultyList();
		comboBox_Khoa_find.addItem("");
		for (Faculty faculty : facultyList) {
			comboBox_Khoa_find.addItem(faculty.getTenKhoa());
		}
		comboBox_Khoa_find.setBounds(156, 265, 274, 28);
		contentPane.add(comboBox_Khoa_find);
		
		JLabel lblNewLabel_2 = new JLabel("MSSV");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(555, 265, 70, 28);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(622, 265, 215, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin sinh viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(46, 301, 162, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Họ và tên");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(57, 334, 113, 21);
		contentPane.add(lblNewLabel_4);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(156, 328, 274, 38);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ngày sinh");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(538, 334, 113, 21);
		contentPane.add(lblNewLabel_4_1);
		
		textField_Birth = new JTextField();
		textField_Birth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Birth.setColumns(10);
		textField_Birth.setBounds(650, 328, 274, 38);
		contentPane.add(textField_Birth);
		
		JLabel lblNewLabel_4_2 = new JLabel("MSSV");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2.setBounds(57, 382, 113, 21);
		contentPane.add(lblNewLabel_4_2);
		
		textField_MSSV = new JTextField();
		textField_MSSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MSSV.setColumns(10);
		textField_MSSV.setBounds(156, 376, 274, 38);
		contentPane.add(textField_MSSV);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Giới tính");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_1.setBounds(538, 382, 113, 21);
		contentPane.add(lblNewLabel_4_2_1);
		
		RadioButton_Nam = new JRadioButton("Nam");
		RadioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RadioButton_Nam.setBounds(650, 376, 111, 32);
		contentPane.add(RadioButton_Nam);
		
		RadioButton_Nu = new JRadioButton("Nữ");
		RadioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RadioButton_Nu.setBounds(759, 376, 111, 32);
		contentPane.add(RadioButton_Nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(RadioButton_Nam);
		btn_gioiTinh.add(RadioButton_Nu);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Khoa");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2.setBounds(57, 432, 113, 21);
		contentPane.add(lblNewLabel_4_2_2);
		
		comboBox_Khoa_info = new JComboBox();
		comboBox_Khoa_info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_Khoa_info.addItem("");
		for (Faculty faculty : facultyList) {
			comboBox_Khoa_info.addItem(faculty.getTenKhoa());
		}
		comboBox_Khoa_info.setBounds(156, 426, 274, 38);
		contentPane.add(comboBox_Khoa_info);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("Tín chỉ TL");
		lblNewLabel_4_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2_1.setBounds(538, 432, 128, 21);
		contentPane.add(lblNewLabel_4_2_2_1);
		
		textField_TCTL = new JTextField();
		textField_TCTL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TCTL.setColumns(10);
		textField_TCTL.setBounds(650, 426, 274, 38);
		contentPane.add(textField_TCTL);
		
		JLabel lblNewLabel_4_2_2_2 = new JLabel("GPA(hệ 4)");
		lblNewLabel_4_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2_2.setBounds(57, 481, 113, 21);
		contentPane.add(lblNewLabel_4_2_2_2);
		
		textField_GPA4 = new JTextField();
		textField_GPA4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_GPA4.setColumns(10);
		textField_GPA4.setBounds(156, 475, 274, 38);
		contentPane.add(textField_GPA4);
		
		JLabel lblNewLabel_4_2_2_2_1 = new JLabel("GPA(hệ 10)");
		lblNewLabel_4_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2_2_1.setBounds(538, 481, 113, 21);
		contentPane.add(lblNewLabel_4_2_2_2_1);
		
		textField_GPA10 = new JTextField();
		textField_GPA10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_GPA10.setColumns(10);
		textField_GPA10.setBounds(650, 475, 274, 38);
		contentPane.add(textField_GPA10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(855, 262, 79, 38);
		contentPane.add(btnNewButton);
		
		JButton btnInsert = new JButton("Thêm");
		btnInsert.addActionListener(action);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsert.setBounds(47, 559, 123, 44);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(action);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(218, 559, 123, 44);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(401, 559, 123, 44);
		contentPane.add(btnDelete);
		
		JButton btnStored = new JButton("Lưu");
		btnStored.addActionListener(action);
		btnStored.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStored.setBounds(595, 559, 123, 44);
		contentPane.add(btnStored);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(action);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(779, 559, 123, 44);
		contentPane.add(btnCancel);
		
		
		this.setVisible(true);
		
	}
	
	public void deleteForm() {
		textField_Name.setText("");
		textField_Birth.setText("");
		textField_MSSV.setText("");
		textField_TCTL.setText("");
		textField_GPA4.setText("");
		textField_GPA10.setText("");
		comboBox_Khoa_info.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	
	public void insert(Student sinhvien) {
		this.system.insert(sinhvien);
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {sinhvien.getHoTen(), sinhvien.getKhoa().getTenKhoa(), 
									sinhvien.getMSSV()+"", (sinhvien.getNgaySinh().getMonth()+1)+"/"+(sinhvien.getNgaySinh().getDate())+"/"+(sinhvien.getNgaySinh().getYear()+1900),
									(sinhvien.isGioiTinh()?"Nam":"Nữ"),sinhvien.getTCTL()+"",
									sinhvien.getGpa_4()+"",sinhvien.getGpa_10()+""});
	}
	
	public void display() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String hoTen = tableModel.getValueAt(row, 0)+"";
		String MSSV = tableModel.getValueAt(row, 2)+"";
		Faculty Khoa = Faculty.getFacultybyName(tableModel.getValueAt(row, 1)+"");
		String ngaySinh_s = tableModel.getValueAt(row, 3)+"";
		Date ngaySinh = new Date(ngaySinh_s);
		String chon_gioiTinh = tableModel.getValueAt(row, 4)+ "";
		boolean gioiTinh = chon_gioiTinh.equals("Nam");
		int TCTL = Integer.valueOf(tableModel.getValueAt(row, 5)+"");
		float gpa_10 = Float.valueOf(tableModel.getValueAt(row, 7)+"");
		float gpa_4 = Float.valueOf(tableModel.getValueAt(row, 6)+"");
		
		this.textField_MSSV.setText(MSSV+"");
		this.textField_Name.setText(hoTen+"");
		this.comboBox_Khoa_info.setSelectedItem(Khoa.getTenKhoa());
		this.textField_Birth.setText(ngaySinh_s+"");
		this.textField_TCTL.setText(TCTL+"");
		this.textField_GPA10.setText(gpa_10+"");
		this.textField_GPA4.setText(gpa_4+"");
		
		if(gioiTinh) {
			RadioButton_Nam.setSelected(true);
		}
		else
			RadioButton_Nu.setSelected(true);
	}

	public void update(Student sinhvien) {
		this.system.update(sinhvien);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		
		tableModel.setValueAt(sinhvien.getHoTen(), row, 0);
		tableModel.setValueAt(sinhvien.getKhoa().getTenKhoa(), row, 1);
		tableModel.setValueAt(sinhvien.getMSSV(), row, 2);
		tableModel.setValueAt((sinhvien.getNgaySinh().getMonth()+1) + "/" + (sinhvien.getNgaySinh().getDate()) + "/"
				+ (sinhvien.getNgaySinh().getYear() + 1900) + "", row, 3);
		tableModel.setValueAt((sinhvien.isGioiTinh()?"Nam":"Nữ"), row, 4);
		tableModel.setValueAt(sinhvien.getTCTL(), row, 5);
		tableModel.setValueAt(sinhvien.getGpa_4(), row, 6);
		tableModel.setValueAt(sinhvien.getGpa_10(), row, 7);
	}

	public Student getStudent() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		
		String hoTen = tableModel.getValueAt(row, 0)+"";
		String MSSV = tableModel.getValueAt(row, 2)+"";
		Faculty Khoa = Faculty.getFacultybyName(tableModel.getValueAt(row, 1)+"");
		String ngaySinh_s = tableModel.getValueAt(row, 3)+"";
		Date ngaySinh = new Date(ngaySinh_s);
		String chon_gioiTinh = tableModel.getValueAt(row, 4)+ "";
		boolean gioiTinh = chon_gioiTinh.equals("Nam");
		int TCTL = Integer.valueOf(tableModel.getValueAt(row, 5)+"");
		float gpa_10 = Float.valueOf(tableModel.getValueAt(row, 7)+"");
		float gpa_4 = Float.valueOf(tableModel.getValueAt(row, 6)+"");
		
		Student sinhvien = new Student(hoTen, MSSV, Khoa, ngaySinh, gioiTinh, TCTL, gpa_10, gpa_4);
		return sinhvien;
	}
	
	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int select = JOptionPane.showConfirmDialog(this, "Bạn xác nhận muốn xóa dòng đang chọn?");
		if(select == JOptionPane.YES_OPTION) {
			Student sinhvien = getStudent();
			this.system.delete(sinhvien);
			tableModel.removeRow(row);
		}
	}
	

}