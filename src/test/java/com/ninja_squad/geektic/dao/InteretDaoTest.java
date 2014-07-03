package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import java.util.List;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.Interet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
public class InteretDaoTest extends BaseDaoTest {

	@Autowired
    private InteretDao dao;

    @Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(Operations.deleteAllFrom("history","geeks","interets"),
				Operations.insertInto("interets")
				.columns("id", "libelle")
				.values (1,"J2EE")
				.values (2,"C#")
				.values (3,"C")
				.values (4,"C++")
				.values (5,"JAVA")
				.values (6,".NET")
				.values (7,"PL/SQL")
				.values (8,"WEB")
				.values (9,"COBOL")
				.values (10,"ASSEMBLEUR")
				.build()); // TODO define your operations here.
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

    @Test
    public void testFindAll() {
    	//On test le nombre d'interets
        List<Interet> list = dao.findAll();
        assertEquals(10,list.size());
        //On test si un interet a un id
        long result = list.get(0).getId();
        assertEquals(1L,result);
        //On test di un interet a un libelle
        String result2 = list.get(0).getLibelle();
        assertEquals("J2EE",result2);
    }
}
