package com.reviewQueue.data.repositories;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.reviewQueue.data.IncrementedId;
import com.reviewQueue.model.Entity;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: rupert bates
 * Date: 26/01/11
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public class Repository<T extends Entity> {
    //properties
    private static Configuration _config = null;
    private static ObjectContainer _oc = null;
    protected static String _dbFilePath;
    protected Class<T> tClass;
    //constructors
    public Repository(String dbFilePath)
    {
        this(dbFilePath, Db4o.newConfiguration());

    }
    public Repository(String dbFilePath, Configuration config)
    {
        _dbFilePath = dbFilePath;
        _config = config;
        tClass = (Class<T>) ((ParameterizedType) getClass()
                                        .getGenericSuperclass()).getActualTypeArguments()[0];

    }

    //ObjectContainer stuff

    protected ObjectContainer db(){
    	try {
    		if(_oc == null || _oc.ext().isClosed())
    			_oc = Db4o.openFile(_config, _dbFilePath);
    		return _oc;
    	} catch (Exception e) {
        	return null;
        }
    }
    public void close() {
    	if(_oc != null){
    		_oc.close();
    		_oc = null;
    	}
    }
    public void commit(){
    	db().commit();
    }

    public void rollback(){
    	db().rollback();
    }

    public void save(T entity) {
    	if(entity.Id == 0)
    		entity.Id = getNextId();
    	db().store(entity);
	    db().commit();
    }
    public List<T> getAll()
    {
        return db().query(tClass);
    }
    public T getById(int id)  throws IllegalAccessException, InstantiationException
    {
        T example = tClass.newInstance();
        example.Id = id;
        List<T> results = db().queryByExample(example);
        if(results.size() == 0) return null;
        return results.get(0);
    }


    //File operations
    public void deleteDatabase(){
    	close();
    	new File(_dbFilePath).delete();
    }
    public void backup(String path){
    	db().ext().backup(path);
    }

    public void restore(String path){
    	deleteDatabase();
    	new File(path).renameTo(new File(_dbFilePath));
    	new File(path).delete();
    }



    public int getNextId() {
		ObjectSet<IncrementedId> result = db().queryByExample(IncrementedId.class);
		IncrementedId ii = null;
		int nextId;
		if(result.hasNext()){
			ii = (IncrementedId)result.next();
		}
		else{
			ii = new IncrementedId();
		}
		nextId = ii.getNextID();
		db().store(ii);
		return nextId;
	}
}
