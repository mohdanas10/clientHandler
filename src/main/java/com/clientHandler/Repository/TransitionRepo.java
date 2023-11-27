package com.clientHandler.Repository;

import com.clientHandler.Controller.TransManagement;
import com.clientHandler.Entity.TransMang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransitionRepo extends JpaRepository<TransMang, Integer> {
    public TransMang findById(int id);
    public List<TransMang> findByName(String name );
//    public TransMang findByName(String name);

}
