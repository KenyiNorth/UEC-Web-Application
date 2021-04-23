package com.kenyi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurchService {
    private ChurchRepository repository;

    @Autowired
    public ChurchService ( ChurchRepository repository){
        this.repository = repository;
    }
   public ChurchModel save(ChurchModel churchModel){
        churchModel.setName(churchModel.getName());
        churchModel.setEmail(churchModel.getEmail());
        churchModel.setComment(churchModel.getComment());
        return repository.save(churchModel);
   }
   public List<ChurchModel> findAll(){
       return repository.findAll();
   }
   public ChurchModel updateModel(ChurchModel churchModel){
        repository.findById(churchModel.getId());
        churchModel.setName(churchModel.getName());
        churchModel.setEmail(churchModel.getEmail());
        churchModel.setComment(churchModel.getComment());
        return repository.save(churchModel);

   }
   public void deleteById(Long id){
        repository.deleteById(id);
   }

}
