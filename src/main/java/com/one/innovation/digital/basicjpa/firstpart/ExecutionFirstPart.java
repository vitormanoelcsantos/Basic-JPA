package com.one.innovation.digital.basicjpa.firstpart;

import com.one.innovation.digital.basicjpa.classes.State;
import com.one.innovation.digital.basicjpa.classes.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutionFirstPart {
    public static void main(String[] args) {
        /**
         Esse código pode ou não funcionar de acordo com a biblioteca que foi baixada.
         Se estiver somente com o JPA baixado, o codigo não irá funcionar.
         Porém se estiver com a biblioteca de algum framework com implementacao JPA
         (Hibernate ou EclipseLink), o JPA irá automaticamente utilizá-lo.

         O ideal é que nessa parte (Parte 1) o código execute com error
         (Ao tentar executar irá mostrar um error afirmando que não foi
         encontradado nenhuma implementação do JPA).
         Pois aqui não deveria ter nenhuma implementação JPA sendo utilizada,
         apenas o JPA puro para demonstrar que através dele é possivel definir a estrutura do código
         e depois escolher a implementação que irá utilizar.
         Apenas na parte 2 será escolhida uma implementação para o código executar sem error.
         */

        // 1 - Passos iniciais para criar um gerenciador de entidades com o banco de
        // dados especificado no arquivo "persistence.xml"
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("firstpart");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        State stateToAdd = new State("Pernambuco", "PE");
        Student studentToAdd = new Student("Vitor", 21, stateToAdd);

        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(stateToAdd);
        entityManager.persist(studentToAdd);

        entityManager.getTransaction().commit();

        // 3 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();
    }
}
