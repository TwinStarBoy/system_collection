package crm_mgr_test.repository;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import crm_mgr_test.domain.MgrToken;

//import com.michaelcgood.model.Movie;
//import com.michaelcgood.repository.RedisRepository;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    
	private static final String KEY = "Token";    
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    
    public void add(final MgrToken token) {
        hashOperations.put(KEY, token.getManagerid(), token.getToken());
    }

    public void delete(final int managerid) {
        hashOperations.delete(KEY, managerid);
    }
    
    public UUID findToken(final int managerid){
        return (UUID) hashOperations.get(KEY, managerid);
    }
    
    public Map<Object, Object> findAllTokens(){
        return hashOperations.entries(KEY);
    }

}
