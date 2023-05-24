package view;

import model.Employee;
import dao.DaoEmployee;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import clock_theard.Clock;
import custom_exception.ObjectNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;

public class View extends javax.swing.JFrame {

    DaoEmployee dao = new DaoEmployee();
    String path = "";
    int rowIndex = -1;

    public View() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void fillToTable() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        DefaultTableModel model = (DefaultTableModel) tblEmpolyee.getModel();
        model.setRowCount(0);
        for (Employee x : dao.getData()) {
            model.addRow(new Object[]{x.getMaNhanVien(), x.getTenNhanVien(), x.getTuoi(), x.getEmail(),numberFormat.format(x.getLuong())});
        }
    }

    public void SaveData() {
        dao.save(new Employee(txtMaNhanVien.getText(), txtTenNhanVien.getText(), Integer.parseInt(txtTuoi.getText()), txtEmail.getText(), Double.parseDouble(txtLuong.getText()), this.path));
        fillToTable();
    }

    public void clearForm() {
        txtEmail.setText("");
        txtLuong.setText("");
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        txtTuoi.setText("");
        tblEmpolyee.clearSelection();
        this.path = "";
        ImageIcon iI = new ImageIcon(this.path);
        Image img = iI.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(img));
        rowIndex = -1;
    }

    public void deleteData() {
        if (dao.getData().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có đữ liệu trong bảng", "Thông báo", 2);
        } else {
            try {
                dao.delete(tblEmpolyee.getSelectedRow());
                fillToTable();
                JOptionPane.showMessageDialog(this, "Xóa thành Công", "Thông báo", 1);
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu từ bảng", "Thông báo", 3);
            }
        }
    }

    public String Find() {
        String maNhanVien;
        maNhanVien = JOptionPane.showInputDialog(this, "Nhập mã");
        return maNhanVien;
    }

    public void setRecord() {
        lblTotalRecord.setText(String.valueOf(tblEmpolyee.getRowCount()));
    }

    public boolean validateForm() {

        boolean checkMail = true, checkName = true, checkID = true, checkSalary = true, checkAge = true, checkValidate = false, checkImage = true;
        if (tblEmpolyee.getSelectedRow() == -1) {
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (txtMaNhanVien.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống mã", "Thông báo", 1);
                checkID = false;
            } else {
                for (Employee x : dao.getData()) {
                    if (x.getMaNhanVien().equals(txtMaNhanVien.getText())) {
                        checkID = false;
                        JOptionPane.showMessageDialog(this, "Không để trùng mã", "Thông báo", 1);
                        break;
                    }
                }
            }
            if (txtTenNhanVien.getText().trim().equals("")) {
                checkName = false;
                JOptionPane.showMessageDialog(this, "Không để trống tên", "Thông báo", 1);
            }
            if (txtTuoi.getText().trim().equals("")) {
                checkAge = false;
                JOptionPane.showMessageDialog(this, "Không để trống tuổi", "Thông báo", 1);
            } else {
                try {
                    if (Integer.parseInt(txtTuoi.getText()) < 16 || Integer.parseInt(txtTuoi.getText()) > 55) {
                        checkAge = false;
                        JOptionPane.showMessageDialog(this, "Tuổi phải từ 16-55", "Thông báo", 1);
                    }
                } catch (NumberFormatException e) {
                    checkAge = false;
                    JOptionPane.showMessageDialog(this, "Vui Lòng nhập đúng định dạng số", "Thông báo", 1);
                }
            }
            if (txtEmail.getText().trim().equals("")) {
                checkMail = false;
                JOptionPane.showMessageDialog(this, "Không để trống Email", "Thông báo", 1);
            } else {
                if (txtEmail.getText().matches(emailRegex) == false) {
                    checkMail = false;
                    JOptionPane.showMessageDialog(this, "Email không dúng định dạng", "Thông báo", 1);
                }
            }
            if (txtLuong.getText().trim().equals("")) {
                checkSalary = false;
                JOptionPane.showMessageDialog(this, "Không để trống Lương", "Thông báo", 1);
            } else {
                try {
                    if (Double.parseDouble(txtLuong.getText()) < 5000000) {
                        checkSalary = false;
                        JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 5000000 VND", "Thông báo", 1);
                    }

                } catch (NumberFormatException e) {
                    checkSalary = false;
                    JOptionPane.showMessageDialog(this, "Vui Lòng nhập đúng định dạng số", "Thông báo", 1);

                }
            }
            if (path.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh của nhân viên", "Thông báo", 2);
                checkImage = false;
            }
        } else {
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (txtMaNhanVien.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Không để trống mã", "Thông báo", 1);
                checkID = false;
            } else {
                if (dao.getData().get(tblEmpolyee.getSelectedRow()).getMaNhanVien().equals(txtMaNhanVien.getText())) {
                    checkID = true;
                } else {
                    for (Employee x : dao.getData()) {
                        if (x.getMaNhanVien().equals(txtMaNhanVien.getText())) {
                            checkID = false;
                            JOptionPane.showMessageDialog(this, "Không để trùng mã", "Thông báo", 1);
                        }
                    }
                }
            }
            if (txtTenNhanVien.getText().trim().equals("")) {
                checkName = false;
                JOptionPane.showMessageDialog(this, "Không để trống tên", "Thông báo", 1);
            }
            if (txtTuoi.getText().trim().equals("")) {
                checkAge = false;
                JOptionPane.showMessageDialog(this, "Không để trống tuổi", "Thông báo", 1);
            } else {
                try {
                    if (Integer.parseInt(txtTuoi.getText()) < 16 || Integer.parseInt(txtTuoi.getText()) > 55) {
                        checkAge = false;
                        JOptionPane.showMessageDialog(this, "Tuổi phải từ 16-55", "Thông báo", 1);
                    }
                } catch (NumberFormatException e) {
                    checkAge = false;
                    JOptionPane.showMessageDialog(this, "Vui Lòng nhập đúng định dạng số", "Thông báo", 1);
                }
            }
            if (txtEmail.getText().trim().equals("")) {
                checkMail = false;
                JOptionPane.showMessageDialog(this, "Không để trống Email", "Thông báo", 1);
            } else {
                if (txtEmail.getText().matches(emailRegex) == false) {
                    checkMail = false;
                    JOptionPane.showMessageDialog(this, "Email không dúng định dạng", "Thông báo", 1);
                }
            }
            if (txtLuong.getText().trim().equals("")) {
                checkSalary = false;
                JOptionPane.showMessageDialog(this, "Không để trống Lương", "Thông báo", 1);
            } else {
                try {
                    if (Double.parseDouble(txtLuong.getText()) < 5000000) {
                        checkSalary = false;
                        JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 5000000 VND", "Thông báo", 1);
                    }

                } catch (NumberFormatException e) {
                    checkSalary = false;
                    JOptionPane.showMessageDialog(this, "Vui Lòng nhập đúng định dạng số", "Thông báo", 1);

                }
            }
            if (path.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh của nhân viên", "Thông báo", 2);
                checkImage = false;
            }

        }
        if (checkAge == true && checkMail == true && checkName == true && checkID == true && checkSalary == true && checkImage == true) {
            checkValidate = true;

        }
        return checkValidate;
    }

    public void update() {
        dao.update(tblEmpolyee.getSelectedRow(), txtMaNhanVien.getText(), txtTenNhanVien.getText(), Integer.valueOf(txtTuoi.getText()), txtEmail.getText(), Double.valueOf(txtLuong.getText()), path);
        fillToTable();
    }

    public void showData(int index) {
        txtMaNhanVien.setText(String.valueOf(dao.getData().get(index).getMaNhanVien()));
        txtTenNhanVien.setText(String.valueOf(dao.getData().get(index).getTenNhanVien()));
        txtTuoi.setText(String.valueOf(dao.getData().get(index).getTuoi()));
        txtEmail.setText(String.valueOf(dao.getData().get(index).getEmail()));
        txtLuong.setText(String.valueOf((long)dao.getData().get(index).getLuong()));
        ImageIcon iI = new ImageIcon(dao.getData().get(index).getImage());
        this.path = dao.getData().get(index).getImage();
        Image img = iI.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(img));
        lblCountRecord.setText(String.valueOf(tblEmpolyee.getSelectedRow() + 1));
        
    }

    public void pre() {
        try {
            if (tblEmpolyee.getSelectedRow() > -1) {
                try {
                    rowIndex = tblEmpolyee.getSelectedRow();
                    rowIndex--;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                } catch (Exception e) {
                    rowIndex = tblEmpolyee.getRowCount() - 1;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                }
            } else {
                try {
                    rowIndex--;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                } catch (Exception e) {
                    rowIndex = tblEmpolyee.getRowCount() - 1;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Trong bảng không có đữ liệu", "Thông báo", 1);

        }
    }

    public void next() {
        try {
            if (tblEmpolyee.getSelectedRow() > -1) {
                try {
                    rowIndex = tblEmpolyee.getSelectedRow();
                    rowIndex++;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                } catch (Exception e) {
                    rowIndex = 0;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                }
            } else {
                try {
                    rowIndex++;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                } catch (Exception e) {
                    rowIndex = 0;
                    tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
                    showData(rowIndex);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Trong bảng không có đữ liệu", "Thông báo", 1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnForm = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtLuong = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        lblCountRecord = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalRecord = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnBrowserImage = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();
        btnSortByName = new javax.swing.JToggleButton();
        btnSortBySalary = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpolyee = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 255));
        jLabel1.setText("Quản Lý Nhân Viên");

        jLabel2.setText("Mã nhân Viên");

        jLabel3.setText("Tuổi");

        jLabel4.setText("Lương");

        jLabel5.setText("Tên nhân viên");

        jLabel6.setText("Email");

        txtLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFormLayout = new javax.swing.GroupLayout(pnForm);
        pnForm.setLayout(pnFormLayout);
        pnFormLayout.setHorizontalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNhanVien))
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTuoi))
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtLuong, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        pnFormLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        pnFormLayout.setVerticalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNew)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnFind)
                    .addComponent(btnExit)
                    .addComponent(btnOpen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnExit, btnFind, btnNew, btnOpen, btnSave});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave)
                .addGap(9, 9, 9)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        jButton8.setText("|<");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        btnPre.setText("<<");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jButton9.setText(">|");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        lblCountRecord.setText("0");

        jLabel7.setText("Record :");

        lblTotalRecord.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCountRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(33, 33, 33)
                .addComponent(btnPre)
                .addGap(29, 29, 29)
                .addComponent(btnNext)
                .addGap(38, 38, 38)
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNext, btnPre, jButton8, jButton9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(btnPre)
                    .addComponent(btnNext)
                    .addComponent(jButton9)
                    .addComponent(lblCountRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnNext, btnPre, jButton8, jButton9});

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnBrowserImage.setText("Browser Image");
        btnBrowserImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserImageActionPerformed(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblClock.setForeground(new java.awt.Color(204, 0, 51));
        lblClock.setText("00:00:00");

        btnSortByName.setText("Sort by name");
        btnSortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByNameActionPerformed(evt);
            }
        });

        btnSortBySalary.setText("Sort by salary");
        btnSortBySalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortBySalaryActionPerformed(evt);
            }
        });

        tblEmpolyee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ và tên", "Tuổi", "Email", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpolyee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpolyeeMouseClicked(evt);
            }
        });
        tblEmpolyee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblEmpolyeeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpolyee);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(pnForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnBrowserImage)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnSortByName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)
                                                .addComponent(btnSortBySalary, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBrowserImage))
                    .addComponent(pnForm, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSortBySalary)
                            .addComponent(btnSortByName))))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLuongActionPerformed

    }//GEN-LAST:event_txtLuongActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        try {
            dao.saveFile();
            JOptionPane.showMessageDialog(this, "Lưu và thoát thành công", "Thông báo", 2);
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lưu file thất bại", "Thông báo", 2);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        try {
            JOptionPane.showMessageDialog(this, "Mở file thành công", "Thông báo", 2);
            dao.openFile();
            fillToTable();
            setRecord();
            rowIndex = 0;
            showData(rowIndex);
            tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình load file", "Thông báo", 2);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình load file", "Thông báo", 2);
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            rowIndex = 0;
            tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
            showData(rowIndex);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Trong bảng không có đữ liệu", "Thông báo", 1);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (tblEmpolyee.getSelectedRow() > -1) {
            if (validateForm() == true) {
                update();
                clearForm();
                JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thành công", "Thông báo", 2);

                tblEmpolyee.clearSelection();

            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật dữ liệu thất bại", "Thông báo", 2);
            }
        } else {
            if (validateForm() == false) {
                JOptionPane.showMessageDialog(this, "Thêm đữ liệu thất bại", "Thông báo", 2);
            } else {
                SaveData();
                setRecord();
                JOptionPane.showMessageDialog(this, "Thêm đữ liệu thành công ", "Thông báo", 2);

                clearForm();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearForm();
        tblEmpolyee.clearSelection();
        System.out.println(tblEmpolyee.getSelectedRow());
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteData();
        setRecord();
        clearForm();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (dao.getData().isEmpty()) {
            JOptionPane.showMessageDialog(this, "bảng không có dữ liêu", "Thông báo", 1);
        } else {
            String maNV = Find();
            if (maNV.equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên", "Thông báo", 1);
            } else {
                try {
                    int age = dao.find(maNV).getTuoi();
                    double salary = dao.find(maNV).getLuong();
                    txtTenNhanVien.setText(dao.find(maNV).getTenNhanVien());
                    txtMaNhanVien.setText(dao.find(maNV).getMaNhanVien());
                    txtEmail.setText(dao.find(maNV).getEmail());
                    txtTuoi.setText(String.valueOf(age));
                    txtLuong.setText(String.valueOf((long)salary));
                    ImageIcon iI = new ImageIcon(dao.find(maNV).getImage());
                    Image img = iI.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                    lblImage.setIcon(new ImageIcon(img));
                    for(int i = 0;i<tblEmpolyee.getRowCount();i++){
                        if (tblEmpolyee.getValueAt(i,0).equals(dao.find(maNV).getMaNhanVien())) {
                            tblEmpolyee.setRowSelectionInterval(i,i);            
                            break;
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu", "Thông báo", 1);

                }
            }
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void tblEmpolyeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpolyeeMouseClicked
        showData(tblEmpolyee.getSelectedRow());
    }//GEN-LAST:event_tblEmpolyeeMouseClicked

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        pre();
    }//GEN-LAST:event_btnPreActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            rowIndex = tblEmpolyee.getRowCount() - 1;
            tblEmpolyee.setRowSelectionInterval(rowIndex, rowIndex);
            showData(rowIndex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Trong bảng không có đữ liệu", "Thông báo", 1);

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnBrowserImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserImageActionPerformed
        JFileChooser browserImage = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGE", "png", "jpg", "bmp", "jpeg");
        browserImage.addChoosableFileFilter(fnef);
        int showOpenDialouge = browserImage.showOpenDialog(null);
        if (showOpenDialouge == browserImage.APPROVE_OPTION) {
            File selectedImageFile = browserImage.getSelectedFile();
            path = selectedImageFile.getAbsolutePath();
            ImageIcon iI = new ImageIcon(path);
            Image img = iI.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_btnBrowserImageActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Clock clock = new Clock(lblClock);
        Thread t1 = new Thread(clock);
        t1.start();
    }//GEN-LAST:event_formWindowOpened

    private void btnSortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByNameActionPerformed
        dao.sortByName();
        fillToTable();
        clearForm();
    }//GEN-LAST:event_btnSortByNameActionPerformed

    private void btnSortBySalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortBySalaryActionPerformed
      dao.sortBySalary();
      fillToTable();
      clearForm();
    }//GEN-LAST:event_btnSortBySalaryActionPerformed

    private void tblEmpolyeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEmpolyeeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblEmpolyeeKeyPressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowserImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnSave;
    private javax.swing.JToggleButton btnSortByName;
    private javax.swing.JToggleButton btnSortBySalary;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblCountRecord;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTotalRecord;
    private javax.swing.JPanel pnForm;
    private javax.swing.JTable tblEmpolyee;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
