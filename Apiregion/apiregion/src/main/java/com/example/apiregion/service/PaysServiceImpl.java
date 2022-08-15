package com.example.apiregion.service;

import com.example.apiregion.modele.Pays;
import com.example.apiregion.modele.Region;
import com.example.apiregion.repository.PaysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaysServiceImpl implements PaysService{

    private final PaysRepository paysRepository;
    @Override
    public Pays Ajouter(Pays pays) {
        return paysRepository.save(pays);
    }
    @Override
    public List<Pays> Lire() {
        return paysRepository.findAll();
    }

    @Override
    public Pays modifier(Long idPays, Pays pays) {
        return paysRepository.findById(idPays)
                .map(p->{
                    p.setNomPays(pays.getNomPays());
                    return paysRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Pays non trouvé !"));
    }

    @Override
    public String supprimer(Long idPays) {
        paysRepository.deleteById(idPays);
        return "Pays supprimé";
    }
}
