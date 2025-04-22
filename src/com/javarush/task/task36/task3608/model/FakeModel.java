package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model{
    private ModelData modelData = new ModelData();
    private List<User> users = new ArrayList<>();
    {
        users.add(new User("kolya", 1, 123));
        users.add(new User("sanya", 2, 3));
    }
    @Override
    public void loadUsers() {
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUserById(long UserId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }
}