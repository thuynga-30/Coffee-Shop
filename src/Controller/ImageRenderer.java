package Controller;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class ImageRenderer extends DefaultTableCellRenderer {
	JLabel lbl = new JLabel();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (value != null) {
			// Đọc dữ liệu hình ảnh
			ImageIcon icon = new ImageIcon((byte[]) value);
			Image image = icon.getImage();

			// Kiểm tra hướng xoay của hình ảnh
			int width = image.getWidth(null);
			int height = image.getHeight(null);
			if (width > height) {
				// Nếu chiều rộng lớn hơn chiều cao, quay ảnh
				image = image.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
			} else {
				// Ngược lại, không cần quay ảnh
				image = image.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
			}

			// Tạo mới ImageIcon từ hình ảnh đã được chỉnh sửa
			ImageIcon scaledIcon = new ImageIcon(image);
			lbl.setIcon(scaledIcon);
		} else {
			lbl.setIcon(null);
		}
		return lbl;
	}

	
	}
