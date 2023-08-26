package Gerencia;

import java.util.ArrayList;

public class BaseDeDados {

    private ArrayList<int[][]> avaliacoes = new ArrayList<>();
    private final String[] usuarios = {
        "Lucas", "Sofia", "Mateus", "Isabella", "Pedro",
        "Laura", "João", "Julia", "Gabriel", "Valentina"
    };

    private final String[] filmes = {
        "O Destino de uma Nação", "A Origem", "O Senhor dos Anéis: A Sociedade do Anel", "O Poderoso Chefão", "Matrix",
        "O Rei Leão", "Titanic", "Interestelar", "Harry Potter e a Pedra Filosofal", "O Clube da Luta",
        "Jurassic Park", "Forrest Gump", "Avatar", "Batman: O Cavaleiro das Trevas", "A Lista de Schindler",
        "De Volta para o Futuro", "Gladiador", "Piratas do Caribe: A Maldição do Pérola Negra", "O Silêncio dos Inocentes", "Pantera Negra"
    };

    public BaseDeDados(int numUsuarios, int numFilmes) {
        // Inicializa a matriz de avaliações com todas as posições como 0
        for (int i = 0; i < numUsuarios; i++) {
            int[][] matrizInicial = new int[numFilmes][1]; // Supondo uma coluna para armazenar a nota
            avaliacoes.add(matrizInicial);
        }
    }

    public String registrarAvaliacao(int usuarioIndex, int filmeIndex, int nota) {
        if (usuarioIndex < 0 || usuarioIndex >= avaliacoes.size()) {
            return "Usuário não encontrado";
        }

        int[][] matrizUsuario = avaliacoes.get(usuarioIndex);

        if (filmeIndex < 0 || filmeIndex >= matrizUsuario.length) {
            return "Filme não encontrado";
        }

        matrizUsuario[filmeIndex][0] = nota;  // Supondo que a nota será armazenada na primeira coluna

        return "Avaliação registrada com sucesso";
    }
    
    public double calcularDistancia(int usuario1, int usuario2) {
    int[][] avaliacoesUsuario1 = avaliacoes.get(usuario1);
    int[][] avaliacoesUsuario2 = avaliacoes.get(usuario2);
    double somaQuadrados = 0;

    for (int filme = 0; filme < avaliacoesUsuario1.length; filme++) {
        somaQuadrados += Math.pow(avaliacoesUsuario1[filme][0] - avaliacoesUsuario2[filme][0], 2);
    }

    return Math.sqrt(somaQuadrados);
}
    
    public String listarAvaliacoes(int usuarioIndex) {
    StringBuilder listaAvaliacoes = new StringBuilder();

    for (int filmeIndex = 0; filmeIndex < avaliacoes.get(usuarioIndex).length; filmeIndex++) {
        int nota = avaliacoes.get(usuarioIndex)[filmeIndex][0];
        if (nota > 0) {
            listaAvaliacoes.append(usuarios[usuarioIndex]).append(" avaliou o filme '").append(filmes[filmeIndex]).append("' com nota ").append(nota).append("\n");
        }
    }

    return listaAvaliacoes.toString();
}

    public String solicitarRecomendacao(int usuarioIndex) {
    String[] filmes = getFilmes().split(","); 
    StringBuilder recomendacoes = new StringBuilder();
    
    for (int filmeIndex = 0; filmeIndex < filmes.length; filmeIndex++) {
        if (avaliacoes.get(usuarioIndex)[filmeIndex][0] == 0) {
            double menorDistancia = Double.MAX_VALUE;
            int usuarioSimilar = -1;
            
            for (int i = 0; i < avaliacoes.size(); i++) {
                if (i != usuarioIndex) {
                    double distancia = calcularDistancia(usuarioIndex, i);
                    if (distancia < menorDistancia) {
                        menorDistancia = distancia;
                        usuarioSimilar = i;
                    }
                }
            }
            
            if (avaliacoes.get(usuarioSimilar)[filmeIndex][0] >= 2) {
                recomendacoes.append(usuarios[usuarioSimilar]).append(" recomenda o filme '").append(filmes[filmeIndex]).append("'").append("\n");
            }
        }
    }
    
    return recomendacoes.toString();
}



    public String getUsuarios() {
        return String.join(",", usuarios);
    }

    public String getFilmes() {
        return String.join(",", filmes);
    }

}
