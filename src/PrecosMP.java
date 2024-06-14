import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrecosMP extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JButton button;

    public PrecosMP() {
        setTitle("Cálculo de Preços");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Área de texto para exibir os resultados
        textArea = new JTextArea();
        textArea.setEditable(false); // Para evitar edição na área de texto
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão para calcular os preços e exibir os resultados
        button = new JButton("Calcular Preços");
        button.addActionListener(this);
        panel.add(button, BorderLayout.SOUTH);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            // Chamada do método para calcular os preços e exibir os resultados
            calcularPrecos();
        }
    }

    public void calcularPrecos() {
        // Aqui você pode fazer os cálculos e exibir os resultados na área de texto
        String input = JOptionPane.showInputDialog("Insira o valor do produto: ");

        String precoString = input.replace(",", ".");

        double preco = Double.parseDouble(precoString);

        double precoMercadoLivre = preco + (preco * 0.19) + 43.9;
        double precoShopee = preco + (preco * 0.14) + 4;
        double precoShein = preco + (preco * 0.16) + 5 + ((double) 100 / 30);
        double precoNuvemShop = preco + (preco * 0.549) + 0.35 + (249.9 / 30);
        double precoMedio = (precoShein + precoShopee + precoMercadoLivre + precoNuvemShop) / 4;

        // Limpa a área de texto antes de exibir os resultados
        textArea.setText("");

        // Exibe os resultados na área de texto
        textArea.append(String.format("O preço do produto é R$%.2f%n", preco));
        textArea.append(String.format("No Mercado Livre R$%.2f%n", precoMercadoLivre));
        textArea.append(String.format("Na Shopee R$%.2f%n", precoShopee));
        textArea.append(String.format("Na Shein R$%.2f%n", precoShein));
        textArea.append(String.format("Na NuvemShop R$%.2f%n", precoNuvemShop));
        textArea.append(String.format("O preço médio é R$%.2f%n", precoMedio));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PrecosMP janela = new PrecosMP();
            janela.setVisible(true);
        });
    }
}
