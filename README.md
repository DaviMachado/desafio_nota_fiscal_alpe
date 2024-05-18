![ícone_Alpe](./imagens readme/favicon.ico)  

# Desafio Técnico - Alpe  
### Tecnologias Utilizadas:
- Java
- Spring Boot
- Kafka
- SQLServer
- Docker
- JWT
___

## SOLUÇÂO 1: JSON (Implementado)

Nessa primeira solução, será pressupondo que seja enviado um _JSON_ para o microserviço de Notas Fiscais, o mesmo será validado no orgão do Governo (_mock_), em seguida salvo na base de dados, e por fim, enviado para outro microserviço de Cobrança (_mock_) - (**OBS**: se a nota Fiscal foi paga como Boleto).

![img_solucao1](./imagens readme/solucao1.jpg) 

- Passo a Passo para executar o projeto:
1. Clonar o projeto através do [link.](https://github.com/DaviMachado/desafio_nota_fiscal_alpe)


2. Em seguida, será necessario executar o comando _"docker-compose up -d"_ dentro do diretorio do projeto clonado acima. (**OBS**: É necessario executar esse comando para subir os containers do SqlServer e do Kafka).

![imagem2](./imagens readme/img2.png) 
![imagem2.1](./imagens readme/img2.1.png) 


3. Na sequência, será necesario criar as tabelas _**CLIENTE**_ e _**NOTA_FISCAL**_ no banco de dados. 

(**OBS**: Também será necessario realizar o **INSERT** do cliente, para prosseguir com os proximos passos).

![imagem3](./imagens readme/img3.png) 

4. Agora será necessário subir o microserviço que foi clonado na etapa 2.

![imagem4](./imagens readme/img4.png)  


5. Com o microserviço em execução, será necessario realizar o login para recuperar o token JWT, através do enpoint _http://localhost:3030/alpe/login_ 
(o login terá que ser com o mesmo cliente que foi realizado o **INSERT** na etapa 4).

![imagem5](./imagens readme/img5.png) 

6. Com o token gerado, será necesario adicionar esse token na aba "_Authorization_" nas proximas requisições.

![imagem6](./imagens readme/img6.png) 

- Agora é só salvar a Nota Fiscal através do endpoint _http://localhost:3030/alpe/nota-fiscal_.

![imagem6.1](./imagens readme/img6.1.png) 


7. O microserviço irá apresentar alguns logs, e um deles é o log do envio da Nota Fiscal para outro microserviço de Cobrança (_mock_), através do Kafka.

![imagem7](./imagens readme/img7.png)


8. Por fim, a cobertura dos testes unitarios ficou em **79,9%** no _Coverage_.

![imagem8](./imagens readme/img8.png) 

___
___
## SOLUÇÂO 2: XML (**Não Implementado**)

![solucao2](./imagens readme/solucao2.jpg) 
___
___
## SOLUÇÂO 3: XML (**Não Implementado**)

![solucao3](./imagens readme/solucao3.jpg) 