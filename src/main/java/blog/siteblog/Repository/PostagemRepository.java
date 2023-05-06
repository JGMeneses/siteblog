package blog.siteblog.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import blog.siteblog.Model.Postagem;

@Repository
public class PostagemRepository {
    List<Postagem> posts = new ArrayList<>();


    public void doInit(){
        Postagem p1 = new Postagem(0,"Boa tarde", "Jotta");
        Postagem p2 = new Postagem(0,"Boa noite", "jottinha");
        Postagem p3 = new Postagem(0,"Bom sabado", "Jaum");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }

    public List<Postagem> listAll(){
        return posts;
    }

    public void save(Postagem p){
        posts.add(p);
    }

    public void update(Postagem p){
        posts.remove(p);
        posts.add(p);
    }

}
