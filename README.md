# Microservice

# Necessario

- JDK 11
- Docker Engine
- Maven

# Perguntas

1.	Qual é a sua estratégia para modernizar esse legado?

![alt text](https://github.com/ArtCouSan/pagamentos/blob/master/arquitetura.jpg)
 
2.	Escolha uma funcionalidade prioritária para modernizar.

Pagamentos - Boleto, verificacao de valor maximo para pagar

3.	Quais os critérios você adotou para priorizar a funcionalidade a ser modernizada?

Para principios de demonstracao um microservico mais simples, porem em ambiente profissional é definido por uso e criticidade.

4.	Quais seriam os requisitos imprescindíveis para essa funcionalidade?

Construcao de microservico e um desenho bem contruido de dominios

5.	Como será a convivência desta funcionalidade modernizada com o legado? (Visão técnica)

Criaria uma camada de abstracao para trafegar com o legado, seja microservicos proprios para isso

6.	Quais serão os fatores críticos para o sucesso da modernização dessa funcionalidade?
facilitar a implementação de novas features.

Desacoplar o maximo possivel os dominios de acordo com o desenho da arquitetura e de negocio

7.	Quais seriam as linguagem e tecnologias envolvidas na solução e por quê?

 Docker, Java e MongoDB

 - Java - Stack solicitada
 - Docker - Facilidade de deploy do ambiente em containers e imagens
 - MongoDB - Banco solicitado, alem de NoSQL, melhorando a perfomance de consulta nos dados
 - Jenkins - Esteira para CI/CD
 - Hadoop e MapReducer - Tratamento dos dados juntamento com processos
 - Projetos Netflix:
 - Hystrix: cuida da tolerancia de falhas e recuperacao
 - Eureka: Service Discovery
 - Zuul: API Gateway 
 - Ribbon: Load Balancing

8.	Como você irá armazenar esses dados (tecnologias e modelos)?

MongoDB

9.	Como a performance será otimizada de um jeito que ficará fácil de escalar?

Como é utilizado microservico, a arquitetura será propicia para escalonamento horizontal e melhorias

10.	Dado que é um projeto importantíssimo para a organização, como você faria para acelerar o desenvolvimento, entregando valor para o cliente em menor tempo?

Entenderia as prioridades do cliente, as classificaria e organizaria em entregas

# Docs

- http://localhost:8080/swagger-ui.html
