package com.ishmamruhan.JpaAndEntityManagerPractice.ServiceImpl;

import com.ishmamruhan.JpaAndEntityManagerPractice.Dao.UserDao;
import com.ishmamruhan.JpaAndEntityManagerPractice.Entity.MyUser;
import com.ishmamruhan.JpaAndEntityManagerPractice.Service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @PersistenceContext
    private final EntityManager entityManager;


    @Autowired
    private UserDao userDao;

    public UserServiceImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void playWithEntityManager() throws RuntimeException{
        MyUser user = new MyUser();
        user.setName("ishmam");
        user.setEmail("email@email.com");
        user.setPhones(List.of("01709266053","01303536163"));

        entityManager.persist(user);
        entityManager.flush();

        try {
            throw new RuntimeException("Exception Occured!");
        }catch (Exception ex){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        //entityManager.flush();

       user.setName("ruhan");

        Pageable defaultPage = PageRequest.of(0,5);

        Specification<MyUser> specification =
                Specification.where(one())
                        .and(two())
                                .and(three(true));

        userDao.findAll(specification, defaultPage);
    }

    static Specification<MyUser> one(){
        return (root, query, builder) -> {
            return builder.equal(root.get("abc"),"abc");
        };
    }

    static Specification<MyUser> two(){
        return (root, query, builder) -> {
            return builder.equal(root.get("abc"),"abc");
        };
    }
    static Specification<MyUser> three(Boolean... isNot){

        Boolean notPresent = isNot.length >= 1 ? isNot[0] : true;

        return (root, query, builder) -> {
            return builder.equal(root.get("abc"),"abc");
        };
    }
}
