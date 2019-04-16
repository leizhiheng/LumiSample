package com.example.tangramandroid.utils;

import com.example.tangramandroid.Entity.Person;
import com.example.tangramandroid.simplelist.SimpleBean;

import java.util.ArrayList;

import me.drakeet.multitype.Items;

public class DataCreator {
    public static Items getMultiTypeItemData() {
        Items list = new Items();
        for (int i = 0; i< 10; i++) {
            list.add("Group-" + i);
            list.add(new Person("Bob", 21));
            list.add(new Person("Tom", 21));
            list.add(new Person("David", 21));
            list.add(new Person("Sum", 21));
        }
        return list;
    }

    public static ArrayList<SimpleBean> getSimpleBeans() {
        ArrayList<SimpleBean> beans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            beans.add(new SimpleBean(SimpleBean.TYPE_EMPTY));
            beans.add(new SimpleBean(SimpleBean.TYPE_IMG_NONE, "Title-" + i));
            beans.add(new SimpleBean(SimpleBean.TYPE_IMG_ARROW, "Title-" + i));
            beans.add(new SimpleBean(SimpleBean.TYPE_IMG_MENE, "Title-" + i));
            beans.add(new SimpleBean(SimpleBean.TYPE_IMG_CHOOSED, "Title-" + i));
            beans.add(new SimpleBean(SimpleBean.TYPE_IMG_CHOOSED, "Title" + i, "SubTitle-" + i, "Content-" + i));
        }
        return beans;
    }
}
