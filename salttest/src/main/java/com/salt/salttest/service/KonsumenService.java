package com.salt.salttest.service;

import com.salt.salttest.dto.KonsumenReqDTO;
import com.salt.salttest.model.Konsumen;
import com.salt.salttest.repository.KonsumenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KonsumenService implements IKonsumenService{

    @Autowired
    private KonsumenRepo konsumenRepo;

    @Override
    public List<Konsumen> findAll() {
        return konsumenRepo.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<Konsumen> getKonsumenByNama(String nama) {
        return konsumenRepo.findByNama(nama);
    }

    @Override
    public Optional<Konsumen> getKonsumenById(long id) {
        return konsumenRepo.findById(id);
    }

    @Override
    public void updateOrSaveKonsumen(KonsumenReqDTO request) {
        if(request.getId() == null){
            Konsumen konsumen =  new Konsumen();
            konsumen.setNama(request.getNama());
            konsumen.setAlamat(request.getAlamat());
            konsumen.setKota(request.getKota());
            konsumen.setProvinsi(request.getProvinsi());
            konsumen.setTglRegistrasi(request.getTglRegistrasi());
            konsumen.setStatus(request.getStatus());
            konsumenRepo.save(konsumen);
        }else{
            Optional<Konsumen> konsumenOpt = konsumenRepo.findById(request.getId());
            if(konsumenOpt.isPresent()){
                Konsumen konsumen = konsumenOpt.get();
                konsumen.setNama(request.getNama());
                konsumen.setAlamat(request.getAlamat());
                konsumen.setKota(request.getKota());
                konsumen.setProvinsi(request.getProvinsi());
                konsumen.setTglRegistrasi(request.getTglRegistrasi());
                konsumen.setStatus(request.getStatus());
                konsumenRepo.save(konsumen);
            }
        }
    }

    @Override
    public void deleteKonsumen(long id) {
        Optional<Konsumen> konsumenOpt = konsumenRepo.findById(id);
        if (konsumenOpt.isPresent()) {
            konsumenRepo.delete(konsumenOpt.get());
        }
    }
}
