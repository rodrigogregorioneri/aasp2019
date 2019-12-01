package com.hackathon.aasp.business;

import com.hackathon.aasp.model.Mensagem;
import com.hackathon.aasp.model.Profissional;
import com.hackathon.aasp.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProfissionalBusiness {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional createProfissional(Profissional p){
        return profissionalRepository.save(p);
    }

    public List<Profissional> listProfissional(){
       return profissionalRepository.findAll();
    }

    public Profissional findProfissional(String id){
        return profissionalRepository.findById(id).get();
    }

    public void rate(String id, int rate){
      Profissional profissional =  profissionalRepository.findById(id).get();
      profissional.setEstrelas(rate);
      profissionalRepository.save(profissional);
    }

    public void sendMessage(String id, String mensagem){
        System.out.println(mensagem);
       Profissional profissional = profissionalRepository.findById(id).get();
       List<String> mensagens = profissional.getMensagens();
       mensagens.add(mensagem);
       System.out.println(mensagens.size());
       profissional.setMensagens(mensagens);
       profissionalRepository.save(profissional);
    }

    public List<String> listMessage(String id){
        Profissional profissional = profissionalRepository.findById(id).get();
        List<String> mensagens = profissional.getMensagens();
        return mensagens;

    }


}
