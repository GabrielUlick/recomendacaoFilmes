Tarefa Avaliativa (Semana 03) Aplicação Distribuída com API Java UDP.

Trabalho em dupla. Envio de arquivo compactado com projeto Java (apenas um envio por dupla). Apresentação da solução no laboratório 28-08-2023. Implemente um sistema de recomendação distribuído usando a API Java UDP para a comunicação entre clientes e servidor.

O referido sistema deverá fazer recomendações de filmes com base na avaliação de seus próprios usuários.

As avaliações deverão ser armazenadas na memória principal de um a classe no lado do servidor em uma matriz de inteiros com 10 linhas por 20 colunas.

As linhas devem fazer referência aos usuários existentes (no máximo 10) e as colunas devem indicar os filmes avaliados por estes usuários (no máximo 20).

Inicialmente, cada célula dessa matriz de avaliações receberá o valor 0 (zero) indicando que o filme ainda não foi avaliado pelo usuário.

O usuário poderá alterar essa avaliação para:

1 = ruim 2 = bom 3 = ótimo Os nomes de usuários e títulos de filmes ou séries podem ser livremente escolhidos pela dupla em tempo de projeto.

A interface do usuário (do lado do cliente) pode enviar um conjunto de requisições para o servidor na forma de pequenos strings segmentados por ponto-e-vírgulas. Tais requisições podem ser:

"1; nome-usuário" : solicita ao servidor um título de filme para a avaliação. Deve ser um filme ainda não avaliado peko usuário (com nota zero). "2; nome-usuário; título-do-filme; nota": registra a nota de avaliação do usuário (de 0, significando que não conhece o filme, até 3) para um filme específico. "3; nome-usuário": Solicita ao servidor uma recomendação de filme ou série. "4; nome-usuário": Solicita lista de avaliações feitas pelo próprio usuário. Para efetuar as recomendações a aplicação deverá comparar as avaliações do usuário em questão com as avaliações feitas por outros usuários. Empregue a fórmula da distância euclidiana.

Exemplo:

Zé avaliou o filme "Tempos Modernos" com 3; Ana avaliou o filme "Tempos Modernos" com 2; Martha avaliou o filme "Tempos Modernos" com 1; Zé avaliou o filme "Star Wars" com 0; Ana avaliou o filme "Star Wars" com 2; Martha avaliou o filme "Star Wars" com 3. Supondo que existam apenas esses filmes e usuários...

Comparando Zé com Ana:

Raiz( quadrado(3 - 2) + quadrado(0 - 2)) =

Raiz( 1 + 4 ) = Raiz( 5 ) = 2,2361

Comparando Zé com Martha:

Raiz(quadrado(3 -1) + quadrado(0 - 3)) =

Raiz( 4 + 9) = Raiz (13) = 3,6056

Portanto, a distância entre Zé e Ana é de 2,23 e a distância entre Zé e Martha é 3,61.

Portanto, Ana está mais próxima de Zé do que Martha.

Ocorre que Zé não conhece ou não avaliou "Star Wars". Ana avaliou este filme como "Bom" (nota 2). Então o sistema pode recomendar o "Star Wars" para o Zé.

Afinal, Ana - a usuário mais parecida ou semelhante em termos de gostos ou preferências de filmes em relação ao Zé - avaliou bem um filme que o Zé não conhece (ou simplesmente não avaliou ainda).
