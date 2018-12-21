package org.almansa.app.java.library.ehcache;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.junit.Test;

public class EhCacheTest {

	@Test
	public void ehcache_캐시설정() {
		try (CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build()) {
			cacheManager.init();

			Cache<Long, String> myCache = cacheManager.createCache("myCache", CacheConfigurationBuilder
					.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)));

			myCache.put(1L, "HelloWorld");

			assertEquals("HelloWorld", myCache.get(1L));
		}
	}

	@Test
	public void ehcache_캐시설정2() {

		try (CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build()) {
			cacheManager.init();

			Cache<Long, String> myCache = cacheManager.createCache("myCache", CacheConfigurationBuilder
					.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)));

			myCache.put(1L, "HelloWorld1");
			myCache.put(2L, "HelloWorld2");
			myCache.put(3L, "HelloWorld3");
			myCache.put(4L, "HelloWorld4");
			myCache.put(5L, "HelloWorld5");
			myCache.put(6L, "HelloWorld6");
			myCache.put(7L, "HelloWorld7");
			myCache.put(8L, "HelloWorld8");
			myCache.put(9L, "HelloWorld9");
			myCache.put(10L, "HelloWorld10");
			myCache.put(11L, "HelloWorld11");
			myCache.put(12L, "HelloWorld12");

			myCache.forEach((item) -> {
				String value = item.getValue();
				System.out.println(value);
			});
		}
	}
}
