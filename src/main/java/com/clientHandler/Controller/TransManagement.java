package com.clientHandler.Controller;
import com.clientHandler.Entity.TransMang;
import com.clientHandler.Service.TransitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/transition")
public class TransManagement {
    @Autowired
    private TransitionService transitionService;

    @PostMapping("/addTransition")
    public TransMang createTransition (@RequestBody TransMang ts){
        return this.transitionService.createTransition(ts);
    }

    @GetMapping("/transitionByName/{names}")
    public List<TransMang> getAllTransition(@PathVariable("names") String names ){
        List<TransMang> list = this.transitionService.getTransitionByName(names);
        return list ;
    }

    @PutMapping("/updateTransition/{id}")
    public TransMang updateTransition(@PathVariable("id") int id ,@RequestBody TransMang transMang){
        return this.transitionService.updateTransition(id,transMang);
    }

    @GetMapping("/starts/{name}")
    public List<TransMang>  startsNames(@PathVariable("name") String name)
    {
        return this.transitionService.startsNames(name);
    }
    @GetMapping("/starts/p/{id}")
    public TransMang getAllCST (@PathVariable("id") int id ){
        return this.transitionService.getAllCST(id);
    }


    @DeleteMapping("/delete/{name}")
    public String  deleteTrans (@PathVariable("name") String name){
        this.transitionService.deleteTrans(name);
        return "deleted successfullY";
    }


    @GetMapping("/getTransition/{name}")
    public List<TransMang> getTransition(@PathVariable("name") String name){
        return this.transitionService.getTransition(name);
    }

//
}
