package com.mysterioustrousers.firehose;



import org.apache.commons.collections4.map.MultiKeyMap;



public class FHObjectFactory {

  // region Singleton Implementation

  private static FHObjectFactory s_instance = null;


  public static FHObjectFactory getInstance() {
    if (s_instance == null) {
      s_instance = new FHObjectFactory();
    }
    return s_instance;
  }

  // endregion



  private MultiKeyMap<Object, FHObject> _cache;



  private FHObjectFactory() {
    _cache = new MultiKeyMap<Object, FHObject>();
  }



  public <T extends FHObject> T createFromId(Class<T> clazz, Object id) throws InstantiationException, IllegalAccessException {
    if (id == null) {
      throw new IllegalArgumentException("id cannot be null!");
    }

    if (_cache.containsKey(clazz, id)) {
      return (T)_cache.get(clazz, id);
    }

    T obj = clazz.newInstance();
    obj.setId(id);

    _cache.put(clazz, id, obj);

    return obj;
  }
}