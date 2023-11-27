package com.clientHandler.Repository;
import com.clientHandler.Entity.Client;
import com.clientHandler.Entity.TransMang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.comments.CommentLine;

@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {
   public Client findById(int Clientid );
//   public Client findByClientName (String clientName );

}
