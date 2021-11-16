package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.rest.PegawaiDetail;
import reactor.core.publisher.Mono;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.repository.CabangDb;
import apap.tutorial.emsidi.rest.CabangDetail;
import apap.tutorial.emsidi.rest.Setting;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    private final WebClient webClient;

    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai= pegawaiDb.findByNoPegawai(noPegawai);
        if(pegawai.isPresent()){
            return pegawai.get();
        }
        return null;
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);

        if((now.isBefore(pegawai.getCabang().getWaktuBuka())|| now.isAfter(pegawai.getCabang().getWaktuTutup()))){
            pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
            pegawai.setCabang(pegawaiUpdate.getCabang());
            pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());
            return pegawaiDb.save(pegawai);
        }
        else {
            throw new UnsupportedOperationException();
        }
//        return null;
    }

    @Override
    public void deletePegawai(Long noPegawai) {
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();

        if((now.isBefore(cabang.getWaktuBuka())|| now.isAfter(cabang.getWaktuTutup()))){
            pegawaiDb.delete(pegawai);
        }
        else {
            throw new UnsupportedOperationException();
        }
    }


    public PegawaiRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.agify.io?name=").build();
    }


    public PegawaiModel getUmurPegawai(Long noPegawai) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        String namaPegawaiCustom;
        if(pegawai.getNamaPegawai().split(" ").length>1){
            namaPegawaiCustom = pegawai.getNamaPegawai().split(" ")[0];
        }
        else{
            namaPegawaiCustom = pegawai.getNamaPegawai();
        }
        HashMap hashMapUmur = webClient.get().uri("https://api.agify.io/?name="+ namaPegawaiCustom).retrieve().bodyToMono(HashMap.class).block();
        Integer umurPegawai = Integer.parseInt(hashMapUmur.get("age").toString());
        pegawai.setUmur(umurPegawai);
        return pegawai;
    }

    @Override
    public List<PegawaiModel> retrieveListPegawaibyJenisKelamin(int jenisKelamin) {
            return pegawaiDb.findByJenisKelamin(jenisKelamin);

    }

}
