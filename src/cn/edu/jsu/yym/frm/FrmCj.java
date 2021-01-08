package cn.edu.jsu.yym.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yym.dao.ScjDAO;
import cn.edu.jsu.yym.dao.ScjExcel;
import cn.edu.jsu.yym.dao.ScjTxt;
import cn.edu.jsu.yym.vo.Scj;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCj extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnImportExcel;
	private JButton btnExportTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCj frame = new FrmCj();
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
	public FrmCj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnImportExcel = new JButton("导出Excel");
		btnImportExcel.setBounds(101, 10, 111, 25);
		btnImportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ScjExcel().exportExcel(new ScjDAO().getAllScjData());
				JOptionPane.showMessageDialog(null, "导出文件成功!");
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnImportExcel);
		
		btnExportTxt = new JButton("导出TXT文件");
		btnExportTxt.setBounds(217, 10, 129, 25);
		btnExportTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ScjTxt().exportTxt(new ScjDAO().getAllScjData());
				JOptionPane.showMessageDialog(null, "导出文件成功!");
			}
		});
		contentPane.add(btnExportTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 422, 202);
		contentPane.add(scrollPane);
		
		Vector<String> titles=new Vector<String>();
		Collections.addAll(titles, "学号","姓名","性别","成绩");
		Vector<Vector> listcj=new ScjDAO().getTableRows(new ScjDAO().getAllScjData());
		
		table = new JTable(listcj,titles);
		
		scrollPane.setViewportView(table);
		
	}

}
