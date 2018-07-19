package crm_mgr_test.repository;

import java.util.Map;
import java.util.UUID;

import crm_mgr_test.domain.MgrToken;

public interface RedisRepository {

    /**
     * Return all Manager-Token pairs
     */
	
    Map<Object, Object> findAllTokens();

    /**
     * Add key-value pair to Redis.
     */

    void add(final MgrToken token);

    /**
     * Delete a key-value pair in Redis.
     */
    
    void delete(int mangerid);
        
    /**
     * find a Token
     */
    
    public UUID findToken(final int managerid);
    
}
