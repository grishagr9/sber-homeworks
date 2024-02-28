package org.example;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       Worker worker = new Worker();
       var res = worker.fibonachi(9);
       var res2 = worker.fibonachi(7);
        System.out.println(res);
        System.out.println(res2);
    }
}