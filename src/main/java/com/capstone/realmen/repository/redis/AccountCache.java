package com.capstone.realmen.repository.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCache extends CrudRepository<AccountEntityRedis, String>{
    
}
