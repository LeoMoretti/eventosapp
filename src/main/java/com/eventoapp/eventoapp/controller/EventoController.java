package com.eventoapp.eventoapp.controller;
import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.GET) //Retorna o formulario
    public String form(){
        return "evento/formEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.POST) //Salva os dados no banco
    public String form(Evento evento){
        er.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @RequestMapping("/eventos") //Retorna lista eventos
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index.html"); //Retona à pagina Idex as informações do Banco
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }
}
