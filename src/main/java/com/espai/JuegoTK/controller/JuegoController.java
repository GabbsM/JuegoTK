package com.espai.JuegoTK.controller;
import com.espai.JuegoTK.client.model.GameDTO;
import com.espai.JuegoTK.model.Busqueda;
import com.espai.JuegoTK.model.JuegoFicha;
import com.espai.JuegoTK.persistence.entity.Estado;
import com.espai.JuegoTK.persistence.entity.Genero;
import com.espai.JuegoTK.persistence.entity.Juego;
import com.espai.JuegoTK.persistence.entity.Plataforma;
import com.espai.JuegoTK.persistence.repository.JuegoRepository;
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


    @GetMapping("/ficha/{id}")
    public String ficha(@PathVariable int id,Model model){

        JuegoFicha juegoFicha = juegoService.getJuego(id);
        model.addAttribute("juego",juegoFicha);


        return "/views/juegos/ficha";
    }

    @GetMapping("/create/{id}")
    public String crear(@PathVariable("id") int idApi, Model model){

        // con idApi, llamar a rawgapi y coger datos para rellenar Juego
        GameDTO gameDTO = juegoService.getApiGameById(idApi);

        Juego juego = new Juego();
        juego.setTitulo(gameDTO.getTitulo());
        juego.setApiId(gameDTO.getId());
        juego.setDesarrollador(null); // TODO: add developer to DTO
        // TODO: add fields to DTO and JUEGO
        List<Estado> listaEstados = estadoService.listaEstados();
        List<Plataforma> listaPlataformas = plataformaService.listaPlataformas();
        List<Genero> listaGeneros = generoService.listaGeneros();

        model.addAttribute("titulo","Formulario: " + gameDTO.getTitulo());
        model.addAttribute("juego",juego);
        model.addAttribute("estados",listaEstados);
        model.addAttribute("plataformas",listaPlataformas); // TODO: get plataformas from rawGapi
        model.addAttribute("generos",listaGeneros); // TODO: get plataformas from rawGapi

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

    @GetMapping("/search")
    public String buscar(@Valid @ModelAttribute Busqueda busqueda){
        // simplemente redirecciona a la pagina de busqueda inicial
        return "/views/juegos/apiSearch";
    }

    @PostMapping("/searchText")
    public String buscar(@Valid @ModelAttribute Busqueda busqueda, BindingResult result, Model model) {
        // TODO: call api with busqueda.titulo
        //  fill model juegos with JuegoDTO
        List<GameDTO> juegos = juegoService.searchGameByTitle(busqueda.getTitulo());
        model.addAttribute("juegos", juegos);
        return "/views/juegos/apiSearch";
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
