package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.InteretDao;
import com.ninja_squad.geektic.Interet;

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
	
	@RequestMapping(value="/interetsList")
    public List<Interet> sayHello() {
        return daoInteret.findAll();
    }
}