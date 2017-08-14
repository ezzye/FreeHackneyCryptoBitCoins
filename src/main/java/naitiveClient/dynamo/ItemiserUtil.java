package naitiveClient.dynamo;

import com.amazonaws.services.dynamodbv2.document.Item;
import naitiveClient.model.Mappable;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class ItemiserUtil {

    public static class Itemiser {
        private final Item item;

        public Itemiser(Item item) {
            this.item = item;
        }

        public <T> Itemiser ifPresent(T t, BiFunction<Item, T, Item> addOnPresent) {
            boolean isPresent = isPresent(t);
            if (isPresent) {
                addOnPresent.apply(this.item, t);
            }
            return this;
        }

        public Item build() {
            return item;
        }

        // for an item,
        // builds a two input, one output function from a string parameter
        // the function takes an item and String value and adds the value as an attribute to the item with the parameter as key
        public static BiFunction<Item, String, Item> addString(String key) {
          return (item, val) -> item.withString(key, val);
        }

        // for an item,
        // builds a two input, one output function from a string parameter
        // the function takes an item and Long value and adds the value as an attribute to the item with the parameter as key
        public static BiFunction<Item, Long, Item> addLong(String key) {
            return (item, val) -> item.withLong(key, val);
        }

        // for an item,
        // builds a two input, one output function from a string parameter
        // the function takes an item and int value and adds the value as an attribute to the item with the parameter as key
        public static BiFunction<Item, Integer, Item> addInt(String key) {
            return (item, val) -> item.withInt(key, val);
        }

        public static <T extends Mappable> BiFunction<Item, List<T>, Item> addList(String key) {
            return (item, val) -> {
                List<Map<String, Object>> list = new ArrayList<>();
                for (T t : val) {
                    Map<String, Object> stringObjectMap = t.toMap();
                    list.add(stringObjectMap);
                }
                return item.withList(key, list);
            };
        }

        public static BiFunction<Item, List<String>, Item> addStringList(String key) {
            return (item, vals) -> {
                List<String> list = new ArrayList<>();
                for (String  val: vals) {
                    list.add(val);
                }
                return item.withList(key, list);
            };
        }

        private <T> boolean isPresent(T t) {
            if (t instanceof String) {
                return StringUtils.isNotBlank((String) t);
            } else {
                return t != null;
            }
        }
    }
}
