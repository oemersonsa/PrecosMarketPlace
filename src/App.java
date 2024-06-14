import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private JButton button;

    public App() {
        setTitle("Cadastro de Dados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Campo de texto para inserir dados
        textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);

        // Área de texto para exibir os dados inseridos
        textArea = new JTextArea();
        textArea.setEditable(false); // Para evitar edição na área de texto
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão para adicionar dados à área de texto
        button = new JButton("Adicionar");
        button.addActionListener(this);
        panel.add(button, BorderLayout.SOUTH);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String data = textField.getText();
            textArea.append(data + "\n");
            textField.setText(""); // Limpa o campo de texto após adicionar os dados
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrecosMP janela = new PrecosMP();
            janela.setVisible(true);
        });
    }
}
