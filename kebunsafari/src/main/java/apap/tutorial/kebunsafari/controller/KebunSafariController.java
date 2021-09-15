package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam (value="id", required = true) String idKebunSafari,
            @RequestParam (value = "nama", required = true) String namaKebunSafari,
            @RequestParam (value = "alamat", required = true) String alamat,
            @RequestParam (value = "noTelepon", required = true) String noTelepon,
            Model model
    ){
        //membuat objek kebun safari baru
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        //memanggil service addKebunSafari
        kebunSafariService.addKebunSafari(kebunSafari);

        //manambahkan variabel kebunSafari untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //mereturn template html yang dipakai
        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        //mendapatkan list seluruh objek kebun safari
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        //menambahkan list untuk dirender di Thymeleaf
        model.addAttribute("listKebunSafari", listKebunSafari);

        //mereturn template html yang diapakai
        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value="id", required = true) String idKebunSafari, Model model){
        //mendapatkan objek kebun safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        //menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        //mereturn template html yang dipakai
        return "detail-kebun-safari";
    }

    @GetMapping(value="/kebun-safari/view/{id}")
    public String viewKebunSafariById(@PathVariable(value="id", required = true) String idKebunSafari, Model model){
        //mendapatkan objek kebun safari sesuai dengan ID
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        //menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        return "detail-kebun-safari";
    }

    @RequestMapping("/kebun-safari/update/{id}")
    public String updateKebunSafariById(
            @PathVariable(value="id", required = true) String idKebunSafari,
            @RequestParam(value="noTelepon", required = true) String noTelepon,
            Model model)
    {

        //mengupdate nomor telepon dari objek kebun safari sesuai dengan ID
        String id = kebunSafariService.updateNomorTeleponById(idKebunSafari, noTelepon);

        //menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("id", id);


        //mereturn template html yang dipakai
        return "update-kebun-safari";
    }

    @RequestMapping("/kebun-safari/delete/{id}")
    public String deleteKebunSafariById(
            @PathVariable(value="id", required = true) String idKebunSafari, Model model
    ){
        //mendelete objek kebun safari sesuai dengan ID
        String id = kebunSafariService.deleteKebunSafariById(idKebunSafari);

        //menambahkan objek untuk dirender di Thymeleaf
        model.addAttribute("id", id);

        return "delete-kebun-safari";
    }

}
