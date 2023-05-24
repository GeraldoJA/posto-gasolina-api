# posto-gasolina-api

Projeto para exame técnico Java da Logus Tecnologia

## Explicação do projeto
https://www.youtube.com/watch?v=Qkq_JTJjoAQ

## Configuração do projeto no Spring Tools ou Eclipse
 O projeto reseta para Java 1.5 sempre que compila.
Issa gera erro na função lambda do orElseThrow dos métodos finById.
 para corrigir o problema deve configurar o projeto para rodar no mínimo com Java 1.8.
* botão direito no projeto -> propriedades -> 
  * Java Build Path -> Aba Libraries -> clique duplo na JRE -> seleciona JDK 1.8 ou superior
  * Java Compiler -> Compiler complience leve: seleciona 1.8 ou superior

## Enunciado do desafio

* Utilizar os 2 arquivos citados na questão 2 que se encontra na área de trabalho(Desktop);
* Na área de trabalho do computador, há o arquivo Orientações.txt, use-o;
* Não há limite de tempo;
* Após o término, o projeto Exercicio1 para o email : xxx e xxx ; (obs: ver em minhas anotações)
* Pode utilizar a internet;
* Será avaliado os seguintes itens:
  * Documentação
  * Alta coesão
  * Baixo acoplamento
  * Manutenabilidade:
---------------------------
* Incluir novo modelo de veículo 
* Incluir novo tipo de combustível
* Incluir nova bomba de combustível
* Mudança critério enfileiramento
---------------------------

Avaliação para Desenvolvedor Java
1. Um posto de gasolina com duas bombas abastecedoras independentes, uma de álcool e outra de gasolina, recebe veículos de diversas naturezas. Os veículos adentram ao posto em fila única, sendo direcionados para filas individuais das bombas de abastecimento. Cada veículo pode utilizar um ou mais tipos de combustível.
Crie um programa que simule o abastecimento de uma lista de veículos informados no arquivo fornecido, realizando o abastecimento apropriado de cada veículo. Pressupondo que todos os veículos estão com tanque vazio e os terão completados, e minimizando a razão preço/km rodado ao realizar o direcionamento dos veículos para as bombas, a saída deve ser produzida na ordem cronológica dos eventos, no seguinte formato (os valores são ilustrativos):



### Resultado da simulação
---------------------------
...
* [00:05] Veículo modelo FIAT-UNO, placa JGA-7389 foi abastecido com 48 litros de ETANOL.
* [00:10] Veículo modelo AUDI-A4, placa JGB-1234 foi abastecido com 65 litros de GASOLINA.
...
--------------------------

### Resumo da simulação
* Total abastecido na bomba 1 (GASOLINA): 1517 litros
* Total abastecido na bomba 2 (ETANOL): 1125 litros
* Total geral abastecido de GASOLINA: 1517 litros
* Total abastecido de ETANOL: 1125 litros

* Informações adicionais:
  * O preço do litro da GASOLINA é R$ 2,90
  * O preço do litro do ETANOL é R$ 2,27
  * Velocidade de abastecimento da bomba de gasolina: 10 litros / minuto
  * Velocidade de abastecimento da bomba de álcool: 12 litros /minuto
  * Privilegie baixo acoplamento e alta coesão na solução proposta, minimizando impactos no caso de alterações nas definições do problema.
