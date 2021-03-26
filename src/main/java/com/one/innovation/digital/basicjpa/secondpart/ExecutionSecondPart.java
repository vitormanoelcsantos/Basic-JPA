package com.one.innovation.digital.basicjpa.secondpart;

import com.one.innovation.digital.basicjpa.classes.State;
import com.one.innovation.digital.basicjpa.classes.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionSecondPart {
    public static void main(String[] args) {
        /**
         OBS: Esse codigo deve executar sem erros com a implementação
         JPA que foi definida no "persistence.xml".
         Se estiver somente com o JPA baixado, o código não irá funcionar.

         O ideal é que nessa parte (Parte 2) o codigo execute sem erros,
         pois aqui tera uma implementação JPA sendo utilizada.
         */

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de
        // dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("secondpart");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instâncias para serem adicionadas no banco de dados.
        State stateToAdd = new State("Pernambuco", "PE");
//        State stateToAdd2 = new State("Rio de Janeiro", "RJ");
        Student studentToAdd = new Student("Eduarda", 18, stateToAdd);
        Student studentToAdd2 = new Student("Vitor", 22, stateToAdd);
        Student studentToAdd3 = new Student("Ana Paula", 54, stateToAdd);
//        Student studentToAdd4 = new Student("Eduardo Henrique", 5, stateToAdd2);

        // 2.2 - Iniciar uma trasação para adiconar as instâncias no banco de dados.
        entityManager.getTransaction().begin();

        entityManager.persist(stateToAdd);
        entityManager.persist(studentToAdd);
        entityManager.persist(studentToAdd2);
        entityManager.persist(studentToAdd3);
//        entityManager.persist(studentToAdd4);


        entityManager.getTransaction().commit();

        // 3 - Resgatar instâncias no banco de dados.

        State stateFound = entityManager.find(State.class, 1);
        Student studentFound = entityManager.find(Student.class, 1);

        System.out.println();
        System.out.println(stateFound);
        System.out.println(studentFound);
        System.out.println();

        // 4 - Alterar uma entidade.
        entityManager.getTransaction().begin();

        studentFound.setName("Ralf");
        studentFound.setAgesold(9);

        entityManager.getTransaction().commit();

        // 5 - Remover uma entidade.
        entityManager.getTransaction().begin();

        entityManager.remove(studentFound);

        entityManager.getTransaction().commit();

        //6 - Encerrar o gerenciador de entidades e encerrar a fábrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }
}
