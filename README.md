# posto-gasolina-api

## Configuração do projeto no Spring Tools ou Eclipse
 O projeto reseta para Java 1.5 sempre que compila.
Issa gera erro na função lambda do orElseThrow dos métodos finById.
 para corrigir o problema deve configurar o projeto para rodar no mínimo com Java 1.8.
* botão direito no projeto -> propriedades -> 
  * Java Build Path -> Aba Libraries -> clique duplo na JRE -> seleciona JDK 1.8 ou superior
  * Java Compiler -> Compiler complience leve: seleciona 1.8 ou superior
