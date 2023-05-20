package com.sip.ams_back.services;

import com.sip.ams_back.entities.Provider;
import com.sip.ams_back.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;

     public  List<Provider> getAllProviders(){
       return (List<Provider>) providerRepository.findAll();
    }
   public Provider getOneProviderById(long idProvider){
        return  providerRepository.findById(idProvider).orElseThrow(()->new IllegalArgumentException("provider id"+" "+idProvider+" "+"not found"));
    }
   public Provider saveProvider(Provider provider){
        return  providerRepository.save(provider);
    }
    public  Provider deleteProvider(long idProvider) {
        Optional<Provider> opt = providerRepository.findById(idProvider);
        if (opt.isPresent()) {
            providerRepository.delete(opt.get());

        }
        if (opt.get() == null) {
            throw new IllegalArgumentException("provider not found");

        }
        return opt.get();
    }
    public Provider updateProvider(@PathVariable Long providerId, @Valid @RequestBody Provider provider) {
         Provider temp=null;
        Optional<Provider> opt = providerRepository.findById(providerId);
        if (opt.isPresent()) {
            temp=opt.get();
            temp.setName(provider.getName());
            temp.setAddress(provider.getAddress());
            temp.setEmail(provider.getEmail());
            providerRepository.save(temp);


        }
        if (temp == null) {
            throw new IllegalArgumentException("provider not found");

        }
        return temp;
    }

}
