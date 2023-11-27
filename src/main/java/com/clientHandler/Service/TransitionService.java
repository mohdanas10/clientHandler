package com.clientHandler.Service;

import com.clientHandler.Entity.TransMang;
import com.clientHandler.Repository.TransitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransitionService {

    @Autowired
    private TransitionRepo transitionRepo;

    public TransMang createTransition(TransMang ts ){
        List<TransMang> transMangs = (List<TransMang>) this.transitionRepo.findByName(ts.getName());
        Collections.reverse(transMangs);

        if(transMangs.size() == 0){
            ts.setReminAmount(ts.getTotalAmount() - ts.getCreditAmount());
           return this.transitionRepo.save(ts);
        }
        else {
            TransMang t = transMangs.get(0);
            ts.setReminAmount(t.getReminAmount() -ts.getCreditAmount());
            return this.transitionRepo.save(ts);
        }
    }

    public List<TransMang> getTransitionByName(String n ){
        List<TransMang> list = this.transitionRepo.findByName(n);
        System.out.println(list);
        Collections.reverse(list);
        return list;
    }

    public TransMang updateTransition(int id, TransMang transMang){
        TransMang clientById = this.transitionRepo.findById(id);
        if(clientById.getId() == id){
            clientById.setCreditAmount(transMang.getCreditAmount());
            clientById.setReminAmount(transMang.getReminAmount());
            clientById.setTotalAmount(transMang.getTotalAmount());
            clientById.setLocalDate(transMang.getLocalDate());
//            clientById.setLocalTime(transMang.getLocalTime());
        }
        return clientById;
    }

    public List<TransMang> startsNames (String name ){
        List<TransMang> list = (List<TransMang>) this.transitionRepo.findByName(name);
        System.out.println(list);

//        List<TransMang> filterList = list.stream().filter(e->e.getName().startsWith(Names)).collect(Collectors.toList());
//        Collections.reverse(filterList);
//        List<TransMang> t  = new ArrayList<>();
//         list.forEach( e->{
//             t.add(e);
//         });
//         Collections.reverse(t);

        Collections.reverse(list);
        System.out.println(list);
        return list;
    }

    public TransMang getAllCST (int id ){
         return this.transitionRepo.findById(id);
    }

    public void deleteTrans(String name ){
        List<TransMang> transMangs = (List<TransMang>) this.transitionRepo.findByName(name);
//        List<TransMang> list = transMangs.stream().filter(e -> e.getName().startsWith(name)).collect(Collectors.toList());
        transMangs.forEach(e ->{
            this.transitionRepo.delete(e);
        });

    }

    public List<TransMang> getTransition(String name ){
        List<TransMang> list  = (List<TransMang>) this.transitionRepo.findByName(name);
        System.out.println(list);
        return list;
    }


}
