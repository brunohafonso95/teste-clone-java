<img style="width: 10%; float: right; padding-top: 13px;" src="file:///C:\Users\bhenriquea\Desktop\novo-archetype\documentation\images\logo.png" alt="Logo" title="Logo"/>
### BasicCommandWeb (classe) 
---

Classe responsável por por conter comandos que executam interações em páginas web. Os métodos contidos na classe são todos públicos e para utiliza-los, não é necessário passar o WebDriver como parametro. 
### BasicCommandWeb (construtor) 
---

Método construtor da classe. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**WebDriver**</code> driver


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### mudarAba 
---

Método resposanvel por mudar a aba atual do navegador recebe um <code>**int**</code> como parâmetro, as abas são lidas em um array dessa forma, são zero indexadas, ou seja, os números passados como parâmetros vão de 0 à quantidade de abas abertas no momento menos 1. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> indiceAba


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.mudarAba(0);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### trocarJanela 
---

Método responsável trocar a janela ativa do navegador que recebe uma <code>**String**</code> como parâmetro, as janelas são lidas em um array dessa forma, são zero indexadas, ou seja, os números passados vão de 0 à quantidade de janelas abertas no momento menos 1. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.trocarJanela("elemento");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### encontra 
---

Método responsável por encontrar um elemento no navegador, o método recebe uma <code>**String**</code> como parâmetro e busca o elementro através dos seguintes seletores <code>**id**</code>, <code>**name**</code>, <code>**tagName**</code>, <code>**cssSelector**</code>, <code>**linkText**</code>, <code>**partialLinkText**</code>, <code>**xpath**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.encontra("elemento");
```

> <span style="color: green;">**Retorno**</span>: <code> **WebElement** </code> método retorna o elemento buscado, caso o mesmo exista na página.


### borda 
---

Método responsável por localizar um elemento no navegador e destacar o mesmo com um borda vermelha para exibir qual fluxo ou ação está sendo realizado, recebe um <code>**WebElement**</code> como parâmetro. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**WebElement**</code> elemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
WebElement menuLink = comBasico.findElement(By.id("menu-link"));
comBasico.borda(menuLink);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### elementoExiste 
---

Método responsável por validar se um elemento existe no *DOM* (Document Object Model), recebe uma <code>**String**</code> como parâmetro que é o seletor do elemento. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.elementoExiste("menu-link");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### elementoEstaHabilitado 
---

Método responsável por validar se um elemento está habilitado, recebe uma <code>**String**</code> como parâmetro que é o seletor do elemento. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.elementoEstaHabilitado("menu-link");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### escrever 
---

Método responsável por escrever em elementos que permitam a entrada de dados, recebe 2 parâmetrosdo tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.escrever("input-exemplo", "texto de exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### limpar 
---

Método responsável por limpar um elemnto que recebe entrada de dados, recebe um parâmetro do tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.limpar("input-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### clicar 
---

Método responsável por clicar em um elemento, recebe um parâmetro do tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.clicar("exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### clicarElementos 
---

Método responsável por clicar em todos os elementos das lista de elementos passada como parâmetro. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**List <String>**</code> seletorElementos


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
List String elementos = Arrays.asList("elemento1","elemento2");
comBasico.clicarElementos(elementos);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### verificarSeRadioEstaMarcado 
---

Método responsável por verificar se um elemento do tipo radio está selecionado recebe uma <code>**String**</code> como parâmetro. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.verificarSeRadioEstaMarcado("elemento");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### obterTexto 
---

Método responsável por obter o texto de um elemento recebe uma <code>**String**</code> como parâmetro. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.obterTexto("elemento");
```

> <span style="color: green;">**Retorno**</span>: <code> **String** </code> método retorna o texto obtido do elemento, caso o mesmo seja encontrado.


### limparValorComBackspace 
---

Método responsável por limpar um elemento que recebe entrada de dados mas como se fosse um usuário usando a tecla backspace recebe um <code>**WebElement**</code> como parâmetro. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**WebElement**</code> elemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
WebElement elemento = comBasico.encontra("elemento");
comBasico.verificarSeRadioEstaMarcado(elemento);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### limlimparCampopar 
---

Método responsável por limpar um elemnto que recebe entrada de dados, recebe um parâmetro do tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.limpar("input-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### pegarValorCss 
---

Método responsável por pegar o valor de uma propriedade CSS de um determinado elemento, recebe 2 parâmetros do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> elementoCss


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.pegarValorCss("elemento-exemplo", "color");
```

> <span style="color: green;">**Retorno**</span>: <code> **String** </code> método retorna o valor do atrituto CSS buscado.


### obterValorDoElementoAttribute 
---

Método responsável por pegar o valor de uma propriedade de um determinado elemento, recebe 2 parâmetros do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> attribute


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.obterValorDoElementoAttribute("elemento-exemplo", "value");
```

> <span style="color: green;">**Retorno**</span>: <code> **String** </code> método retorna o valor do atrituto buscado.


### verificarSeOcheckBoxEstaMarcado 
---

Método responsável por verificar se um checkbox está marcado recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.verificarSeOcheckBoxEstaMarcado("elemento-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **boolean** </code> método retorna **true** caso o elemento esteja marcado e **false** caso negativo.


### abrirUrl 
---

Método responsável por abrir uma determinada url, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> url


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.abrirUrl("https://www.google.com.br");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### navegarUrl 
---

Método responsável por navegar até uma determinada url, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> url


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.navegarUrl("https://www.google.com.br");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### validarTituloDoBrowser 
---

Método responsável por validar o titulo browser, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> tituloPagina


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.validarTituloDoBrowser("Google");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### validaTexto 
---

Método responsável por validar o o texto de um determinado elemento, recebe um parâmetro do tipo <code>**String**</code> e uma parâmetro do tipo <code>**WebElement**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**WebElement**</code> elemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
WebElement elemento = comBasico.encontra("elemento-exemplo");
comBasico.validaTexto(elemento, "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### validarUrlAtual 
---

Método responsável por validar a url atual, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> url


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.validarUrlAtual("https://www.google.com.br");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### selecionarComboPorTextoVisivel 
---

Método responsável por selecionar uma opção com combobox através do texto visivel, recebe 2 parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> valor


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.selecionarComboPorTextoVisivel("elemento-exemplo", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### obterTextoDaPrimeiraPosicaoDoCombo 
---

Método responsável por retornar o texto de primeira opção de um combobox através do texto visivel, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.obterTextoDaPrimeiraPosicaoDoCombo("elemento-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **String** </code> método retorna o texto da primeira opção de um combobox.


### obterQuantidadeOpcoesCombo 
---

método reponsável por retornar a quantidade de opções de um combobox, recebe uma <code>**String**</code> como parâmetro. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.obterQuantidadeOpcoesCombo("elemento-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **int** </code> método retorna a quantidade de opções do combobox


### verificarSeExisteOpcaoNoSelect 
---

método reponsável por verificar se existe uma opção no combobox, recebe 2 parâmetros do tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.verificarSeExisteOpcaoNoSelect("elemento-exemplo", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno


### desmarcarComboPorTextoVisivel 
---

método responsável por desmarcar um combobox através do texto que está visivel, o mesmo recebe 2 parâmetros do tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> valor


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.desmarcarComboPorTextoVisivel("elemento-exemplo", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### obterTextosCombo 
---

método reponsável por retornar uma lista com o texto das opções presentes em um combobox, recebe uma <code>**String**</code> como parâmetro. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.obterTextosCombo("elemento-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **List<String>** </code> método uma lista do tipo <code>**String**</code> com o texto das opções do combobox


### envia 
---

método responsável por dar um submit num formulário, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.envia("elemento-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### obterTodasAsOpcoesSelecionadasNoCombo 
---

método responsável por obter todas as opções selecionadas no combobox, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.obterTodasAsOpcoesSelecionadasNoCombo("elemento-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **List<String>** </code> método retorna uma lista do tipo <code>**String**</code> com todas as opções selecionadas num combobox.


### entrarFrame 
---

método Responsável por alterar o contexto da página para o contexto do iframe, recebe uma parâmetro do tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.entrarFrame("elemento-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### sairFrame 
---

método Responsável por alterar o contexto do iframe para o contexto da página, não recebe parâmetro. 

Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.sairFrame();
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### aceitarAlerta 
---

método responsável por aceitar um window.alert, não recebe parâmetro. 

Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.aceitarAlerta();
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### obterTextoDoAlerta 
---

método responsável por obter o texto de um window.alert, não recebe parâmetro. 

Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.obterTextoDoAlerta();
```

> <span style="color: green;">**Retorno**</span>: <code> **String** </code> método retorna o texto do window.alert.


### negarAlerta 
---

método responsável por negar um window.alert, não recebe parâmetro. 

Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.negarAlerta();
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### escreverNoAlerta 
---

método responsável por inserir um determinado texto em um window.alert, recebe um parâmetro do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> conteudo


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.escreverNoAlerta("texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### esperarElemento 
---

método responsável por esperar de forma explicita até que um elemento passe a existir recebe um parâmetro do tipo <code>**String**</code> e um parâmetro do tipo <code>**int**</code. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> tempo


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.esperarElemento("elemento-exemplo", 10);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### esperarCarregar 
---

método responsável por esperar de forma explicita até que um elemento seja carregado recebe 2 parâmetros do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.esperarCarregar("elemento-exemplo", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### esperarSerInvisivel 
---

método responsável por esperar de forma explicita até que um elemento esteja invisivel recebe um parâmetros do tipo <code>**String**</code> e um parâmetro do tipo <code>int</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> tempo


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.esperarSerInvisivel("elemento-exemplo", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### esperarElementoSerVisivel 
---

método responsável por esperar de forma explicita até que um elemento esteja visivel recebe um parâmetros do tipo <code>**String**</code> e um parâmetro do tipo <code>int</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> tempo


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.esperarElementoSerVisivel("elemento-exemplo", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### navega 
---

método responsável por navegar até uma determinada página, recebe um parâmetro do tipo <code>**String**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> url


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.navega("https://www.google.com.br");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### navega 
---

método responsável por encerrar o navegador, não recebe parâmetro. 

Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.encerra();
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### navega 
---

método responsável por encerrar o navegador, não recebe parâmetro. 

Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.encerra();
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### clicarPorTexto 
---

método responsável por clicar em um elemento através do texto, tag e seletor de um elemento, recebe 3 parâmetros do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> tag

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.clicarPorTexto("exemplo-teste", "h1", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### rolarParaBaixo 
---

método responsável por mover o scroll para baixo até um determinado ponto da página, recebe um parâmetro do tipo <code>**int**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> posicao


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.rolarParaBaixo(100);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### rolarParaCima 
---

método responsável por mover o scroll para cima até um determinado ponto da página, recebe um parâmetro do tipo <code>**int**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**int**</code> posicao


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.rolarParaCima(100);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### moverParaOelemento 
---

método responsável por mover o scroll da página até um determinado elemento na página usando javascript, recebe um parâmetro do tipo <code>**By**</code> 
> <span style="color: blue;">**Parâmetro**</span>: <code>**By**</code> seletorElemento


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.moverParaOelemento("exemplo-teste");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### escrever 
---

método responsável por escrever em um elemento que recebe entrada de dados usando javascript, recebe 2 parâmetros um do tipo <code>**By**</code> e um do tipo <code>**String**</code>. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**By**</code> seletorElemento

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> texto


Ex:
```java
BasicCommandWeb comBasico = new BasicCommandWeb(driver);
comBasico.escrever("exemplo-teste", "texto-exemplo");
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


