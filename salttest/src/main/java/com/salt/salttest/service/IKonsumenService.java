package com.salt.salttest.service;

import com.salt.salttest.dto.KonsumenReqDTO;
import com.salt.salttest.model.Konsumen;

import java.util.List;
import java.util.Optional;

public interface IKonsumenService {
    List<Konsumen> findAll();
    Optional<Konsumen> getKonsumenByNama(String nama);

    Optional<Konsumen> getKonsumenById(long id);

    void updateOrSaveKonsumen(KonsumenReqDTO request);

    void deleteKonsumen(long id);

}
