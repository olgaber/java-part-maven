package com.academy.Lesson14.task6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<Long, Subscriber> subscribers = new HashMap<>();

    public Map<Long, Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Map<Long, Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    // возвращает абонентa по id
    public Subscriber getById(long id){

        if (subscribers.containsKey(id)){
            return subscribers.get(id);
        } return null;
    }
}

/*    // возвращает всех абонентов
    public List<Subscriber> getAll(){

        return ;
    }

    // возвращает абонентов из указанного диапазона
    public List<Subscriber> getByRange(long from, long to, Comparator sort){


        return subscriber;
    }

    // возвращает абонента по номеру телефона
    public Subscriber getByPhoneNumber(String phoneNumber){


        return subscriber;
    }

    // добавляет нового абонента, возвращает false, если абонент уже есть
    public boolean addSubscriber(Subscriber subscriber){

        return true;
    }

    // удаляет абонента по id, возвращает false, если такого не существует
    public boolean removeSubscribert(long id){


        return true;
    }

    // меняет поля абонента по полю id,
    // возвращает false, если с таки id абонент не найден.
    // Бросает исключение, если параметр id не совпадает с полем subscriber.id;

    public boolean updateSubscriber(long id, Subscriber subscriber){


        return true;

    }



    public void print (Subscriber subscriber){


    }
    */





