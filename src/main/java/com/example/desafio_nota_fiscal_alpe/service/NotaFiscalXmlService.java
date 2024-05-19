package com.example.desafio_nota_fiscal_alpe.service;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.desafio_nota_fiscal_alpe.domain.model.Nfe;

@Service
public class NotaFiscalXmlService {
	
	public Nfe salvarNotaFiscalXml(MultipartFile file) {
		try (InputStream inputStream = file.getInputStream()) {
            JAXBContext context = JAXBContext.newInstance(Nfe.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            return (Nfe) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
