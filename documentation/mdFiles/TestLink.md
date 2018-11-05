### TestLink (classe) 
---

Classe responsável pela comunicação via rest com o TestLink. 
### TestLink (construtor) 
---

Responsável por criar um objeto que se conecta ao TestLink 

Ex:
```java
TestLink testLink = new TestLink();
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não tem retorno.


### obtemProjetoPorNome 
---

Responsável por obter o projeto com base no nome. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> nomeProjeto


Ex:
```java
testLink.obtemProjetoPorNome("TESTES INDRA 2018");
```

> <span style="color: green;">**Retorno**</span>: <code> **TestProject** </code> Método retorna um objeto do tipo TestProject


### obtemSuitesDeTestes 
---

Obtem as suites de testes com base no Id de um projeto encontrado. 
> <span style="color: blue;">**Parâmetro**</span>: <code>**TestProject**</code> projeto


Ex:
```java
testLink.obtemSuitesDeTestes(projeto);
```

> <span style="color: green;">**Retorno**</span>: <code> **TestSuite[]** </code> Retorna um array de suites de testes.


### obtemTestesCases 
---

Obtem os Test Cases a partir de uma determinada Suite de Testes 
> <span style="color: blue;">**Parâmetro**</span>: <code>**TestSuite**</code> teste


Ex:
```java
testLink.obtemTestesCases(testSuite);
```

> <span style="color: green;">**Retorno**</span>: <code> **TestCase[]** </code> um array com os casos de testes.


### obtemStepsTratarParaconteudoGherkin 
---

Apos receber os steps este método trata os textos para que possam ser escritos no formato scenarios 
> <span style="color: blue;">**Parâmetro**</span>: <code>**List<TestCaseStep>**</code> steps


Ex:
```java
testLink.obtemStepsTratarParaconteudoGherkin(listaSteps);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não possui retorno.


### escreveFeatures 
---

Este método criará os arquivos ".feature" já na pasta "src/test/resources". Não deve ser usado de forma direta. Deve ser usado dentro de outro método capaz de buscar os casos de Testes do TestLink. 

Ex:
```java
escreveFeature();
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> método não possui retorno.


### gerarTodosOsscenariossDoProjeto 
---

Método responsável por acessar um projeto e obter todos os casos de testes, passando por todos os nível (suites, test cases, etc). 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> nomeDoProjeto


Ex:
```java
testLink.gerarTodosOsscenariossDoProjeto(projeto);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> Embora não possua retorno, este método gerará os arquivos ".feature" nas suas respectivas pastas..


### gerarTodosOsscenariossDoProjeto 
---

Método responsável por acessar um projeto e obter todos os casos de testes com base numa suite especifica, passando por todos os nível (suites, test cases, etc). 
> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> nomeDoProjeto

> <span style="color: blue;">**Parâmetro**</span>: <code>**String**</code> suiteEspecificada


Ex:
```java
testLink.gerarscenariosAPartirDeUmaSuite(projeto);
```

> <span style="color: green;">**Retorno**</span>: <code> **void** </code> Embora não possua retorno, este método gerará os arquivos ".feature" nas suas respectivas pastas.


