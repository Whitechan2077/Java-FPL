package poly.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import poly.model.Employee;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

public class QuanLyNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtTuoi;
	private JTextField txtEmail;
	private JTextField txtLuong;
	private JButton btnFind;
	private JTable tbl;
	private JLabel lblClock;
	private JLabel lblStatus;
	private JLabel lblHinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhanVien frame = new QuanLyNhanVien();
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
	public QuanLyNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 507);
		setTitle("QUẢN LÝ NHÂN VIÊN");
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuanLyNhanVien.class.getResource("/poly/icons/fpt.png")));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 153, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setBounds(186, 43, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setBackground(new Color(255, 255, 255));
		txtMaNV.setBounds(275, 40, 92, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(275, 68, 190, 20);
		contentPane.add(txtHoTen);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setBounds(186, 71, 79, 14);
		contentPane.add(lblHTn);
		
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(275, 99, 92, 20);
		contentPane.add(txtTuoi);
		
		JLabel lblTui = new JLabel("Tuổi");
		lblTui.setBounds(186, 102, 79, 14);
		contentPane.add(lblTui);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(275, 130, 190, 20);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(186, 133, 79, 14);
		contentPane.add(lblEmail);
		
		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(275, 161, 92, 20);
		contentPane.add(txtLuong);
		
		JLabel lblLng = new JLabel("Lương");
		lblLng.setBounds(186, 164, 79, 14);
		contentPane.add(lblLng);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClock.setForeground(Color.RED);
		lblClock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClock.setBounds(483, 11, 119, 21);
		contentPane.add(lblClock);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(483, 32, 119, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNew = new JButton("New");
		btnNew.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Create.png")));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNew.setBounds(10, 11, 99, 26);
		panel.add(btnNew);
		
		JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Save.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(10, 48, 99, 26);
		panel.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Delete.png")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEmp();
			}
		});
		btnDelete.setBounds(10, 85, 99, 26);
		panel.add(btnDelete);
		
		btnFind = new JButton("Find");
		btnFind.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Search.png")));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		btnFind.setBounds(10, 122, 99, 26);
		panel.add(btnFind);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Open file.png")));
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		btnOpen.setBounds(10, 159, 99, 26);
		panel.add(btnOpen);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Log out.png")));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setBounds(10, 196, 99, 26);
		panel.add(btnExit);
		
		JButton btnLast = new JButton("");
		btnLast.setBackground(Color.PINK);
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/First.png")));
		btnLast.setBounds(10, 214, 69, 27);
		contentPane.add(btnLast);
		
		JButton btnPre = new JButton("");
		btnPre.setBackground(Color.PINK);
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pre();
			}
		});
		btnPre.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Left.png")));
		btnPre.setBounds(89, 214, 69, 27);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("");
		btnNext.setBackground(Color.PINK);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Right.png")));
		btnNext.setBounds(167, 214, 69, 27);
		contentPane.add(btnNext);
		
		JButton btnFirst = new JButton("");
		btnFirst.setBackground(Color.PINK);
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/Last.png")));
		btnFirst.setBounds(246, 214, 69, 27);
		contentPane.add(btnFirst);
		
		lblStatus = new JLabel("Record: 0 of 0");
		lblStatus.setForeground(Color.RED);
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(328, 214, 99, 27);
		contentPane.add(lblStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 302, 590, 155);
		contentPane.add(scrollPane);
		
		tbl = new JTable();
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = tbl.getSelectedRow();
				edit();
				setStatus();
			}
		});
		scrollPane.setViewportView(tbl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 252, 324, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnOrderName = new JButton("Order By Name");
		btnOrderName.setBackground(new Color(255, 228, 196));
		btnOrderName.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/ten.png")));
		btnOrderName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderName();
			}
		});
		btnOrderName.setBounds(10, 6, 146, 25);
		panel_1.add(btnOrderName);
		
		JButton btnOrderSal = new JButton("Order By Salary");
		btnOrderSal.setBackground(new Color(255, 228, 196));
		btnOrderSal.setIcon(new ImageIcon(QuanLyNhanVien.class.getResource("/poly/icons/luong.png")));
		btnOrderSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderSal();
			}
		});
		btnOrderSal.setBounds(166, 7, 146, 23);
		panel_1.add(btnOrderSal);
		
		lblHinh = new JLabel("");
		lblHinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectLogo();
			}
		});
		lblHinh.setBounds(10, 43, 165, 160);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
		lblHinh.setBorder(border);
		contentPane.add(lblHinh);
		
		init();
	}
	
	void init() {
		setCol();
		timer();
	}
	
	// setHinh
	public void selectLogo() {
		JFileChooser fileChooser = new JFileChooser();
		if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			saveLogo(file);
			lblHinh.setIcon(readLogo(file.getName()));
			lblHinh.setToolTipText(file.getName());
		}
	}
	
	public void saveLogo(File logo) {
		File file = new File("logos");
		if(!file.exists())
			file.mkdirs();
		
		try {
			File newLogo = new File("logos", logo.getName());
			
			Path source = Paths.get(logo.getAbsolutePath());
			Path desti = Paths.get(newLogo.getAbsolutePath());
			
			Files.copy(source, desti, StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Có lỗi khi lưu file");
		}
	}
	
	public ImageIcon readLogo(String name) {
		if(name == null)
			return null;
		File logo = new File("logos", name);
		ImageIcon ii = new ImageIcon(logo.getAbsolutePath());
		return ii;
	}
	
	List<Employee> list = new ArrayList<Employee>();
	File file = new File("file/file.dat");
	String path = file.getAbsolutePath();
	
	public void setCol() {
		String[] col = {"MÃ", "HỌ VÀ TÊN", "TUỔI", "EMAIL", "LƯƠNG"};
		tbl.setModel(new DefaultTableModel(null, col));
	}
	
	public void timer() {
		new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
				Date date = new Date();
				String now = sdf.format(date);
				lblClock.setText(now);
			}
		}).start();
	}
	
	
	public void openFile() {
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Employee>)ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Có lỗi trong việc xử lý");
		}
		
		if(list.size() > 0) {
			fillToTable();
			index = 0;
			edit();
		}
		else 
			reset();
	}
	
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Có lỗi trong việc xử lý");
		}
	}
	
	public void save() {
		if(index == -1)
			addEmp();
		else 
			updateEmp();
		saveFile();
	}
	
	public void setStatus() {
		int size = tbl.getRowCount();
		lblStatus.setText("Record: " + (index + 1) + " of " + size);
	}
	
	public void fillToTable() {
		DecimalFormat df = setCurrency();
		
		DefaultTableModel model = (DefaultTableModel)tbl.getModel();
		model.setRowCount(0);
		
		for(int i=0; i<list.size(); i++) {
			Employee e = list.get(i);
			Object[] row = {e.getManv(), e.getHoten(), e.getTuoi(), 
					e.getEmail(), df.format(e.getLuong())};
			model.addRow(row);
		}
	}
	
	public Employee getInfo() {
		Employee e = new Employee();
		String luong = txtLuong.getText().replaceAll("\\.", "");
		
		e.setManv(txtMaNV.getText());
		e.setHoten(txtHoTen.getText());
		e.setTuoi(Integer.parseInt(txtTuoi.getText()));
		e.setEmail(txtEmail.getText());
		e.setLuong(Double.parseDouble(luong));
		e.setHinh(lblHinh.getToolTipText());
		return e;
	}
	
	public DecimalFormat setCurrency() {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("##,###", dfs);
		return df;
	}
	
	public void showDetail(Employee e) {
		DecimalFormat df = setCurrency();
		
		txtMaNV.setText(e.getManv());
		txtHoTen.setText(e.getHoten());
		txtTuoi.setText(String.valueOf(e.getTuoi()));
		txtEmail.setText(e.getEmail());
		txtLuong.setText(df.format(e.getLuong()));
		lblHinh.setIcon(readLogo(e.getHinh()));
	}
	
	public void edit() {
		String manv = (String)tbl.getValueAt(index, 0);
		for(Employee e:list) 
			if(e.getManv().equals(manv)) {	
				showDetail(e);
				setStatus();
				break;
			}
	}
	
	public boolean tuoiLuongEmail(){
		Employee e = getInfo();
		String emailPattern = "^(.+)@(.+)$";
		
		if(e.getTuoi() < 16 || e.getTuoi() > 55) {
			JOptionPane.showMessageDialog(this, "Tuổi phải từ 16-55");
			return false;
		}else if (!e.getEmail().matches(emailPattern)) {
			JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
			return false;
		}else if (e.getLuong() < 5000) {	
			JOptionPane.showMessageDialog(this, "Lương phải trên 5000");
			return false;
		}
		return true;
	}
	
	public void orderName() {
		Comparator<Employee> com = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getHoten().compareTo(o2.getHoten());
			}
		};
		Collections.sort(list, com);
		fillToTable();
	}
	
	public void orderSal() {
		Comparator<Employee> com = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				double luong1 = o1.getLuong();
				double luong2 = o2.getLuong();
				return Double.compare(luong1, luong2);
			}
		};
		Collections.sort(list, com);
		fillToTable();
	}
	
	public void addEmp() {
		Employee e = getInfo();
		String manv = e.getManv();
		boolean exist = false;
		
		if(manv.equals("")) {
			exist = true;
			JOptionPane.showMessageDialog(this, "Không để trống MaNV");
		}
		else
			for(Employee e1:list) 
				if(manv.equals(e1.getManv())) {
					exist = true;
					JOptionPane.showMessageDialog(this, "MaNV này đã tồn tại");
				}
		
		if(exist == false && tuoiLuongEmail() == true) {
			list.add(e);
			fillToTable();
			index = tbl.getRowCount() - 1;
			setStatus();
		}
	}
	
	public void updateEmp() {
		if(tuoiLuongEmail() == true) {
			Employee e = getInfo();
			list.set(index, e);
		}
	}
	
	public void deleteEmp() {
		Employee e = getInfo();
		String manv = e.getManv();
		boolean kiemloi = false;
		
		for(int i=0; i<list.size(); i++) {
			Employee e1 = list.get(i);
			if(e1.getManv().equals(manv)) {
				list.remove(e1);
				reset();
				JOptionPane.showMessageDialog(this, "Đã xóa thành công");
				fillToTable();
				saveFile();
				kiemloi = true;
				break;
			}
		}
		if(kiemloi == false)
			JOptionPane.showMessageDialog(this, "Chưa nhập MaNV hoặc Không tồn tại MaNV");
	}
	
	public void find() {
		String manv = txtMaNV.getText();
		boolean exist = false;
		
		for(int i=0; i<list.size(); i++) {
			Employee e = list.get(i);
			if(e.getManv().equalsIgnoreCase(manv)) {
				index = i;
				edit();
				exist = true;
				break;
			}
		}
		if(exist == false) JOptionPane.showMessageDialog(this, "Không có nhân viên này");
	}
	
	public void exit() {
		int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn đóng?", "Exit Program", 1);
		if(res == JOptionPane.YES_OPTION) {
			saveFile();
			System.exit(0);
		}
	}
	
	public void reset() {
		showDetail(new Employee());
		index = -1;
		setStatus();
		txtMaNV.setEditable(true);
	}
	
	int index = 0;
	
	public void last() {
		index = tbl.getRowCount() - 1;
		edit();
		setStatus();
	}
	
	public void pre() {
		index --;
		if(index < 0)
			index = tbl.getRowCount() - 1;
		edit();
		setStatus();
	}
	
	public void first() {
		index = 0;
		edit();
		setStatus();
	}
	
	public void next() {
		index ++;
		if(index > tbl.getRowCount() - 1)
			index = 0;
		edit();
		setStatus();
	}
}













