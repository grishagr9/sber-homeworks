package org.example;

import java.util.List;

interface Source {
    List<Integer> getData(int i);
    void saveData(int i, List<Integer> data);
}