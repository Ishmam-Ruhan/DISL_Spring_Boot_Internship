package com.ishmamruhan.DislAssignmentOne.Dao.CustomDaoImplementations;

import com.ishmamruhan.DislAssignmentOne.Dao.CustomContactRepo;
import com.ishmamruhan.DislAssignmentOne.Entity.ContactEntity.Contact;
import com.ishmamruhan.DislAssignmentOne.Entity.ContactEntity.ContactSearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomContactRepoImpl implements CustomContactRepo {

    private final EntityManager entityManager;

    private final CriteriaBuilder  criteriaBuilder;

    public CustomContactRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public List<Contact> getContactByCustomQuery(ContactSearchCriteria contactSearchCriteria) {

        CriteriaQuery<Contact> criteriaQuery = criteriaBuilder.createQuery(Contact.class);

        Root<Contact> criteriaRoot = criteriaQuery.from(Contact.class);

        Predicate criteriaPredicate = getPredicate(criteriaRoot, contactSearchCriteria);
        criteriaQuery.where(criteriaPredicate);

        TypedQuery<Contact> typedQuery = entityManager.createQuery(criteriaQuery);

        System.out.println("Repo: "+typedQuery.getResultList());

        return typedQuery.getResultList();
    }

    private Predicate getPredicate(Root<Contact> criteriaRoot,
                                   ContactSearchCriteria contactSearchCriteria) {

        List<Predicate> predicateList = new ArrayList<>();

        if(Objects.nonNull(contactSearchCriteria.getId())){
            predicateList.add(
                    criteriaBuilder.equal(criteriaRoot.get("id"),contactSearchCriteria.getId())
            );
        }

        if(Objects.nonNull(contactSearchCriteria.getFirstname())){
            predicateList.add(
                    criteriaBuilder.like(criteriaRoot.get("firstName"),"%"+contactSearchCriteria.getFirstname()+"%")
            );
        }
        if(Objects.nonNull(contactSearchCriteria.getLastname())){
            predicateList.add(
                    criteriaBuilder.like(criteriaRoot.get("lastName"),"%"+contactSearchCriteria.getLastname()+"%")
            );
        }
        if(Objects.nonNull(contactSearchCriteria.getEmail())){
            predicateList.add(
                    criteriaBuilder.like(criteriaRoot.get("email"),"%"+contactSearchCriteria.getEmail()+"%")
            );
        }
        if(Objects.nonNull(contactSearchCriteria.getCity())){
            predicateList.add(
                    criteriaBuilder.like(criteriaRoot.join("addressList").get("city"),"%"+contactSearchCriteria.getCity()+"%")
            );
        }
        if(Objects.nonNull(contactSearchCriteria.getState())){
            predicateList.add(
                    criteriaBuilder.like(criteriaRoot.join("addressList").get("state"),"%"+contactSearchCriteria.getState()+"%")
            );
        }
        if(Objects.nonNull(contactSearchCriteria.getZipcode())){
            predicateList.add(
                    criteriaBuilder.like(criteriaRoot.join("addressList").get("zipCode"),"%"+contactSearchCriteria.getZipcode()+"%")
            );
        }

        if(Objects.nonNull(contactSearchCriteria.getStartBirthDate()) &&
                Objects.nonNull(contactSearchCriteria.getEndBirthDate())){

            Date startDate, endDate;

            try {
                startDate = new SimpleDateFormat("dd-MM-YYYY").parse(contactSearchCriteria.getStartBirthDate());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            try {
                endDate = new SimpleDateFormat("dd-MM-YYYY").parse(contactSearchCriteria.getEndBirthDate());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            predicateList.add(
                    criteriaBuilder.between(criteriaRoot.get("birthDate"),startDate,endDate)
            );
            System.out.println("Added - birthdate");
        }
        else if(Objects.nonNull(contactSearchCriteria.getStartBirthDate()) ||
                Objects.nonNull(contactSearchCriteria.getEndBirthDate())){
            String dateString =
                    contactSearchCriteria.getStartBirthDate() == null ? contactSearchCriteria.getEndBirthDate() : contactSearchCriteria.getStartBirthDate();

            Date exactDate;

            try {
                exactDate = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            predicateList.add(
                    criteriaBuilder.equal(criteriaRoot.get("birthDate"), exactDate)
            );
        }


        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }


}
