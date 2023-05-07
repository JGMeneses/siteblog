package blog.siteblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import blog.siteblog.Model.Postagem;
import blog.siteblog.Repository.PostagemRepository;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class PostController {
    
    PostagemRepository repository;

    public PostController(PostagemRepository repository){
        this.repository = repository;
        this.repository.doInit();
    }


    @RequestMapping(value = {"/","/posts"},method = RequestMethod.GET)
    public String doGet(Model model, HttpServletRequest request){
        model.addAttribute("posts", repository.listAll());
        return "index";
        
    }

    @RequestMapping(value = "/formCadastro", method = RequestMethod.GET)
    public String doFormPage(Model model){

        Postagem p = new Postagem("NovaPostagem", "NovoAutor");
        model.addAttribute("postagem", p);
        return "formCadastro";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String doSalvarPostagem(@ModelAttribute Postagem p){
        repository.save(p);
        return "redirect:/";
    }

    @RequestMapping(value = "/formEditar/{id}", method = RequestMethod.GET)
    public String doEditarPage(Model model, @PathVariable(name = "id") Integer id){
        
        Postagem p = repository.listAll().get(id);
        model.addAttribute("postagem", p);
        return "formEditar";
    }

    @RequestMapping(value = "/salvarEdit", method = RequestMethod.POST)
    public String doSalvarEditPostagem(@ModelAttribute Postagem p){
        repository.update(p);
        return "redirect:/";
    }
}
