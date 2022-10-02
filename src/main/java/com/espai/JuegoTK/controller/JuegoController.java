package com.espai.JuegoTK.controller;
import com.espai.JuegoTK.persistence.entity.Estado;
import com.espai.JuegoTK.persistence.entity.Genero;
import com.espai.JuegoTK.persistence.entity.Juego;
import com.espai.JuegoTK.persistence.entity.Plataforma;
import com.espai.JuegoTK.service.IEstadoService;
import com.espai.JuegoTK.service.IGeneroService;
import com.espai.JuegoTK.service.IPlataformaService;
import com.espai.JuegoTK.service.JuegoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/views/juegos")
public class JuegoController {

    @Autowired
    private JuegoServiceImpl juegoService;
    @Autowired
    private IEstadoService estadoService;
    @Autowired
    private IGeneroService generoService;
    @Autowired
    private IPlataformaService plataformaService;

    @GetMapping("/")
    public String listarJuegos(Model model){

        List<Juego> listadoJuegos = juegoService.listarTodos();

        model.addAttribute("titulo","Listado de juegos");
        model.addAttribute("juegos",listadoJuegos);

        return "views/juegos/listar";
    }

    @GetMapping("/pruebas")
    public String pruebas(){
            return "/views/juegos/frmPrueba";
    }

    @GetMapping("/create")
    public String crear(Model model){

        Juego juego = new Juego();
        List<Estado> listaEstados = estadoService.listaEstados();
        List<Plataforma> listaPlataformas = plataformaService.listaPlataformas();
        List<Genero> listaGeneros = generoService.listaGeneros();


        model.addAttribute("titulo","Formulario: Nuevo Juego");
        model.addAttribute("juego",juego);
        model.addAttribute("estados",listaEstados);
        model.addAttribute("plataformas",listaPlataformas);
        model.addAttribute("generos",listaGeneros);

        return "/views/juegos/frmCrear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Juego juego, BindingResult result, Model model){

        List<Estado> listaEstados = estadoService.listaEstados();
        List<Plataforma> listaPlataformas = plataformaService.listaPlataformas();
        List<Genero> listaGeneros = generoService.listaGeneros();

        if(result.hasErrors()){


            model.addAttribute("titulo","Formulario: Nuevo Juego");
            model.addAttribute("juego",juego);
            model.addAttribute("estados",listaEstados);
            model.addAttribute("plataformas",listaPlataformas);
            model.addAttribute("generos",listaGeneros);
            System.out.println("Se han detectado errores en el formulario");
            return "/views/juegos/frmCrear";

        }

        juegoService.guardar(juego);
        System.out.println("Juego guardado con exito!");
        return "redirect:/views/juegos/";
    }

 @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer idCliente, Model model){

        Juego juego = juegoService.buscarPorId(idCliente);
        List<Estado> listaEstados = estadoService.listaEstados();
        List<Plataforma> listaPlataformas = plataformaService.listaPlataformas();
        List<Genero> listaGeneros = generoService.listaGeneros();


        model.addAttribute("titulo","Formulario: Editar Juego");
        model.addAttribute("juego",juego);
        model.addAttribute("estados",listaEstados);
        model.addAttribute("plataformas",listaPlataformas);
        model.addAttribute("generos",listaGeneros);

        return "/views/juegos/frmCrear";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Integer idCliente){

        juegoService.eliminar(idCliente);
        System.out.println("El registro ha sido eliminado con exito.");

        return "redirect:/views/juegos/";
    }

}
