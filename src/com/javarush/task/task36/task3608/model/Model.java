package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface Model {
    ModelData modelData = new ModelData();
    ModelData getModelData();

    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long UserId);
    void deleteUserById(long id);

}

