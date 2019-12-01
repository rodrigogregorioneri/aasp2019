package com.hackathon.aasp.controller;

import com.hackathon.aasp.business.ProfissionalBusiness;
import com.hackathon.aasp.model.Mensagem;
import com.hackathon.aasp.model.Profissional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalBusiness profissionalBusiness;


    @PostMapping
    public Profissional createProfissional(@RequestBody  Profissional profissional){
           return profissionalBusiness.createProfissional(profissional);
    }

    @GetMapping
    public List<Profissional> listProfissional(){
        return profissionalBusiness.listProfissional();
    }

    @GetMapping("/findProfessional/{id}")
    public Profissional findByProfissional(@PathVariable(name = "id", required = true) String id){
        return profissionalBusiness.findProfissional(id);
    }

    @PutMapping("/rate/{id}/{rate}")
    public void rate(@PathVariable(name = "id", required = true) String id, @PathVariable(name = "rate", required = true) int rate){
       profissionalBusiness.rate(id,rate);
    }

    @PostMapping("/send/{id}")
    public void send(@PathVariable(name = "id", required = true) String id, @RequestBody Mensagem mensagem){
        System.out.println(mensagem);
        profissionalBusiness.sendMessage(id, mensagem.getType()+","+mensagem.getNome()+","+mensagem.getMensagem() );
    }

    @GetMapping("/listmessage/{id}")
    public List<String> listMensagens(@PathVariable(name = "id", required = true) String id){
        return profissionalBusiness.listMessage(id);
    }
}
