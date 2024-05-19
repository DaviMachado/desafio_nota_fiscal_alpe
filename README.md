![ícone_Alpe](./img_readme/favicon.ico)  

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

Nessa primeira solução, será pressupondo que seja enviado um _**JSON**_ para o microserviço de Notas Fiscais, o mesmo será validado no orgão do Governo (_mock_), em seguida salvo na base de dados, e por fim, enviado para outro microserviço de Cobrança (_mock_) - (**OBS**: se a nota Fiscal for paga como Boleto).

![img_solucao1](./img_readme/solucao1.jpg) 

- Passo a Passo para executar o projeto:
1. Clonar o projeto através do [link.](https://github.com/DaviMachado/desafio_nota_fiscal_alpe)


2. Em seguida, será necessario executar o comando _"docker-compose up -d"_ dentro do diretorio do projeto clonado acima. (**OBS**: É necessario executar esse comando para subir os containers do SqlServer e do Kafka).

![imagem2](./img_readme/img2.png) 
![imagem2.1](./img_readme/img2.1.png) 


3. Na sequência, será necesario criar as tabelas _**CLIENTE**_ e _**NOTA_FISCAL**_ no banco de dados. 

(**OBS**: Também será necessario realizar o **INSERT** do cliente, para prosseguir com os proximos passos).

![imagem3](./img_readme/img3.png) 

4. Agora será necessário subir o microserviço que foi clonado na etapa 1.

![imagem4](./img_readme/img4.png)  


5. Com o microserviço em execução, será necessario realizar o login para recuperar o token JWT, através do enpoint _http://localhost:3030/alpe/login_ 
(o login terá que ser com o mesmo cliente que foi realizado o **INSERT** na etapa 3).

![imagem5](./img_readme/img5.png) 

6. Com o token gerado, será necesario adicionar esse token na aba "_Authorization_" nas proximas requisições.

![imagem6](./img_readme/img6.png) 

- Agora é só salvar a Nota Fiscal através do endpoint _http://localhost:3030/alpe/nota-fiscal_.

![imagem6.1](./img_readme/img6.1.png) 


7. O microserviço irá apresentar alguns logs, e um deles é o log do envio da Nota Fiscal para outro microserviço de Cobrança (_mock_), através do Kafka.

![imagem7](./img_readme/img7.png)


8. Por fim, a cobertura dos testes unitarios ficou em **79,9%** no _Coverage_.

![imagem8](./img_readme/img8.png) 

___
___
## SOLUÇÂO 2: XML (**Implementado**)


Nessa segunda solução, será pressupondo que seja enviado um arquivo _**XML**_ para o microserviço de Notas Fiscais, o mesmo será validado no orgão do Governo (_mock_), em seguida salvo na base de dados e por fim, enviado para outro microserviço de Cobrança (_mock_) - (**OBS**: se a nota Fiscal for paga como Boleto).

![solucao2](./img_readme/solucao2.jpg)


- Passo a Passo:

1. Realizar o **login** conforme explicação acima e inserir o arquivo **XML** no seguinte endpoint _http://localhost:3030/alpe/nota-fiscal/upload-xml_ (arquivo **XML** encontra-se anexado dentro da pasta _"postman->xml"_ no projeto).

![imagem9](./img_readme/img9.png)

2. Ao executar esse endpoint _http://localhost:3030/alpe/nota-fiscal/upload-xml_, ele irá **desserializar** o arquivo **XML**, e salvar no banco de dados.

![imagem10](./img_readme/img10.png)

![imagem11](./img_readme/img11.png)

- **OBS**: O formato do arquivo **XML** segue o padrão que foi utilizado no teste (imagem abaixo), qualquer outro tipo de **XML** utilizado, irá apresentar erro.

![imagem12](./img_readme/img12.png)

___
___
## SOLUÇÂO 3: S3 (**Não Implementado**)

![solucao3](./img_readme/solucao3.jpg) 
