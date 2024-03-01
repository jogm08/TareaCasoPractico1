package com.practica01.Controller;


import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import com.practica01.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/categoria")
public class ArbolController {
  
    @Autowired
    private ArbolService arbolService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var arboles = arbolService.getArbol(false);
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalArboles",arboles.size());
        return "/arbol/listado";
    }
    
     @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arbol", 
                            arbol.getId_arbol()));
        }
        arbolService.save(arbol);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{id_arbol}")
    public String categoriaEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }   
}