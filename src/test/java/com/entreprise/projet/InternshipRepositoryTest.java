package com.entreprise.projet;

import com.entreprise.projet.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InternshipRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private internshipRepository intern ;

    @Autowired
    private StudentRepo srepo ;

    @Test
    public void TestIntern(){


       Student student = new Student("supervisor", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "SUPERVISOR" , "tt","gz","sj","jz","jz","hz","dd") ;
       Supervisor supervisor = new Supervisor("supervisor", "$2a$10$g0pWFlU8Wfzvm5oXr7OzHewreRBvJfnlNuaX.xM9U7lqYT1eFDY42", "SUPERVISOR" , "tt","gz","sj","jz","jz","hz","dd");


        Internship internship = new Internship("title","entreprise","description",new Date(),new Date());
        internship.setStudent(student);
        internship.setSupervisor(supervisor);






    }
}
