package com.example.demo.Controllers;

import com.example.demo.Catalog.Wood;
import com.example.demo.Catalog.WoodContainer;
import com.example.demo.DB.DataBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class AdminPanel {
    DataBase db = new DataBase();
    WoodContainer wc ;
    Model model;
    String Db_Text = "";
    @GetMapping("/AdminPanel")
    public String AdminPanel(Model model) {
        if(wc!=null) {
            model.addAttribute("names", wc);
            model.addAttribute("Db_Text", wc.size());
        }
        this.model = model;

        return "AdminTestPanel";
    }
    @RequestMapping(value="/db-connect")
    public String db_connect() {
        db.Connect();
        return "redirect:/AdminPanel";
    }
    @RequestMapping(value = "/db-update")
    public String db_update() throws SQLException {
        wc = db.Update();
        return "redirect:/AdminPanel";
    }
    @RequestMapping(value = "/db-print")
    public String db_print(Model model1){

        return "redirect:/AdminPanel";
    }
    @RequestMapping(value = "/db-addWood")
    public String db_addWood() throws SQLException {
        wc.Random(5);
        db.Update(wc);
    return "redirect:/AdminPanel";
    }
    @RequestMapping(value = "/db-close")
    public String db_close() throws SQLException {
        db.CloseDB();
        return "redirect:/AdminPanel";
    }


}
