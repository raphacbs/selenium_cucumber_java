# encoding: iso-8859-1
@Pesquisa
Feature: Pesquisa
  I want to use this template for my feature file

  @Realizarpesquisa
  Scenario Outline: Realizar pesquisa
    Given Acessar o site
    And No campo de busca(LUPA), pesquisar por <textoPesquisado>
    When No resultado da busca, clicar no link <textoEsperado>
    Then Verificar se a modal foi aberta com a mensagem <textoEsperado>

    Examples: 
      | textoPesquisado | textoEsperado                                            |
      | "superget"      | "Já possuo uma máquina SuperGet, posso abrir uma conta?" |
      | "superget"      | "Como posso abrir uma conta SuperGet?"                   |
      | "superget"      | "Onde posso realizar saques com o meu Cartão SuperGet?"  |
