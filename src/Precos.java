import java.util.Scanner;

public class Precos {

    public void calcularPrecos() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Insira o valor do produto: ");
        //Captura o valor do produto
        double preco = scan.nextDouble();
        /*
        Inclui no valor do produto a taxa de 19% do anúncio Premium do ML
         e inclui também a taxa de frete que nesse caso é R$43,90.
         */
        double precoMercadoLivre = preco + (preco * 0.19) + 43.9;
        /*
        Inclui no valor do produto a taxa de 14% da Shopee e
        também inclui a taxa por venda fixa de R$4,00.
        */
        double precoShopee = preco + (preco * 0.14) + 4;
        /*
        Inclui no valor do produto a taxa de 16% da Shein e também
        inclui a taxa de frete de R$5,00. Adiciona o valor proporcional a um dia
        do plano de assinatura do Bling para gerar as notas fiscais.
         */
        double precoShein = preco + (preco * 0.16) + 5 + ((double) 100 / 30);
        /*
        Inclui no valor do produto a taxa de cobrança do cartão da NuvemShop (5,49% + R$0,35)
        também inclui os valores proporcionais a um dia dos planos da NuvemShop e do Bling.
         */
        double precoNuvemShop = preco + (preco * 0.549) + 0.35 + ((double) 249.9 / 30);
        /*
        Mostra o preço médio do produto levando em consideração o valor cobrado em cada plataforma!
         */
        double precoMedio = (precoShein + precoShopee + precoMercadoLivre + precoNuvemShop) / 4;



        scan.close();
        System.out.printf("O preço do produto é R$%.2f%n", preco);
        System.out.printf("No Mercado Livre R$%.2f%n", precoMercadoLivre);
        System.out.printf("Na Shopee R$%.2f%n", precoShopee);
        System.out.printf("Na Shein R$%.2f%n", precoShein);
        System.out.printf("Na NuvemShop R$%.2f%n", precoNuvemShop);
        System.out.printf("O preço médio é R$%.2f%n", precoMedio);
    }
}
