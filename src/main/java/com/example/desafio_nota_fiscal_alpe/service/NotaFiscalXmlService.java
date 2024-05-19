package com.example.desafio_nota_fiscal_alpe.service;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.desafio_nota_fiscal_alpe.domain.dto.NotaFiscalDTO;
import com.example.desafio_nota_fiscal_alpe.domain.model.Nfe;
import com.example.desafio_nota_fiscal_alpe.domain.vo.NotaFiscalVO;
import com.example.desafio_nota_fiscal_alpe.utils.NotaFiscalUtils;

@Service
public class NotaFiscalXmlService {
	
	@Autowired
	private NotaFiscalServiceImpl notaFiscalServiceImpl;
	@Autowired
	private NotaFiscalUtils notaFiscalUtils;
	
	public Nfe listarNotaFiscalXml(MultipartFile file) {
		try (InputStream inputStream = file.getInputStream()) {
            JAXBContext context = JAXBContext.newInstance(Nfe.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            Nfe notaXml = (Nfe) unmarshaller.unmarshal(inputStream);
            
            return notaXml;
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public NotaFiscalDTO salvarNotaFiscalXml(MultipartFile file) {
		try (InputStream inputStream = file.getInputStream()) {
            JAXBContext context = JAXBContext.newInstance(Nfe.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            Nfe notaXml = (Nfe) unmarshaller.unmarshal(inputStream);
            
            NotaFiscalVO nota = notaFiscalUtils.modelToVo(notaXml);
            
            return notaFiscalServiceImpl.salvarNotaFiscal(nota);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
