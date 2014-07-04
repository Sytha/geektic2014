package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.dao.HistoryDao;
import com.ninja_squad.geektic.dao.InteretDao;
import com.ninja_squad.geektic.Geek;
import com.ninja_squad.geektic.Interet;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
* Fake service just to test that everything works fine
* @author JB Nizet
*/
@RestController
@Transactional
@RequestMapping("/api")
public class GeekticService {

	@Autowired
	private InteretDao daoInteret;
	
	@Autowired
	private GeekDao daoGeek;
	
	@Autowired
	private HistoryDao daoHistory;
	
	@RequestMapping(value="/interetsList")
    public List<Interet> getListInterets() {
        return daoInteret.findAll();
    }
	
	@RequestMapping(value="/search",params = {"sexe", "interet"})
    public @ResponseBody List<Geek> getResultsList(@RequestParam(value="sexe") String sexe,@RequestParam(value="interet") String interet){
		if(sexe.equals("A")){
			return daoGeek.findByInteret(interet);
		}else{
			return daoGeek.findBySexeInteret(sexe, interet);
		}
    }
	
	@RequestMapping(value="/geek/{id}")
    public Geek getGeekProfile(@PathVariable Long id,HttpServletRequest request){
		String ip = request.getRemoteAddr();
		Geek geek = daoGeek.findById(id);
		daoHistory.addHistoryById(geek,ip);
		return geek;
    }
	
	@RequestMapping(value="/history/{id}")
    public int getGeekCountHistory(@PathVariable Long id){
		return daoHistory.findCountGeekHistoryById(id);
    }
}