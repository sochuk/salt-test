package com.salt.salttest.controller.rest;

import com.salt.salttest.dto.CustomResponse;
import com.salt.salttest.dto.KonsumenReqDTO;
import com.salt.salttest.model.Konsumen;
import com.salt.salttest.service.IKonsumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/konsumen")
public class KonsumenRestController {

    @Autowired
    IKonsumenService konsumenService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Konsumen> listKonsumen() {
        return konsumenService.findAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addKonsumen(@RequestBody KonsumenReqDTO req) {
       try {
           CustomResponse response = new CustomResponse(true, HttpStatus.OK.getReasonPhrase());
           konsumenService.updateOrSaveKonsumen(req);
           return ResponseEntity.ok(response);
       }catch (Exception ex){
           CustomResponse response = new CustomResponse(false, ex.getMessage());
           return ResponseEntity.ok(response);
       }
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<?> getDataById(@PathVariable("id") Integer id) {
        try {
            Optional<Konsumen> konsumenOpt = konsumenService.getKonsumenById(id);
            if(konsumenOpt.isPresent()) {
                CustomResponse response = new CustomResponse(true, HttpStatus.OK.getReasonPhrase(), konsumenOpt.get());
                return ResponseEntity.ok(response);
            }else{
                CustomResponse response = new CustomResponse(true, HttpStatus.OK.getReasonPhrase());
                return ResponseEntity.ok(response);
            }
        }catch (Exception ex){
            CustomResponse response = new CustomResponse(false, ex.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteKonsumen(@PathVariable("id") Integer id) {
        try {
            CustomResponse response = new CustomResponse(true, HttpStatus.OK.getReasonPhrase());
            konsumenService.deleteKonsumen(id);
            return ResponseEntity.ok(response);
        }catch (Exception ex){
            CustomResponse response = new CustomResponse(false, ex.getMessage());
            return ResponseEntity.ok(response);
        }
    }
}
