package dictionary;
import javax.swing.*;// thư viện giao diên
import java.awt.*;
import java.awt.event.ActionEvent; // thư viện xử lý sự kiên
import java.awt.event.ActionListener;
import java.util.HashMap; 

public class DictionaryAppGui extends JFrame // kế thừa từ jframe để taoj giao diện
{
	private HashMap<String, String> dictionary; // hashmap đẻ lưu trữ tư điển
	private JTextField inputField; // text file dùng để nhập từ
	private JTextField outputField; // text dùng để hiênr thị kết qủa 
	private JButton translateButton; // Button dịch từ
	private JButton addWordButton; // thêm từ mới 
	
	
	public DictionaryAppGui() {
		dictionary = new HashMap<>(); // Hashmap< kiểu key ,kiểu value> tên Hashmap = new Hashmap<>();
		dictionary.put("hello", "Xin chào"); // dictionary.put<key, value>
		dictionary.put("goobye", "Tạm biệt");
		dictionary.put("book", "Sách");
		dictionary.put("bomputer", "Máy tính");
		dictionary.put("keybroad", "Bàn phím ");
		
		
		
		// Cài đặt cửa số chính 
		
		setTitle("Ứng dụng từ điển");// tiêu để của cửa số 
		setSize(600,300); // kích thước của cửa sổ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // khi đóng của sóo sẽ kết thúc chương trình 
		setLocationRelativeTo(null); // Căn giữa của sổ khi chạy chương trình 
		setLayout(new GridBagLayout()); // sử dụng Gridbaglayout để căn giữa các thành phần
		getContentPane().setBackground(new Color(240, 248, 255)); // set màu bạckground 
		
		
		// Tạo đối tưọng GridBagConstraint để quản lý bố cục
		
		GridBagConstraints gbc = new GridBagConstraints(); // tạo đối tượng Gridbagconstraints
		gbc.insets = new Insets(10, 10, 10, 10); // căn lề giữa các thành phần 
		gbc.fill = GridBagConstraints.HORIZONTAL; // căn các thành phần theo chiều ngang 
		gbc.gridwidth = 1; // số ô chiếm trên lưới là 1
		
		
		// Label nhập từ 
		JLabel inputLabel = new JLabel("Nhập từ: ");
		inputLabel.setFont(new Font("Arial", Font.BOLD, 16)); // font chữ arial ,đậm có cỡ chữ là 16
		
		inputLabel.setForeground(new Color(25, 25, 112)); //  màu xanh đạma
		gbc.gridx = 0; // cột 0
		gbc.gridy = 0; // dòng 0
		
		add(inputLabel, gbc); // thêm label vào frame
		
		
		// text Field để nhập từ
		inputField = new JTextField(15); // textfield có chiều dài ký tự là 15 
		inputField.setFont(new Font("Arial", Font.PLAIN, 16));
		
		inputField.setForeground(Color.BLACK); //MÀU VÀNG NHẠT
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2; //số ô chiếm trên lưới là 2
		add(inputField, gbc); // thêm inputfield vào jframe
		
		
		// Button dịch 
		translateButton = new JButton("Dịch "); // tạo  button dịch
		translateButton.setFont(new Font("Arial", Font.BOLD, 16));
		translateButton.setBackground(new Color(60, 179, 113));// màu xanh lá cây nhạt 
		translateButton.setForeground(Color.WHITE);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(translateButton, gbc);
		
		
		// Textfield  để hiển thị kết quả
		outputField = new JTextField(15); // có chiều dài là 15 ký tự 
		outputField.setFont(new Font("Arial", Font.PLAIN, 16));
		outputField.setEditable(false);// không cho phép chỉnh sửa
		outputField.setBackground(new Color(255, 228, 196));
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(outputField, gbc);
		
		// Button thêm từ mới vào từ điển
		
		addWordButton = new JButton("Thêm từ");
		addWordButton.setFont(new Font("Arial", Font.BOLD, 16));
		addWordButton.setBackground(new Color(100, 149, 237));
		addWordButton.setForeground(Color.WHITE);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		add(addWordButton, gbc);
		
		
		// xử lý hành động cho nút button
		
		translateButton.addActionListener(new ActionListener() {// sự kiện xảy ra khi nhấn nút  DỊCH
			

			@Override
			public void actionPerformed(ActionEvent e) {// hàm  void xử lý hành động 
				String inputWord = inputField.getText().toLowerCase(); // lấy từ vừa nhâpj vao là chuyển thành chư thường
				String meaning = dictionary.get(inputWord); // lấy nghĩa từ tương ứng trogn hash map 
				if(meaning != null)// nếu từ có nghĩa
				{
					outputField.setText(meaning);
				}else {
					
					outputField.setText("Từ này không có trong từ điển" );
				}
				// TODO Auto-generated method stub
				
			}
			
		});
		// Xử lý dữ kiện cho nut Thêm từ 
		addWordButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newEnglishWord = JOptionPane.showInputDialog("Nhập từ tiếng anh mới: ");// hiển thị hộp thoại để nhập từ mới
				String newVietNamWord = JOptionPane.showInputDialog("Nhập nghĩa của từ vừa nhập: ");
					if(newEnglishWord != null && newVietNamWord != null) {// nếu từ nhập vào và nghĩa tiếng viêtj không trống thì thêm vào từ điển
						dictionary.put(newEnglishWord, newVietNamWord); // thêm tư mới vào thư viện 
						JOptionPane.showMessageDialog(null, "Đã thêm từ mới vào từ điển "); // thông báo
						
					}
				
			}
			
		});
		
	}
	public static void main(String[] args) {
		DictionaryAppGui app = new DictionaryAppGui();
		
		app.setVisible(true);
	}
	}
