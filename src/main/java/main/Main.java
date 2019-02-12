package main;

import bean.Cache;
import org.jnosql.artemis.key.KeyValueTemplate;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.Optional;

public class Main {
    public static void main (String[] args) {
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Cache cache = Cache.builder().key("teste").value("valor 1").build();
            Cache cache2 = Cache.builder().key("teste2").value("valor 2").build();
            KeyValueTemplate keyValueTemplate = container.select(KeyValueTemplate.class).get();
            Cache cacheSaved = keyValueTemplate.put(cache);
            Cache cacheSaved2 = keyValueTemplate.put(cache2);
            Optional<Cache> cacheFound = keyValueTemplate.get("teste",Cache.class);
            System.out.println(cacheFound.get());
            cacheFound = keyValueTemplate.get("teste2",Cache.class);
            System.out.println(cacheFound.get());
        }
    }
}
