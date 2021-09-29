package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.CabangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CabangServiceImpl implements CabangService{

    @Autowired
    CabangDb cabangDb;

    @Override
    public void addCabang(CabangModel cabang) {
        cabangDb.save(cabang);
    }

//    @Override
//    public void updateCabang(CabangModel cabang) {
//        cabangDb.save(cabang);
//
//    }

    @Override
    public boolean updateCabang(CabangModel cabang) {
        if(cabangDb.findByNamaCabang(cabang.getNamaCabang()) == null){
            cabangDb.save(cabang);
            return true;
        }
        return false;

    }

    @Override
    public List<CabangModel> getCabangList() {
        return cabangDb.findAll();
    }

    @Override
    public List<CabangModel> getSortedCabangList() {
        return cabangDb.findAll(Sort.by(Sort.Direction.ASC,"namaCabang"));
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang) {
        Optional<CabangModel> cabang= cabangDb.findByNoCabang(noCabang);
        if(cabang.isPresent()){
            return cabang.get();
        }
        return null;
    }

    @Override
    public CabangModel getCabangByNamaCabang(String namaCabang) {
        Optional<CabangModel> cabang= cabangDb.findByNamaCabang(namaCabang);
        if(cabang.isPresent()){
            return cabang.get();
        }
        return null;
    }

    @Override
    public boolean deleteCabang(CabangModel cabang) {

        LocalTime timeNow = LocalTime.now();

            if(cabang.getWaktuBuka().isAfter(cabang.getWaktuTutup())) {
                System.out.println("Masuk IF 1");
                if(timeNow.isBefore(cabang.getWaktuBuka()) && timeNow.isAfter(cabang.getWaktuTutup())) {
                    System.out.println("Masuk IF 2");
                    if(cabang.getListPegawai().isEmpty()) {
                        System.out.println("Masuk IF 3");
                        cabangDb.delete(cabang);
                        return true;
                    }
                } else {
                    System.out.println("Masuk ELSE DR IF 1");
                    return false;
                }
            } else {
                System.out.println("Masuk ELSE 1");
                if(timeNow.isAfter(cabang.getWaktuTutup()) || timeNow.isBefore(cabang.getWaktuBuka())) {
                    System.out.println("Masuk IF 1 DR ELSE 1");
                    if(cabang.getListPegawai().isEmpty()) {
                        System.out.println("Masuk IF 2 DR ELSE 1");
                        cabangDb.delete(cabang);
                        return true;
                    }
                } else {
                    System.out.println("Masuk ELSE DR ELSE 1");
                    return false;
                }
            }
        System.out.println("GA MASUK MANA-MANA");
            return false;
    }
}
