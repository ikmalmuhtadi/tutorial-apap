package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService {
    @Autowired
    PegawaiDb pegawaiDb;

    @Override
    public void addPegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    @Override
    public boolean updatePegawai(PegawaiModel pegawai) {
        CabangModel cabang = pegawai.getCabang();
        LocalTime timeNow = LocalTime.now();
        if(cabang.getWaktuBuka().isAfter(cabang.getWaktuTutup())) {
            if(timeNow.isBefore(cabang.getWaktuBuka()) && timeNow.isAfter(cabang.getWaktuTutup())) {
                pegawaiDb.save(pegawai);
                return true;
            } else {
                return false;
            }
        } else {
            if(timeNow.isAfter(cabang.getWaktuTutup()) || timeNow.isBefore(cabang.getWaktuBuka())) {
                pegawaiDb.save(pegawai);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        if(pegawai.isPresent()){
            return pegawai.get();
        }
        return null;
    }

    @Override
    public boolean deletePegawai(PegawaiModel pegawai) {
        CabangModel cabang = pegawai.getCabang();
        LocalTime timeNow = LocalTime.now();
        if(cabang.getWaktuBuka().isAfter(cabang.getWaktuTutup())) {
            if(timeNow.isBefore(cabang.getWaktuBuka()) && timeNow.isAfter(cabang.getWaktuTutup())) {
                pegawaiDb.delete(pegawai);
                return true;
            } else {
                return false;
            }
        } else {
            if(timeNow.isAfter(cabang.getWaktuTutup()) || timeNow.isBefore(cabang.getWaktuBuka())) {
                pegawaiDb.delete(pegawai);
                return true;
            } else {
                return false;
            }
        }
    }

}
