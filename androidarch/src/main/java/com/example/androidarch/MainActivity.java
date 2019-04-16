package com.example.androidarch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            persons.add(new Person("Name-" + i));
        }

        swap(persons, 0, 4);
        for (int i = 0; i < persons.size(); i++) {
            Log.d("zhiheng", "name: " + persons.get(i).name);
        }

        //notify nothing
        //master c3
    }

    public void swap(List<Person> items, int s, int t) {
        Person p = items.get(s);
        items.set(s, items.get(t));
        items.set(t, p);
    }

    public void swapItems(List<Person> items, int fromPosition, int targetPosition) {
        if (fromPosition > targetPosition) {
            for (int i = fromPosition; i < targetPosition; i++) {
                Collections.swap(items, i, i + 1);// 改变实际的数据集
            }
        } else {
            for (int i = fromPosition; i > targetPosition; i--) {
                Collections.swap(items, i, i - 1);// 改变实际的数据集
            }
        }
    }

    class Person{
        String name;
        int age;

        public Person(String name) {
            this.name = name;
        }
    }
}
