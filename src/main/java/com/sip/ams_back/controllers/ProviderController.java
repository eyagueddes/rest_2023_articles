package com.sip.ams_back.controllers;

import com.sip.ams_back.entities.Provider;
import com.sip.ams_back.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/providers","/hom*"})
@CrossOrigin(origins="*")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/")
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PostMapping("/add")
    public Provider createProvider(@Valid @RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    @PutMapping("/{providerId}")
    public Provider updateProvider(@PathVariable Long providerId, @Valid @RequestBody Provider providerRequest) {
     return providerService.updateProvider(providerId,providerRequest);
    }


    @DeleteMapping("/{providerId}")
    public Provider deleteProvider(@PathVariable Long providerId) {
        return providerService.deleteProvider(providerId);
    }

    @GetMapping("/{providerId}")
    public Provider getProvider(@PathVariable Long providerId) {

      return providerService.getOneProviderById(providerId);

    }
}