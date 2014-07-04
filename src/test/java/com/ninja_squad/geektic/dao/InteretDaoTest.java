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
    	Operation operation = Operations.sequenceOf(Operations.deleteAllFrom("geeks_interets","history", "geeks","interets"),
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
				.build(),
	Operations.insertInto("geeks")
				.columns("id", "nom", "prenom","sexe","age","ville","interet","mail","gravatar")
				.values(1,"Jean", "Bloux", "H", 21, "Lyon", 5 ,"jb@yopmail.fr","http://humourger.com/femmesmoches/Femme_a_barbe_moche.jpg")
				.values(2,"Jeanne", "Elléou", "F", 19, "Paris", 2, "je@yopmail.fr","http://www.partfaliaz.com/wp-content/uploads/2011/02/jaimie-warren-2.jpg")
				.values(3,"Marc", "Iccy", "H", 23, "Roubaix", 5, "mi@yopmail.fr","http://us.cdn3.123rf.com/168nwm/alexis84/alexis841404/alexis84140400922/27774501-portrait-de-drole-d-39-expression-brandissant-pouces-sur-fond-jaune.jpg")
				.values(4,"Pierre", "Duroux", "H", 22, "Lyon", 6, "pd@yopmail.fr","http://static1.purepeople.com/articles/1/33/86/1/@/234360-cyril-hanouna-620x0-2.jpg")
				.values(5,"Marc", "Hamil", "H", 60, "Loin-loin-ya-longtemps", 10 ,"mh@yopmail.fr","http://static.tvtropes.org/pmwiki/pub/images/mark_hamill.jpg")
				.build(),
	Operations.insertInto("history")
				.columns("id", "date", "geek")
				.values(1,"2014-07-03 13:12:23",1)
				.values(2,"2014-07-03 13:12:23",1)
				.values(3,"2014-07-03 13:12:23",3)
				.values(4,"2014-07-03 13:12:23",4)
				.values(5,"2014-07-03 13:12:23",5)
				.values(6,"2014-07-03 13:12:23",4)
				.values(7,"2014-07-03 13:12:23",3)
				.values(8,"2014-07-03 13:12:23",1)
				.values(9,"2014-07-03 13:12:23",2)
				.values(10,"2014-07-03 13:12:23",2)
				.values(11,"2014-07-03 13:12:23",5)
				.values(12,"2014-07-03 13:12:23",1)
				.values(13,"2014-07-03 13:12:23",2)
				.values(14,"2014-07-03 13:12:23",2)
				.values(15,"2014-07-03 13:12:23",1)
				.values(16,"2014-07-03 13:12:23",2)
				.build(),
	Operations.insertInto("geeks_interets")
    			.columns("geek_id","interet_id")
    			.values (1,1)
    			.values (1,3)
    			.values (1,4)
    			.values (1,10)
    			.values (2,1)
    			.values (2,5)
    			.values (3,1)
    			.values (3,2)
    			.values (3,3)
    			.values (4,1)
    			.values (5,6)
    			.values (5,3)
    			.values (5,7)
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
